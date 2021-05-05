package br.com.rezende.ecommerce.checkout;

import br.com.rezende.ecommerce.checkout.setup.PostgresSQLSetup;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@CucumberContextConfiguration
@SpringBootTest( classes = {CheckoutApplication.class,
PostgresSQLSetup.class
}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringIntegrationTest {
}
