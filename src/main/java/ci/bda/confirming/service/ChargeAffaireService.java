package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import ci.bda.confirming.model.ChargesAffaires;

@Validated
public interface ChargeAffaireService {

	@NotNull
	Page<ChargesAffaires> getAllChargesAffaires(Pageable pageable);

	ChargesAffaires get(@Min(value = 1L, message = "Invalid Charge d'Affaire ID") Long id);

	ChargesAffaires save(ChargesAffaires chargeAffaire);
	
	void delete(@Min(value = 1L, message = "Invalid Charge d'Affaire ID") Long id);
}
