# Lojinha API Automação
Esse é um repositório que contém a automação de alguns teste de API Rest de um software denominado Lojinha. Os sub-tópicos abaixo descrevem algumas decisões tomadas na estrutura do projeto.

## Tecnologias Utilizadas

- Java
  https://www.java.com/pt-BR/download/manual.jsp

- JUnit
  https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.11.4

- RestAssured
  https://mvnrepository.com/artifact/io.rest-assured/rest-assured/4.4.0

- Maven
  https://maven.apache.org/

## Testes Automatizados
Teste para validar as partições de equivalência relacionadas ao valor do produto na Lojinha, que estão vinculados diretamente a regra de negócio que diz que o valor do produto deve estar entre R$0,01 e R$7.000,00.

## Notas Gerais

- Sempre utlizamos a anotação Before Each para capturar o token que será utilizado posteriormente nos métodos de teste.
- Armazenamos os dados que são enviados para a API através dos uso de classes POJO.
- Criamos dados iniciais através de uso de classe Data Factory, para facilitar a criação e controle dps mesmos.
- Nesse projeto fazemos uso do JUnit 5, oqye nos da a possibilidade de usar a anotação DisplayName para dar descirções em português para nossos testes.


