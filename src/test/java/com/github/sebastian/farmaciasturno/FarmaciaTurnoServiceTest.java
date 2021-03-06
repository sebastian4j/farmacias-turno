package com.github.sebastian.farmaciasturno;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import com.github.sebastian.farmaciasturno.dto.FarmaciaTurno;
import com.github.sebastian.farmaciasturno.utils.FarmaciasTurnoUtil;
import io.quarkus.test.junit.QuarkusTest;



/**
 * test para la clase {@link FarmaciaTurno}.
 * 
 * @author Sebastián Ávila A.
 *
 */
@QuarkusTest
public class FarmaciaTurnoServiceTest {
  @Inject
  @RestClient
  private FarmaciaTurnoService fts;
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
  @DisplayName("puedo invocar al servicio externo y obtener las farmacias")
  public void obtengoLasFarmaciasDeTurno() {
    final var fet = FarmaciasTurnoUtil.parse(fts.obtenerFarmacias(7));
    assertThat(fet).isPresent();
    assertThat(fet.get().length).isEqualTo(1725);
  }

}
