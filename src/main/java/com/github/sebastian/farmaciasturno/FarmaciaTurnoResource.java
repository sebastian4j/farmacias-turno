package com.github.sebastian.farmaciasturno;

import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import com.github.sebastian.farmaciasturno.dto.FarmaciaTurnoResponse;
import com.github.sebastian.farmaciasturno.utils.FarmaciasTurnoUtil;

/**
 * recursos expuestos para las farmacias en turno.
 * 
 * @author Sebastián Ávila A.
 *
 */
@Path("/v1")
public class FarmaciaTurnoResource {
  @Inject
  @RestClient
  private FarmaciaTurnoService fts;

  /**
   * obtiene las farmacias en turno filtrando por comuna y local
   * 
   * @param comuna nombre de la comuna para filtrar
   * @param local nombre del local para filtrar
   * @return comunas que correspondan con el filtro o 204 si no hay contenido
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response obtener(@QueryParam("comuna") final String comuna,
      @QueryParam("local") final String local) {
    Response response = Response.noContent().build();
    final var coincidencias = FarmaciasTurnoUtil
        .filtrar(fts.obtenerFarmacias(FarmaciaTurnoService.REGION_PRUEBA), comuna, local);
    if (!coincidencias.isEmpty()) {
      response = Response
          .ok(coincidencias.stream().map(FarmaciaTurnoResponse::new).collect(Collectors.toList()))
          .build();
    }
    return response;
  }
}
