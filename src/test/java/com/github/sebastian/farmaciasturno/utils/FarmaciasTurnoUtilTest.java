package com.github.sebastian.farmaciasturno.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * test para la clase {@link FarmaciasTurnoUtil}.
 * 
 * @author Sebastián Ávila A.
 *
 */
public class FarmaciasTurnoUtilTest {

  @Test
  @DisplayName("desde un archivo con el string del response obtengo las farmacias de turno")
  public void puedoProcesarUnStringConFormatoJson() throws URISyntaxException, IOException {
    final String txt = LectorJson.leerJsonFarmaciasTurno();
    final var datos = FarmaciasTurnoUtil.parse(txt);
    assertThat(datos.get().length).isEqualTo(1725);
  }
  
  @Test
  @DisplayName("puedo usar las opciones de filtro de comuna y nombre, vacios no se consideran para filtrar")
  public void puedoFiltrarLasFarmaciasEnTurno() throws URISyntaxException, IOException {
    final String txt = LectorJson.leerJsonFarmaciasTurno();
    assertThat(FarmaciasTurnoUtil.filtrar(txt, "", "")).isNotEmpty(); // sin filtro vienen todas
    assertThat(FarmaciasTurnoUtil.filtrar(txt, "", "Ahumada").size()).isEqualTo(185);
    assertThat(FarmaciasTurnoUtil.filtrar(txt, "", "Cruz Verde").size()).isEqualTo(328);
    assertThat(FarmaciasTurnoUtil.filtrar(txt, "Cerrillos", "").size()).isEqualTo(14);
    assertThat(FarmaciasTurnoUtil.filtrar(txt, "Macul", "").size()).isEqualTo(18);
    
  }
  

}
