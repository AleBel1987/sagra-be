package it.alecata.sagra.repository;

import it.alecata.sagra.domain.Serata;
import it.alecata.sagra.domain.TavoloAccomodato;
import it.alecata.sagra.domain.TavoloReale;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the TavoloAccomodato entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TavoloAccomodatoRepository extends JpaRepository<TavoloAccomodato,Long> {
	
	List<TavoloAccomodato> findAllBySerata(Serata serata);
	List<TavoloAccomodato> findAllBySerataAndTavoloReale(Serata serata, TavoloReale tavoloReale);
    
}
