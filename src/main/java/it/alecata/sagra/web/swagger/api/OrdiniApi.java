/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package it.alecata.sagra.web.swagger.api;

import it.alecata.sagra.web.swagger.model.*;
import io.swagger.annotations.*;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-07-28T13:04:29.118Z")

@Api(value = "ordini", description = "the ordini API")
public interface OrdiniApi {

    @ApiOperation(value = "Crea Ordine", notes = "Crea un ordine per un tavolo", response = OrdineDto.class, tags={ "ordinatore", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = OrdineDto.class),
        @ApiResponse(code = 400, message = "Errore parametri", response = Void.class) })
    
    @RequestMapping(value = "/api/ordini/creaOrdine",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<OrdineDto> creaOrdine(@ApiParam(value = "ordine" ,required=true )  @Valid @RequestBody OrdineDto body);


    @ApiOperation(value = "Ordini del tavolo", notes = "Ritorna gli ordini del tavolo", response = OrdineDto.class, responseContainer = "List", 
    		tags={ "ordinatore", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = OrdineDto.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Errore parametri", response = Void.class) })
    
    @RequestMapping(value = "/api/ordini/listaOrdiniByTavoloId",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<OrdineDto>> listaOrdiniByTavoloId( @NotNull@ApiParam(value = "Identificativo del tavolo accomodato", required = true) @RequestParam(value = "idTavoloAccomodato", required = true) Long idTavoloAccomodato);


    @ApiOperation(value = "Lista delle pietanze", notes = "Lista delle pietanze", response = PietanzaDto.class, responseContainer = "List", 
    		tags={ "ordinatore", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = PietanzaDto.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Errore parametri", response = Void.class) })
    
    @RequestMapping(value = "/api/ordini/listaPietanze",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PietanzaDto>> listaPietanze( @NotNull@ApiParam(value = "Identificativo della sagra", required = true) @RequestParam(value = "idSagra", required = true) Long idSagra);

    
    @ApiOperation(value = "Lista Categorie pietanze", notes = "Lista Categorie pietanze", response = PietanzaCategoriaDto.class, responseContainer = "List", 
    		tags={ "ordinatore", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = PietanzaCategoriaDto.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Errore parametri", response = Void.class) })
    
    @RequestMapping(value = "/api/ordini/listaCategoriePietanze",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PietanzaCategoriaDto>> listaCategoriePietanze( @NotNull@ApiParam(value = "Identificativo della sagra", required = true) @RequestParam(value = "idSagra", required = true) Long idSagra);


    @ApiOperation(value = "Cerca tavoli accomodati", notes = "Cerca tavoli accomodati", response = TavoloAccomodatoDto.class, responseContainer = "List", 
    		tags={ "ordinatore", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = TavoloAccomodatoDto.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Errore parametri", response = Void.class) })
    
    @RequestMapping(value = "/api/ordini/listaTavoliAccomodati",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<TavoloAccomodatoDto>> listaTavoliAccomodati( @NotNull@ApiParam(value = "Anche i tavoli in stato ordinato", required = true) @RequestParam(value = "statoOrdinato", required = true) Boolean statoOrdinato);

}
