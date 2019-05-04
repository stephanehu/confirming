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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ci.bda.confirming.model.Fournisseurs;
import ci.bda.confirming.service.FournisseurServiceImpl;

public class FournisseurControlleur {
	@Autowired
	FournisseurServiceImpl fournisseurService;

	@GetMapping("/")
	public ResponseEntity<Page<Fournisseurs>> selectAll(Pageable pageable) {
		Page<Fournisseurs> pages = fournisseurService.getAllFournisseurs(pageable);
		return new ResponseEntity<Page<Fournisseurs>>(pages, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> select(@PathVariable(name = "id", required = true) Long id) {
		Fournisseurs fournisseur = fournisseurService.getFournisseur(id);
		return new ResponseEntity<>(fournisseur, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<?> create(@Valid @RequestBody Fournisseurs fournisseur) {
		fournisseur = fournisseurService.save(fournisseur);

		String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(fournisseur.getId())
				.toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", uri);

		return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Fournisseurs fournisseur,
			@PathVariable(name = "id", required = true) Long id) {
		fournisseurService.getFournisseur(id);
		fournisseur = fournisseurService.save(fournisseur);
		return new ResponseEntity<>(fournisseur, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id", required = true) Long id) {

		fournisseurService.getFournisseur(id);
		fournisseurService.getFournisseurRepository().deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
