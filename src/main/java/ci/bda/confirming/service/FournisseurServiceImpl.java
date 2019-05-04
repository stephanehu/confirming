package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.bda.confirming.exception.ResourceNotFoundException;
import ci.bda.confirming.model.Fournisseurs;
import ci.bda.confirming.repository.FournisseurRepository;

@Service
@Transactional
public class FournisseurServiceImpl implements FournisseurService {

	@Autowired
	FournisseurRepository fournisseurRepository;

	public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
		super();
		this.fournisseurRepository = fournisseurRepository;
	}

	@Override
	public @NotNull Page<Fournisseurs> getAllFournisseurs(Pageable pageable) {
		return this.fournisseurRepository.findAll(pageable);
	}

	@Override
	public Fournisseurs getFournisseur(@Min(value = 1, message = "Invalid Fournisseur ID") Long id) {
		return this.fournisseurRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Fournisseur with id " + id + " not found"));
	}

	@Override
	public Fournisseurs save(Fournisseurs fournisseur) {
		return this.fournisseurRepository.save(fournisseur);
	}

	public FournisseurRepository getFournisseurRepository() {
		return fournisseurRepository;
	}

	public void setFournisseurRepository(FournisseurRepository fournisseurRepository) {
		this.fournisseurRepository = fournisseurRepository;
	}

	@Override
	public void delete(@Min(value = 1, message = "Invalid Fournisseur ID") Long id) {
		this.getFournisseur(id);
		this.fournisseurRepository.deleteById(id);
	}

}
