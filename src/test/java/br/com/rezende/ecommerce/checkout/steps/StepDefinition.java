package br.com.rezende.ecommerce.checkout.steps;

import br.com.rezende.ecommerce.checkout.SpringIntegrationTest;
import br.com.rezende.ecommerce.checkout.util.UUIDUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class StepDefinition extends SpringIntegrationTest {

    @Autowired
    private TestRestTemplate template;

    private String responseBody;

    private HttpHeaders responseHeaders;

    private HttpStatus statusCode;

    @Mock
    private UUIDUtil uuidUtil;

    @When("uma request no endpoint {string}")
    public void umaRequestNoEndpoint(String path) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final String body = "{\"firstName\":\"\",\n" +
                "\"lastName\":\"\",\n" +
                "\"email\":\"\",\n" +
                "\"address\":\"\",\n" +
                "\"complement\":\"\",\n" +
                "\"country\":\"\",\n" +
                "\"state\":\"\",\n" +
                "\"cep\":\"\",\n" +
                "\"saveAddress\":\"\",\n" +
                "\"saveInfo\":\"\",\n" +
                "\"paymentMethod\":\"\",\n" +
                "\"cardName\":\"\",\n" +
                "\"cardNumber\":\"\",\n" +
                "\"cardDate\":\"\",\n" +
                "\"cardCvv\":\"123\",\n" +
                "\"products\":[\"produtoA\", \"produtoB\"]}";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        uuidUtil = mock(UUIDUtil.class);
        Mockito.when(uuidUtil.createUUID()).thenReturn(UUID.fromString("40e6215d-b5c6-4896-987c-f30f3678f608"));

        try {
            final ResponseEntity response = template.postForEntity(
                    path,
                    entity,
                    String.class
            );
            responseBody = getBody(response);
            responseHeaders = response.getHeaders();
            statusCode = response.getStatusCode();
        } catch (HttpStatusCodeException ex) {
            statusCode = ex.getStatusCode();
            assertEquals("", ex.getResponseBodyAsString());
        }
    }

    @Then("deve criar o checkout e retornar status code of {int}")
    public void deveCriarOCheckoutERetornarStatusCodeOf(int expectedStatusCode) {
        assertEquals(expectedStatusCode, statusCode.value());
    }

    @And("a resposta deve ser {string}")
    public void aRespostaDeveSer(String exptectedResponseBody) {
        assertNotNull(responseBody);
    }

    private static String getBody(ResponseEntity response) {
        final StringBuilder body = new StringBuilder();
        if(response.getBody() != null) {
            body.append(response.getBody().toString());
        }
        return body.toString();
    }

    @Given("geracao de uuid {string}")
    public void geracaoDeUuid(String uuid) {
        //uuidUtil = mock(UUIDUtil.class);
        //Mockito.when(uuidUtil.createUUID()).thenReturn(UUID.fromString("40e6215d-b5c6-4896-987c-f30f3678f608"));
    }
}
