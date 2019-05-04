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

import ci.bda.confirming.model.Demandes;
import ci.bda.confirming.service.DemandeServiceImpl;

@RestController
@RequestMapping("/confirming/demande")
public class DemandeControlleur {

	@Autowired
	DemandeServiceImpl demandeService;

	@GetMapping("/")
	public ResponseEntity<Page<Demandes>> selectAll(Pageable pageable) {
		Page<Demandes> pages = demandeService.getAllDemandes(pageable);
		return new ResponseEntity<Page<Demandes>>(pages, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> select(@PathVariable(name = "id") Long id) {
		Demandes demande = demandeService.get(id);
		return new ResponseEntity<>(demande, HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<?> create(@Valid @RequestBody Demandes demande) {
		demande = demandeService.save(demande);
		String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(demande.getId())
				.toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", uri);

		return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Demandes demande,
			@PathVariable(name = "id", required = true) Long id) {
		demandeService.get(id);
		demande = demandeService.save(demande);
		return new ResponseEntity<>(demande, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id", required = true) Long id) {
		demandeService.delete(id);		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
