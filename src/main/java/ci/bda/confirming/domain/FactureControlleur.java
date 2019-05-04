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

import ci.bda.confirming.model.Factures;
import ci.bda.confirming.service.FactureServiceImpl;

@RestController
@RequestMapping("/confirming/facture")
public class FactureControlleur {
	@Autowired
	FactureServiceImpl factureService;

	@GetMapping("/")
	public ResponseEntity<Page<Factures>> selectAll(Pageable pageable) {
		Page<Factures> pages = factureService.getAllFactures(pageable);
		return new ResponseEntity<Page<Factures>>(pages, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> select(@PathVariable(name = "id") Long id) {
		Factures Facture = factureService.get(id);
		return new ResponseEntity<>(Facture, HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<?> create(@Valid @RequestBody Factures facture) {
		facture = factureService.save(facture);
		String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(facture.getId())
				.toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", uri);

		return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Factures facture,
			@PathVariable(name = "id", required = true) Long id) {
		factureService.get(id);
		facture = factureService.save(facture);
		return new ResponseEntity<>(facture, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id", required = true) Long id) {
		factureService.delete(id);		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
