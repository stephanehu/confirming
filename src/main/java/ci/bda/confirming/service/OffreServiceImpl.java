package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.bda.confirming.exception.ResourceNotFoundException;
import ci.bda.confirming.model.Offres;
import ci.bda.confirming.repository.OffreRepository;

@Service
@Transactional
public class OffreServiceImpl implements OffreService {

	@Autowired
	OffreRepository offreRepository;

	public OffreServiceImpl(OffreRepository OffreRepository) {
		super();
		this.offreRepository = OffreRepository;
	}

	@Override
	public @NotNull Page<Offres> getAllOffres(Pageable pageable) {
		return this.offreRepository.findAll(pageable);
	}

	@Override
	public Offres get(@Min(value = 1, message = "Invalid Offre ID") Long id) {
		return this.offreRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Offre with id " + id + " not found"));
	}

	@Override
	public void delete(@Min(value = 1, message = "Invalid Offre ID") Long id) {
		this.get(id);
		this.offreRepository.deleteById(id);

	}

	@Override
	public Offres save(Offres offre) {
		return this.offreRepository.save(offre);
	}

}
