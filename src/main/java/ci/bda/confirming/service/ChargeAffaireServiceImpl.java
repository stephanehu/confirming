package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.bda.confirming.exception.ResourceNotFoundException;
import ci.bda.confirming.model.ChargesAffaires;
import ci.bda.confirming.repository.ChargeAffaireRepository;

@Service
@Transactional
public class ChargeAffaireServiceImpl implements ChargeAffaireService {

	@Autowired
	ChargeAffaireRepository chargeAffairetRepository;

	public ChargeAffaireServiceImpl(ChargeAffaireRepository chargeAffairetRepository) {
		super();
		this.chargeAffairetRepository = chargeAffairetRepository;
	}

	@Override
	public @NotNull Page<ChargesAffaires> getAllChargesAffaires(Pageable pageable) {
		return this.chargeAffairetRepository.findAll(pageable);
	}

	@Override
	public ChargesAffaires get(@Min(value = 1, message = "Invalid Charge d'Affaire ID") Long id) {
		return this.chargeAffairetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client with id " + id + " not found"));
	}

	@Override
	public ChargesAffaires save(ChargesAffaires chargeAffaire) {
		return this.chargeAffairetRepository.save(chargeAffaire);
	}

	public ChargeAffaireRepository getChargeAffairetRepository() {
		return chargeAffairetRepository;
	}

	public void setChargeAffairetRepository(ChargeAffaireRepository chargeAffairetRepository) {
		this.chargeAffairetRepository = chargeAffairetRepository;
	}

	@Override
	public void delete(@Min(value = 1, message = "Invalid Charge d'Affaire ID") Long id) {
		this.get(id);
		this.chargeAffairetRepository.deleteById(id);
	}

}
