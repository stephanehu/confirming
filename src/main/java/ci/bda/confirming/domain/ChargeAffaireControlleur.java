package ci.bda.confirming.domain;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ci.bda.confirming.model.ChargesAffaires;
import ci.bda.confirming.service.ChargeAffaireServiceImpl;


@RestController
@RequestMapping("/confirming/chargedaffaire")
public class ChargeAffaireControlleur {
	@Autowired
	ChargeAffaireServiceImpl chargeAffaireService;

	@GetMapping("/")
	public ResponseEntity<Page<ChargesAffaires>> selectAll(Pageable pageable) {
		Page<ChargesAffaires> pages = chargeAffaireService.getAllChargesAffaires(pageable);
		return new ResponseEntity<Page<ChargesAffaires>>(pages, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> select(@PathVariable(name = "id", required = true) Long id) {
		ChargesAffaires chargeAffaire = chargeAffaireService.get(id);
		return new ResponseEntity<>(chargeAffaire, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<?> create(@Valid @RequestBody ChargesAffaires chargeAffaire) {
		chargeAffaire = chargeAffaireService.save(chargeAffaire);

		String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
				.buildAndExpand(chargeAffaire.getId()).toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", uri);

		return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody ChargesAffaires chargeAffaire,
			@PathVariable(name = "id", required = true) Long id) {
		chargeAffaireService.get(id);
		chargeAffaire = chargeAffaireService.save(chargeAffaire);
		return new ResponseEntity<>(chargeAffaire, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id", required = true) Long id) {
		chargeAffaireService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
