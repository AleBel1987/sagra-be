package it.alecata.sagra.web.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse2004
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-25T09:45:13.933Z")

public class InlineResponse2004   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("idTavoloAccomodato")
  private Long idTavoloAccomodato = null;

  @JsonProperty("personaOrdine")
  private String personaOrdine = null;

  @JsonProperty("data")
  private Integer data = null;

  @JsonProperty("pietanzeOrdinate")
  private List<OrdinilistaOrdiniByTavoloIdPietanzeOrdinate> pietanzeOrdinate = null;

  @JsonProperty("numCoperti")
  private Integer numCoperti = null;

  @JsonProperty("totale")
  private Float totale = null;

  @JsonProperty("quotaPersona")
  private Float quotaPersona = null;

  @JsonProperty("asporto")
  private Boolean asporto = false;

  public InlineResponse2004 id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public InlineResponse2004 idTavoloAccomodato(Long idTavoloAccomodato) {
    this.idTavoloAccomodato = idTavoloAccomodato;
    return this;
  }

   /**
   * Get idTavoloAccomodato
   * @return idTavoloAccomodato
  **/
  @ApiModelProperty(value = "")


  public Long getIdTavoloAccomodato() {
    return idTavoloAccomodato;
  }

  public void setIdTavoloAccomodato(Long idTavoloAccomodato) {
    this.idTavoloAccomodato = idTavoloAccomodato;
  }

  public InlineResponse2004 personaOrdine(String personaOrdine) {
    this.personaOrdine = personaOrdine;
    return this;
  }

   /**
   * Get personaOrdine
   * @return personaOrdine
  **/
  @ApiModelProperty(value = "")


  public String getPersonaOrdine() {
    return personaOrdine;
  }

  public void setPersonaOrdine(String personaOrdine) {
    this.personaOrdine = personaOrdine;
  }

  public InlineResponse2004 data(Integer data) {
    this.data = data;
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")


  public Integer getData() {
    return data;
  }

  public void setData(Integer data) {
    this.data = data;
  }

  public InlineResponse2004 pietanzeOrdinate(List<OrdinilistaOrdiniByTavoloIdPietanzeOrdinate> pietanzeOrdinate) {
    this.pietanzeOrdinate = pietanzeOrdinate;
    return this;
  }

  public InlineResponse2004 addPietanzeOrdinateItem(OrdinilistaOrdiniByTavoloIdPietanzeOrdinate pietanzeOrdinateItem) {
    if (this.pietanzeOrdinate == null) {
      this.pietanzeOrdinate = new ArrayList<OrdinilistaOrdiniByTavoloIdPietanzeOrdinate>();
    }
    this.pietanzeOrdinate.add(pietanzeOrdinateItem);
    return this;
  }

   /**
   * Get pietanzeOrdinate
   * @return pietanzeOrdinate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<OrdinilistaOrdiniByTavoloIdPietanzeOrdinate> getPietanzeOrdinate() {
    return pietanzeOrdinate;
  }

  public void setPietanzeOrdinate(List<OrdinilistaOrdiniByTavoloIdPietanzeOrdinate> pietanzeOrdinate) {
    this.pietanzeOrdinate = pietanzeOrdinate;
  }

  public InlineResponse2004 numCoperti(Integer numCoperti) {
    this.numCoperti = numCoperti;
    return this;
  }

   /**
   * Get numCoperti
   * @return numCoperti
  **/
  @ApiModelProperty(value = "")


  public Integer getNumCoperti() {
    return numCoperti;
  }

  public void setNumCoperti(Integer numCoperti) {
    this.numCoperti = numCoperti;
  }

  public InlineResponse2004 totale(Float totale) {
    this.totale = totale;
    return this;
  }

   /**
   * Get totale
   * @return totale
  **/
  @ApiModelProperty(value = "")


  public Float getTotale() {
    return totale;
  }

  public void setTotale(Float totale) {
    this.totale = totale;
  }

  public InlineResponse2004 quotaPersona(Float quotaPersona) {
    this.quotaPersona = quotaPersona;
    return this;
  }

   /**
   * Get quotaPersona
   * @return quotaPersona
  **/
  @ApiModelProperty(value = "")


  public Float getQuotaPersona() {
    return quotaPersona;
  }

  public void setQuotaPersona(Float quotaPersona) {
    this.quotaPersona = quotaPersona;
  }

  public InlineResponse2004 asporto(Boolean asporto) {
    this.asporto = asporto;
    return this;
  }

   /**
   * Get asporto
   * @return asporto
  **/
  @ApiModelProperty(value = "")


  public Boolean getAsporto() {
    return asporto;
  }

  public void setAsporto(Boolean asporto) {
    this.asporto = asporto;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2004 inlineResponse2004 = (InlineResponse2004) o;
    return Objects.equals(this.id, inlineResponse2004.id) &&
        Objects.equals(this.idTavoloAccomodato, inlineResponse2004.idTavoloAccomodato) &&
        Objects.equals(this.personaOrdine, inlineResponse2004.personaOrdine) &&
        Objects.equals(this.data, inlineResponse2004.data) &&
        Objects.equals(this.pietanzeOrdinate, inlineResponse2004.pietanzeOrdinate) &&
        Objects.equals(this.numCoperti, inlineResponse2004.numCoperti) &&
        Objects.equals(this.totale, inlineResponse2004.totale) &&
        Objects.equals(this.quotaPersona, inlineResponse2004.quotaPersona) &&
        Objects.equals(this.asporto, inlineResponse2004.asporto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idTavoloAccomodato, personaOrdine, data, pietanzeOrdinate, numCoperti, totale, quotaPersona, asporto);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2004 {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    idTavoloAccomodato: ").append(toIndentedString(idTavoloAccomodato)).append("\n");
    sb.append("    personaOrdine: ").append(toIndentedString(personaOrdine)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    pietanzeOrdinate: ").append(toIndentedString(pietanzeOrdinate)).append("\n");
    sb.append("    numCoperti: ").append(toIndentedString(numCoperti)).append("\n");
    sb.append("    totale: ").append(toIndentedString(totale)).append("\n");
    sb.append("    quotaPersona: ").append(toIndentedString(quotaPersona)).append("\n");
    sb.append("    asporto: ").append(toIndentedString(asporto)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

