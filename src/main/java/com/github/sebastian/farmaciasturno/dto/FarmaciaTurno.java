package com.github.sebastian.farmaciasturno.dto;

import javax.json.bind.annotation.JsonbProperty;

/**
 * contiene los datos de una farmacia en turno obtenida desde el servicio externo.
 * 
 * @author Sebastián Ávila A.
 *
 */
public class FarmaciaTurno {
  private String fecha;
  @JsonbProperty("local_id")
  private String localId;
  @JsonbProperty("local_nombre")
  private String localNombre;
  @JsonbProperty("comuna_nombre")
  private String comunaNombre;
  @JsonbProperty("localidad_nombre")
  private String localidadNombre;
  @JsonbProperty("local_direccion")
  private String localDireccion;
  @JsonbProperty("funcionamiento_hora_apertura")
  private String horaApertura;
  @JsonbProperty("funcionamiento_hora_cierre")
  private String horaCierre;
  @JsonbProperty("local_telefono")
  private String telefono;
  @JsonbProperty("local_lat")
  private String lat;
  @JsonbProperty("local_lng")
  private String lng;
  @JsonbProperty("funcionamiento_dia")
  private String funcionamientoDia;
  @JsonbProperty("fk_region")
  private String region;
  @JsonbProperty("fk_comuna")
  private String comuna;

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public String getLocalId() {
    return localId;
  }

  public void setLocalId(String localId) {
    this.localId = localId;
  }

  public String getLocalNombre() {
    return localNombre == null ? "" : localNombre;
  }

  public void setLocalNombre(String localNombre) {
    this.localNombre = localNombre;
  }
  
  public String getComunaNombre() {
    return comunaNombre;
  }

  public void setComunaNombre(String comunaNombre) {
    this.comunaNombre = comunaNombre;
  }

  public String getLocalidadNombre() {
    return localidadNombre;
  }

  public void setLocalidadNombre(String localidadNombre) {
    this.localidadNombre = localidadNombre;
  }

  public String getLocalDireccion() {
    return localDireccion;
  }

  public void setLocalDireccion(String localDireccion) {
    this.localDireccion = localDireccion;
  }

  public String getHoraApertura() {
    return horaApertura;
  }

  public void setHoraApertura(String horaApertura) {
    this.horaApertura = horaApertura;
  }

  public String getHoraCierre() {
    return horaCierre;
  }

  public void setHoraCierre(String horaCierre) {
    this.horaCierre = horaCierre;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getLng() {
    return lng;
  }

  public void setLng(String lng) {
    this.lng = lng;
  }

  public String getFuncionamientoDia() {
    return funcionamientoDia;
  }

  public void setFuncionamientoDia(String funcionamientoDia) {
    this.funcionamientoDia = funcionamientoDia;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getComuna() {
    return comuna == null ? "" : comuna;
  }

  public void setComuna(String comuna) {
    this.comuna = comuna;
  }
}
