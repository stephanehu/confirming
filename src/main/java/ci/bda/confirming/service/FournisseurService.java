package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import ci.bda.confirming.model.Fournisseurs;

@Validated
public interface FournisseurService {

	@NotNull
	Page<Fournisseurs> getAllFournisseurs(Pageable pageable);

	Fournisseurs getFournisseur(@Min(value = 1L, message = "Invalid Fournisseur ID") Long id);

	Fournisseurs save(Fournisseurs fournisseur);
	
	void delete(@Min(value = 1L, message = "Invalid Fournisseur ID") Long id);
}
