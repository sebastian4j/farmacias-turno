package com.github.sebastian.farmaciasturno;

import io.quarkus.test.junit.QuarkusTest;
import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;

import static io.restassured.RestAssured.given;


/**
 * test para la clase {@link FarmaciaTurnoResource}.
 *
 * @author Sebastián Ávila A.
 */
@QuarkusTest
public class FarmaciaTurnoResourceTest {
  private static MockServerClient ms;

  @BeforeAll
  public static void init() throws IOException, URISyntaxException {
    ms = StartServerUtil.mock();
  }

  @AfterAll
  public static void end() {
    ms.stop();
  }

  @Test
  public void obtengoElCodigoEsperadoCuandoHayResultados() {
    given().when().get("/v1/").then().statusCode(200);
  }
}
