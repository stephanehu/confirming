package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import ci.bda.confirming.model.Demandes;

@Validated
public interface DemandeService {

	@NotNull
	Page<Demandes> getAllDemandes(Pageable pageable);

	Demandes get(@Min(value = 1L, message = "Invalid Demande ID") Long id);

	void delete(@Min(value = 1L, message = "Invalid Demande ID") Long id);

	Demandes save(Demandes Demande);
}
