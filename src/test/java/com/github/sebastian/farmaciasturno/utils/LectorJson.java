package com.github.sebastian.farmaciasturno.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * lee el archivo con la respuesta del servicio externo.
 * 
 * @author Sebastián Ávila A.
 *
 */
public final class LectorJson {
  public static String leerJsonFarmaciasTurno() throws IOException, URISyntaxException {
    return Files
        .lines(Paths
            .get(LectorJson.class.getClassLoader().getResource("farmacias_turno.json").toURI()))
        .collect(Collectors.joining());
  }

}
