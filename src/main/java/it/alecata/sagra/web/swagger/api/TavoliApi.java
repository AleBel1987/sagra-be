/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package it.alecata.sagra.web.swagger.api;


import io.swagger.annotations.*;
import it.alecata.sagra.web.swagger.model.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-25T09:45:13.933Z")

@Api(value = "tavoli", description = "the tavoli API")
public interface TavoliApi {

    @ApiOperation(value = "Crea un nuovo tavolo accomodato", notes = "Crea un nuovo tavolo accomodato", response = InlineResponse2003.class,  
    		tags={ "accomodatore", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = InlineResponse2003.class),
        @ApiResponse(code = 400, message = "Errore parametri", response = Void.class) })
    
    @RequestMapping(value = "/api/tavoli/apriTavoloAccomodato",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<InlineResponse2003> apriTavoloAccomodato(@ApiParam(value = "idTavoloReale, codice, descrizione, numCoperti, accomodatoPersona" ,required=true )  @Valid @RequestBody Body2 body);


    @ApiOperation(value = "Chiude un tavolo accomodato", notes = "Chiude un tavolo accomodato", response = InlineResponse2003.class, 
    		tags={ "accomodatore", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = InlineResponse2003.class),
        @ApiResponse(code = 400, message = "Errore parametri", response = Void.class) })
    
    @RequestMapping(value = "/api/tavoli/chiudiTavoloAccomodato",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<InlineResponse2003> chiudiTavoloAccomodato(@ApiParam(value = "idTavoloAccomodato, accomodatoPersona" ,required=true )  @Valid @RequestBody Body3 body);


    @ApiOperation(value = "Cerca tavoli accomodati", notes = "Cerca tavoli accomodati di un tavolo reale", response = InlineResponse2002.class, responseContainer = "List", 
    		tags={ "accomodatore", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = InlineResponse2002.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Errore parametri", response = Void.class) })
    
    @RequestMapping(value = "/api/tavoli/listaTavoliAccomodatiByTavoloId",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<InlineResponse2002>> listaTavoliAccomodatiByTavoloId( @NotNull@ApiParam(value = "Identificativo del tavolo reale", required = true) @RequestParam(value = "idTavoloReale", required = true) Long idTavoloReale);


    @ApiOperation(value = "Cerca tavoli reali", notes = "Cerca tavoli reali", response = InlineResponse2001.class, responseContainer = "List", 
    		tags={ "accomodatore", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = InlineResponse2001.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Errore parametri", response = Void.class) })
    
    @RequestMapping(value = "/api/tavoli/listaTavoliReali",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<InlineResponse2001>> listaTavoliReali(@ApiParam(value = "Solo tavoli liberi") @RequestParam(value = "soloLiberi", required = false) Boolean soloLiberi);

}