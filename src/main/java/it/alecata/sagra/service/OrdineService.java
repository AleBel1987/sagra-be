package it.alecata.sagra.service;

import it.alecata.sagra.domain.Ordine;
import it.alecata.sagra.domain.Pietanza;
import it.alecata.sagra.domain.PietanzaOrdinata;
import it.alecata.sagra.domain.TavoloAccomodato;
import it.alecata.sagra.domain.enumeration.TavoloStato;
import it.alecata.sagra.repository.OrdineRepository;
import it.alecata.sagra.repository.PietanzaCategoriaRepository;
import it.alecata.sagra.repository.PietanzaOrdinataRepository;
import it.alecata.sagra.repository.PietanzaRepository;
import it.alecata.sagra.web.swagger.model.OrdineDto;
import it.alecata.sagra.web.swagger.model.PietanzaCategoriaDto;
import it.alecata.sagra.web.swagger.model.PietanzaDto;
import it.alecata.sagra.web.swagger.model.PietanzaOrdinataDto;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;


/**
 * Service Implementation for managing Ordine.
 */
@Service
@Transactional
public class OrdineService {

    private final Logger log = LoggerFactory.getLogger(OrdineService.class);

    private final TavoloAccomodatoService tavoloAccomodatoService;

    
    private final PietanzaRepository pietanzaRepository;
    
    private final OrdineRepository ordineRepository;
    
    private final PietanzaOrdinataRepository pietanzaOrdinataRepository;
    
    private final PrinterService printerService;

    public OrdineService(TavoloAccomodatoService tavoloAccomodatoService, PietanzaRepository pietanzaRepository, 
    		OrdineRepository ordineRepository, PietanzaOrdinataRepository pietanzaOrdinataRepository,
    		PrinterService printerService) {
        this.tavoloAccomodatoService = tavoloAccomodatoService;
        this.pietanzaRepository = pietanzaRepository;
        this.ordineRepository = ordineRepository;
        this.pietanzaOrdinataRepository = pietanzaOrdinataRepository;
        this.printerService = printerService;
    }

    /**
     * Save a ordine.
     *
     * @param ordine the entity to save
     * @return the persisted entity
     */
    public Ordine save(Ordine ordine) {
        log.debug("Request to save Ordine : {}", ordine);
        return ordineRepository.save(ordine);
    }

