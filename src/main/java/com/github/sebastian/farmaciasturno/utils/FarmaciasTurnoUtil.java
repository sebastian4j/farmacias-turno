package com.github.sebastian.farmaciasturno.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.json.bind.JsonbBuilder;
import com.github.sebastian.farmaciasturno.dto.FarmaciaTurno;

/**
 * métodos de utilidad para el servicio de las farmacias en turno.
 * 
 * @author Sebastián Ávila A.
 *
 */
public final class FarmaciasTurnoUtil {
  private FarmaciasTurnoUtil() {}

  /**
   * con los datos obtenidos desde el servicio de farmacias se obtiene la representación.
   * 
   * @param datos que se obtienen desde el servicio de farmacias en turno
   * @return representación de los datos obtenidos
   * @throws IllegalArgumentException error al obtener los datos de las farmacias
   */
  public static Optional<FarmaciaTurno[]> parse(final String datos) {
    var ft = Optional.<FarmaciaTurno[]>empty();
    try {
      try (final var jsonb = JsonbBuilder.create()) {
        ft = Optional.ofNullable(jsonb.fromJson(datos, FarmaciaTurno[].class));
      }
    } catch (Exception e) {
      throw new IllegalArgumentException("no se pueden obtener las farmacias de turno", e);
    }
    return ft;
  }

  /**
   * filtra los datos según el criterio de busqueda, si no hay coincidencias la lista es vacia.
   * 
   * @param datos datos de las farmacias en turno
   * @param comuna comuna para la busqueda
   * @param local local para la busqueda
   * @return datos filtrados por comuna y local
   */
  public static List<FarmaciaTurno> filtrar(final String datos, final String comuna,
      final String local) {
    final var fet = parse(datos);
    final Predicate<FarmaciaTurno> filtroComuna = ft -> {
      boolean agregar = true;
      if (comuna != null && !comuna.isEmpty()
          && !ft.getComunaNombre().toUpperCase().contains(comuna.toUpperCase())) {
        agregar = false;
      }
      return agregar;
    };
    final Predicate<FarmaciaTurno> filtroLocal = ft -> {
      boolean agregar = true;      
      if (local != null && !local.isEmpty()
          && !ft.getLocalNombre().toUpperCase().contains(local.toUpperCase())) {
        agregar = false;
      }    
      return agregar;
    };
    var coincidencias = List.<FarmaciaTurno>of();
    if (fet.isPresent()) {
      coincidencias = Arrays.asList(fet.get()).stream().filter(filtroComuna).filter(filtroLocal)
          .collect(Collectors.toList());
    }
    return coincidencias;
  }

}
