package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import ci.bda.confirming.model.Contrats;

@Validated
public interface ContratService {

	@NotNull
	Page<Contrats> getAllContrats(Pageable pageable);

	Contrats get(@Min(value = 1L, message = "Invalid Contrat ID") Long id);

	@NotNull
	Page<Contrats> getByCda(@Min(value = 1L, message = "Invalid Charge d'Affaire ID") Long id,Pageable pageable);

	
	@NotNull
	Page<Contrats> getByCli(@Min(value = 1L, message = "Invalid Client ID") Long id,Pageable pageable);

	Contrats save(Contrats Contrat);

	void delete(@Min(value = 1L, message = "Invalid Contrat ID") Long id);
}
