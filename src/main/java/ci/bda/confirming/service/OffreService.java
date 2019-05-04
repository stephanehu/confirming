package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import ci.bda.confirming.model.Offres;

@Validated
public interface OffreService {

	@NotNull
	Page<Offres> getAllOffres(Pageable pageable);

	Offres get(@Min(value = 1L, message = "Invalid Offre ID") Long id);

	void delete(@Min(value = 1L, message = "Invalid Offre ID") Long id);

	Offres save(Offres offre);
}
