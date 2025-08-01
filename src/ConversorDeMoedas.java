import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;
import java.util.Map;

public class ConversorDeMoedas {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        Gson gson = new Gson();

        System.out.println("Digite a moeda base (ex: USD): ");
        String base = scanner.nextLine().toUpperCase();

        String url = "https://v6.exchangerate-api.com/v6/721250da2aeca551e0fa1982/latest/" + base;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            DadosCambio dados = gson.fromJson(response.body(), DadosCambio.class);

            int opcao;
            do {
                System.out.println("\n--- Menu de Conversão ---");
                System.out.println("1. Converter para real BRL");
                System.out.println("2. Converter para EUR");
                System.out.println("3. Converter para GBP");
                System.out.println("4. Converter para JPY");
                System.out.println("5. Converter para ARS");
                System.out.println("6. Converter para CAD");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

                if (opcao > 0 && opcao <= 6) {
                    System.out.print("Valor a converter: ");
                    double valor = scanner.nextDouble();

                    String destino = switch (opcao) {
                        case 1 -> "BRL";
                        case 2 -> "EUR";
                        case 3 -> "GBP";
                        case 4 -> "JPY";
                        case 5 -> "ARS";
                        case 6 -> "CAD";
                        default -> "";
                    };

                    double taxa = dados.conversion_rates.get(destino);
                    double convertido = valor * taxa;
                    System.out.printf("Valor convertido: %.2f %s\n", convertido, destino);
                }

            } while (opcao != 0);
        } else {
            System.out.println("Erro ao buscar dados da API. Código: " + response.statusCode());
        }
    }

    static class DadosCambio {
        Map<String, Double> conversion_rates;
    }
}

