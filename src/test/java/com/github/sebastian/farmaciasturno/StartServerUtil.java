package com.github.sebastian.farmaciasturno;

import com.github.sebastian.farmaciasturno.utils.LectorJson;
import java.io.IOException;
import java.net.URISyntaxException;
import org.mockserver.client.MockServerClient;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

/**
 * permite inicar el mock del servicio de las farmacias de turno.
 *
 * @author Sebastián Ávila A.
 */
public final class StartServerUtil {
	private StartServerUtil() {}
	
	/**
	 * obtiene la instancia del mock de farmacias de turno.
	 * 
	 * @return mock de servicio externo
	 * @throws IOException error al leer la entrada que tiene que retornar
	 * @throws URISyntaxException  error al configurar el mock
	 */
	public static MockServerClient mock() throws IOException, URISyntaxException {
		MockServerClient ms= startClientAndServer(8888);
    ms.when(
            request()
                .withMethod("GET")
                .withPath("/ws/getLocalesRegion")
                .withQueryStringParameter("id_region", "7"))
        .respond(
            response()
                .withStatusCode(200)
                .withHeader("Content-Type", "text/html; charset=UTF-8")
                .withBody(LectorJson.leerJsonFarmaciasTurno()));
		return ms;
	}
}
