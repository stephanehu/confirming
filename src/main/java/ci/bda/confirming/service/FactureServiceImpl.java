package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.bda.confirming.exception.ResourceNotFoundException;
import ci.bda.confirming.model.Factures;
import ci.bda.confirming.repository.FactureRepository;

@Service
@Transactional
public class FactureServiceImpl implements FactureService {

	@Autowired
	FactureRepository FactureRepository;

	public FactureServiceImpl(FactureRepository FactureRepository) {
		super();
		this.FactureRepository = FactureRepository;
	}

	@Override
	public @NotNull Page<Factures> getAllFactures(Pageable pageable) {
		return this.FactureRepository.findAll(pageable);
	}

	@Override
	public Factures get(@Min(value = 1, message = "Invalid Facture ID") Long id) {
		return this.FactureRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Facture with id " + id + " not found"));
	}

	@Override
	public void delete(@Min(value = 1, message = "Invalid Facture ID") Long id) {
		get(id);
		this.FactureRepository.deleteById(id);
	}

	@Override
	public Factures save(Factures facture) {
		return this.FactureRepository.save(facture);
	}

}
