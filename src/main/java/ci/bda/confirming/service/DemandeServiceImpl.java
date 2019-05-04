package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.bda.confirming.exception.ResourceNotFoundException;
import ci.bda.confirming.model.Demandes;
import ci.bda.confirming.repository.DemandeRepository;

@Service
@Transactional
public class DemandeServiceImpl implements DemandeService {

	@Autowired
	DemandeRepository DemandeRepository;
	
	

	public DemandeServiceImpl(DemandeRepository DemandeRepository) {
		super();
		this.DemandeRepository = DemandeRepository;
	}

	@Override
	public @NotNull Page<Demandes> getAllDemandes(Pageable pageable) {
		return this.DemandeRepository.findAll(pageable);
	}

	@Override
	public Demandes get(@Min(value = 1, message = "Invalid Demande ID") Long id) {		
		return this.DemandeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Demande with id "+id +" not found"));
	}
	@Override
	public void delete(@Min(value = 1, message = "Invalid Demande ID") Long id) {	
		this.get(id);
		this.DemandeRepository.deleteById(id);
	}
	@Override
	public Demandes save(Demandes demande) {
		return this.DemandeRepository.save(demande);
	}

}
