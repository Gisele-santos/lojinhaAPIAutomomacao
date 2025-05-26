package modulos.produto;


import datFactory.ProdutoDataFactory;
import datFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojo.ComponentePojo;
import pojo.ProdutoPojo;
import pojo.UsuarioPojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


@DisplayName("Testes de API Rest do módulo de Produto")
public class ProdutoTest {
    private String token;

    @BeforeEach
    public void beforeEach (){
        // Configurando os dados da API Rest da Lojinha         //RestAssured, dá a possibilidade de apontar a API
        baseURI = "http://165.227.93.41";
        //port = 8080;
        basePath = "/lojinha-bugada";

        // Obter o token do usuario admin       // Dado que     //Dá a possibilidade executar requisições contra ela, de modo que possa enviar os dados.
        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.criarUsuarioAdministrador())
            .when()                             // Quando
                .post("/v2/login")
            .then()
                .extract()                      //Extraia
                    .path("data.token");



    }

    @Test
    @DisplayName("Validar que o valor do produto igual a 0.00 não é permitido")
    public void testValidarLimitesZeradoProibidosValorproduto(){     //Junit, me dá os métodos de teste a possibilidade de executar.



       // Tentar inserir um prduto com valor 0.00 e validar que a mensagem de erro foi apresentada e o
       // status code retornado foi 422
       // ESSE  DE FATO É O TESTE




        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(0.00))
            .when()                                              //E possa válida-los.
                   .post("/v2/produtos")
            .then()
                        .assertThat()
                             .body("error", equalTo ("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                             .statusCode(422);



    }

    @Test
    @DisplayName("Validar que o valor produto igual a 7000.01 não é permitido")
    public void testValidarLimitesMaiorSeteMilProibidoValorproduto(){
        // Tentar inserir um prduto com valor 7000.01 e validar que a mensagem de erro foi apresentada e o
        // status code retornado foi 422
        // ESSE  DE FATO É O TESTE

        given()
                .contentType(ContentType.JSON)
                .header("token", this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(7000.01))
            .when()
                .post("/v2/produtos")
            .then()
                .assertThat()
                    .body("error", equalTo ("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                    .statusCode(422);
    }

}



