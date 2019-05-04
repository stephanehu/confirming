package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import ci.bda.confirming.model.Factures;

@Validated
public interface FactureService {

	@NotNull
	Page<Factures> getAllFactures(Pageable pageable);

	Factures get(@Min(value = 1L, message = "Invalid Facture ID") Long id);

	void delete(@Min(value = 1L, message = "Invalid Facture ID") Long id);

	Factures save(Factures facture);
}
