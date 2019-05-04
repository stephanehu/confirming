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

import ci.bda.confirming.model.Offres;
import ci.bda.confirming.service.OffreServiceImpl;

@RestController
@RequestMapping("/confirming/offre")
public class OffreControlleur {
	@Autowired
	OffreServiceImpl offreService;

	@GetMapping("/")
	public ResponseEntity<Page<Offres>> selectAll(Pageable pageable) {
		Page<Offres> pages = offreService.getAllOffres(pageable);
		return new ResponseEntity<Page<Offres>>(pages, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> select(@PathVariable(name = "id") Long id) {
		Offres offre = offreService.get(id);
		return new ResponseEntity<>(offre, HttpStatus.OK);
	}
	@PostMapping("/")
	public ResponseEntity<?> create(@Valid @RequestBody Offres offre) {
		offre = offreService.save(offre);
		String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(offre.getId())
				.toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", uri);

		return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Offres offre,
			@PathVariable(name = "id", required = true) Long id) {
		offreService.get(id);
		offre = offreService.save(offre);
		return new ResponseEntity<>(offre, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id", required = true) Long id) {
		offreService.delete(id);		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
