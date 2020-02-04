package com.github.sebastian.farmaciasturno.dto;

/**
 * contiene los datos que son enviados al cliente del servicio de filtro de farmacias en turno.
 * 
 * @author Sebastián Ávila A.
 *
 */
public class FarmaciaTurnoResponse {
  private String nombreLocal;
  private String direccion;
  private String latitud;
  private String longitud;
  private String telefono;

  public FarmaciaTurnoResponse() {}

  /**
   * instancia la clase con los valores requeridos desde el servicio externo.
   * 
   * @param ft datos obtenidos de las farmacias de turno.
   */
  public FarmaciaTurnoResponse(FarmaciaTurno ft) {
    this.nombreLocal = ft.getLocalNombre();
    this.direccion = ft.getLocalDireccion();
    this.latitud = ft.getLat();
    this.longitud = ft.getLng();
    this.telefono = ft.getTelefono();
  }

  public String getNombreLocal() {
    return nombreLocal;
  }

  public void setNombreLocal(String nombreLocal) {
    this.nombreLocal = nombreLocal;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getLatitud() {
    return latitud;
  }

  public void setLatitud(String latitud) {
    this.latitud = latitud;
  }

  public String getLongitud() {
    return longitud;
  }

  public void setLongitud(String longitud) {
    this.longitud = longitud;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
}
