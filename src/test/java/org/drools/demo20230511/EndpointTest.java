package org.drools.demo20230511;

import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieRuntimeBuilder;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import javax.inject.Inject;

@QuarkusTest
public class EndpointTest {
    static {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();;
    }
    
    // @Test
    // public void testHelloEndpoint() {
    //     given()
    //       .when().post("/reproducer")
    //       .then()
    //          .statusCode(200)
    //          .body(is(List.of(1)));
    // }

    @Inject
    KieRuntimeBuilder kieRuntimeBuilder;

    @Test
    public void test1() {
        MyEndpoint.ut(kieRuntimeBuilder, "prova");
    }
}
