package br.com.rezende.ecommerce.checkout.setup;

import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.wait.strategy.Wait;

@TestConfiguration
public class PostgresSQLSetup {

    private static final PostgreSQLContainer postgresSQLContainer = new PostgreSQLContainer()
            .withDatabaseName("checkout")
            .withUsername("admin")
            .withPassword("admin");

    static {
        postgresSQLContainer.start();
        postgresSQLContainer.waitingFor(Wait.forHealthcheck());
        System.setProperty("spring.datasource.url", postgresSQLContainer.getJdbcUrl());
        //System.setProperty("spring.datasource.schema", "public");
    }
}