    /**
     *  Get all the ordines.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Ordine> findAll(Pageable pageable) {
        log.debug("Request to get all Ordines");
        return ordineRepository.findAll(pageable);
    }

    /**
     *  Get one ordine by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true)
    public Ordine findOne(Long id) {
        log.debug("Request to get Ordine : {}", id);
        return ordineRepository.findOne(id);
    }

    /**
     *  Delete the  ordine by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Ordine : {}", id);
        ordineRepository.delete(id);
    }
    
    public List<PietanzaDto> listaPietanze(Long idSagra){
    	Page<Pietanza> pietanzaPage = pietanzaRepository.findAll(new PageRequest(0, Integer.MAX_VALUE));
    	List<Pietanza> pietanze = pietanzaPage.getContent();
    	List<PietanzaDto> response = new ArrayList<PietanzaDto>();
    	for (Pietanza pietanza : pietanze) {
    		PietanzaDto pietanzaDto = new PietanzaDto();
    		pietanzaDto.setId(pietanza.getId());
    		pietanzaDto.setNome(pietanza.getNome());
    		pietanzaDto.setPrezzo(pietanza.getPrezzo());
    		pietanzaDto.setDescrizione(pietanza.getDescrizione());
    		if(pietanza.getCodice().equals("000"))
    			pietanzaDto.setCoperto(true);
    		else
    			pietanzaDto.setCoperto(false);
    		PietanzaCategoriaDto pietanzaCategoriaDto = new PietanzaCategoriaDto();
    		pietanzaCategoriaDto.setId(pietanza.getPietanzaCategoria().getId());
    		pietanzaCategoriaDto.setCodice(pietanza.getPietanzaCategoria().getCodice());
    		pietanzaDto.setCategoria(pietanzaCategoriaDto);
    		response.add(pietanzaDto);
    	}
    	return response;
    }
    
    public OrdineDto creaOrdine(OrdineDto body) {
    	Ordine ordine = new Ordine();
    	ordine.setAsporto(body.getAsporto());
    	ordine.setDataOrdine(ZonedDateTime.now(ZoneId.systemDefault()));
    	ordine.setNumeroCoperti(body.getNumCoperti());
    	ordine.setPersonaOrdine(body.getPersonaOrdine());
    	
    	TavoloAccomodato tavoloAccomodato = tavoloAccomodatoService.findOne(body.getIdTavoloAccomodato());
    	ordine.setTavoloAccomodato(tavoloAccomodato);
    	
    	ordineRepository.save(ordine);
    	
    	boolean esisteCoperto = false;
    	Float totale = new Float(0);
    	Float persone = new Float(body.getNumCoperti());

    	List<PietanzaOrdinata> pietanzeOrdinate = new ArrayList<PietanzaOrdinata>();
    	for(PietanzaOrdinataDto pietanzaOrdinataDto : body.getPietanzeOrdinate()){
    		Pietanza pietanza = pietanzaRepository.findOne(pietanzaOrdinataDto.getPietanza().getId());
    		PietanzaOrdinata pietanzaOrdinata = new PietanzaOrdinata();
    		pietanzaOrdinata.setOrdine(ordine);
    		pietanzaOrdinata.setNumeroSequenza(pietanzaOrdinataDto.getNumSequenza());
    		pietanzaOrdinata.setNote(pietanzaOrdinataDto.getNote());
    		pietanzaOrdinata.setPietanza(pietanza);
    		pietanzaOrdinata.setQuantita(pietanzaOrdinataDto.getQuantita());
    		pietanzaOrdinataRepository.save(pietanzaOrdinata);
    		pietanzeOrdinate.add(pietanzaOrdinata);
    		
    		totale = totale + (pietanzaOrdinata.getQuantita()*pietanza.getPrezzo());
    		
    		if(pietanza.getCodice().equals("000"))
    			esisteCoperto = true;
    		
    	}
    	//FIXME approssimare 2 decimali
    	
    	if(persone==0)
    		persone=new Float(1);
    	ordine.setQuotaPersona(totale/persone);
    	ordine.setTotale(totale);
    	ordine.setPietanzeOrdinate(pietanzeOrdinate);

    	

    	ordineRepository.save(ordine);
    	
    	if(esisteCoperto){
	    	tavoloAccomodato.setStato(TavoloStato.ORDINATO);
	    	tavoloAccomodato.setOrdinazionePersona(body.getPersonaOrdine());
	    	tavoloAccomodato.setOrdinazioneOrario(ZonedDateTime.now(ZoneId.systemDefault()));
	    	tavoloAccomodatoService.save(tavoloAccomodato);
    	}
    	
    	printerService.printOrder(ordine.getId());
    	printerService.printCucina(ordine.getId());

    	/*body.setQuotaPersona(ordine.getQuotaPersona());
    	body.setTotale(ordine.getTotale());
    	body.setId(ordine.getId());
    	body.setData(new DateTime(ordine.getDataOrdine().toInstant().toEpochMilli(), DateTimeZone.getDefault()));
    	return body;*/
    	return ordineToOrdineDto(ordine);
    }
    
    public OrdineDto stampaScontrino(Long idOrdine) {
    	Ordine ordine = ordineRepository.findOne(idOrdine);
    	printerService.printOrder(ordine.getId());
    	return ordineToOrdineDto(ordine);
    }
    
    public OrdineDto stampaCucina(Long idOrdine) {
    	Ordine ordine = ordineRepository.findOne(idOrdine);
    	printerService.printCucina(ordine.getId());;
    	return ordineToOrdineDto(ordine);
    }
    
    public List<OrdineDto> listaOrdiniByTavoloId(Long tavoloAccomodatoId){
    	TavoloAccomodato tavoloAccomodato = new TavoloAccomodato(tavoloAccomodatoId);
    	List<Ordine> ordini = ordineRepository.findByTavoloAccomodato(tavoloAccomodato);
    	
    	List<OrdineDto> response = new ArrayList<OrdineDto>();
    	for(Ordine ordine : ordini){
    		response.add(ordineToOrdineDto(ordine));
    	}
    	return response;
    }
    
    public OrdineDto ordineToOrdineDto(Ordine ordine){
    	OrdineDto ordineDto = new OrdineDto();
    	ordineDto.setId(ordine.getId());
    	ordineDto.setAsporto(ordine.isAsporto());
    	ordineDto.setData(new DateTime(ordine.getDataOrdine().toInstant().toEpochMilli(), DateTimeZone.getDefault()));
    	ordineDto.setIdTavoloAccomodato(ordine.getTavoloAccomodato().getId());
    	ordineDto.setNumCoperti(ordine.getNumeroCoperti());
    	ordineDto.setPersonaOrdine(ordine.getPersonaOrdine());
    	ordineDto.setQuotaPersona(ordine.getQuotaPersona());
    	ordineDto.setTotale(ordine.getTotale());
    	
    	List<PietanzaOrdinata> pietanzeOrdinate = ordine.getPietanzeOrdinate();
    	List<PietanzaOrdinataDto> pietanzeOrdinateDto = new ArrayList<PietanzaOrdinataDto>();
    	for(PietanzaOrdinata pietanzaOrdinata : pietanzeOrdinate){
    		pietanzeOrdinateDto.add(pietanzaOrdinataToPietanzaOrdinataDto(pietanzaOrdinata));
    	}
    	ordineDto.setPietanzeOrdinate(pietanzeOrdinateDto);
    	return ordineDto;
    }
    
    public PietanzaDto pietanzaToPietanzaDto(Pietanza pietanza){
		PietanzaDto pietanzaDto = new PietanzaDto();
		pietanzaDto.setId(pietanza.getId());
		pietanzaDto.setNome(pietanza.getNome());
		pietanzaDto.setPrezzo(pietanza.getPrezzo());
		pietanzaDto.setDescrizione(pietanza.getDescrizione());
		if(pietanza.getCodice().equals("000"))
			pietanzaDto.setCoperto(true);
		else
			pietanzaDto.setCoperto(false);
		PietanzaCategoriaDto pietanzaCategoriaDto = new PietanzaCategoriaDto();
		pietanzaCategoriaDto.setId(pietanza.getPietanzaCategoria().getId());
		pietanzaCategoriaDto.setCodice(pietanza.getPietanzaCategoria().getCodice());
		pietanzaDto.setCategoria(pietanzaCategoriaDto);
		return pietanzaDto;
    }
    
    public PietanzaOrdinataDto pietanzaOrdinataToPietanzaOrdinataDto(PietanzaOrdinata pietanzaOrdinata){
		PietanzaOrdinataDto pietanzaOrdinataDto = new PietanzaOrdinataDto();
		pietanzaOrdinataDto.setId(pietanzaOrdinata.getId());
		pietanzaOrdinataDto.setNote(pietanzaOrdinata.getNote());
		pietanzaOrdinataDto.setNumSequenza(pietanzaOrdinata.getNumeroSequenza());
		pietanzaOrdinataDto.setQuantita(pietanzaOrdinata.getQuantita());
		pietanzaOrdinataDto.setPietanza(pietanzaToPietanzaDto(pietanzaOrdinata.getPietanza()));
		return pietanzaOrdinataDto;
    }
    
}
