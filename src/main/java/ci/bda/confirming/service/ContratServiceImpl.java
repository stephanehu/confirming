package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.bda.confirming.exception.ResourceNotFoundException;
import ci.bda.confirming.model.Contrats;
import ci.bda.confirming.repository.ContratsRepository;

@Service
@Transactional
public class ContratServiceImpl implements ContratService {

	@Autowired
	ContratsRepository contratRepository;
	
	

	public ContratServiceImpl(ContratsRepository contratRepository) {
		super();
		this.contratRepository = contratRepository;
	}

	@Override
	public @NotNull Page<Contrats> getAllContrats(Pageable pageable) {
		return this.contratRepository.findAll(pageable);
	}

	@Override
	public Contrats get(@Min(value = 1, message = "Invalid Contrat ID") Long id) {		
		return this.contratRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contrat with id "+id +" not found"));
	}

	@Override
	public Contrats save(Contrats contrat) {
		return this.contratRepository.save(contrat);
	}

	@Override
	public void delete(@Min(value = 1, message = "Invalid Contrat ID") Long id) {
		this.contratRepository.deleteById(id);
	}

	@Override
	public @NotNull Page<Contrats> getByCda(@Min(value = 1, message = "Invalid Charge d'Affaire ID") Long id,Pageable pageable) {
		return this.contratRepository.findByChargesAffaires(id, pageable);
	}
	
	@Override
	public @NotNull Page<Contrats> getByCli(@Min(value = 1, message = "Invalid Client ID") Long id,Pageable pageable) {
		return this.contratRepository.findByClients(id, pageable);
	}
	


	
}
