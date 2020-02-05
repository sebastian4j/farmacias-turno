package com.github.sebastian.farmaciasturno;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * permite obtener los datos de las farmacias de turno desde servicio externo.
 * 
 * @author Sebastián Ávila A.
 *
 */
@Path("ws/")
@RegisterRestClient
public interface FarmaciaTurnoService {
  /**
   * obtengo las farmacias como texto, el servicio no responde application/json.
   * 
   * @param region región buscada
   * @return datos sin procesar de las farmacias en turno
   */
  @GET
  @Path("getLocalesRegion")
  @Produces("text/html; charset=UTF-8")
  public String obtenerFarmacias(@QueryParam("id_region") int region);
}
