# 💱 Conversor de Moedas com API em Java

Projeto de console interativo em Java que permite ao usuário converter valores entre diferentes moedas utilizando taxas de câmbio obtidas em tempo real por meio de uma API externa.

---

## 📌 Objetivo

Desenvolver uma aplicação Java que consome uma API para fornecer taxas de câmbio atualizadas e permita ao usuário converter moedas via terminal. O sistema apresenta um menu com pelo menos seis opções distintas de conversão de moedas.

---

## 🛠️ Tecnologias Utilizadas

- Java 21
- Biblioteca HTTP nativa do Java (`java.net.http`)
- Biblioteca externa: Gson (para parse de JSON)
- IDE: IntelliJ IDEA (sem uso de Maven)
- API de câmbio: https://api.exchangerate-api.com (ou similar)
- Chave de API: `My key`

---

## 🚀 Como a Aplicação Funciona

1. O usuário é apresentado a um menu com opções de conversão, como:
   - USD → BRL
   - EUR → USD
   - GBP → JPY
   - BRL → USD
   - USD → EUR
   - USD → ARS

2. Após a escolha, o usuário informa o valor desejado para conversão.

3. O sistema realiza uma requisição à API de câmbio com base nas moedas escolhidas.

4. Os dados da resposta (em JSON) são convertidos em objetos Java com a biblioteca Gson.

5. O resultado da conversão é exibido no console.

---

## 💡 Desafios Encontrados

- 🎯 Implementação manual da biblioteca Gson (sem Maven)
- ⚙️ Parse de JSON em Java puro
- 🌐 Codificação segura de URLs com URLEncoder para evitar erros em caracteres especiais
- 🧪 Validação de entradas e tratamento de exceções HTTP
- 📉 Exibição clara e amigável das conversões no terminal

---

## 🧩 Organização do Código

- `Principal.java`: Classe principal com o menu de interação.
- `Conversor.java`: Lógica de requisição e conversão de moedas.
- `MoedaResponse.java`: Classe modelo para mapear a resposta da API via Gson.

---

## 📝 Como Executar

1. Tenha o Java 17 ou superior instalado.
2. Baixe o arquivo `gson-2.10.1.jar` do site oficial.
3. No IntelliJ:
   - Vá em File → Project Structure → Modules → Dependencies → + → JARs or directories → selecione o `gson-2.10.1.jar`
4. Compile e execute o `Principal.java`.

---


---

## 📬 Contribuições

Este projeto é um exercício de aprendizado. Contribuições, melhorias ou sugestões são bem-vindas!

---




