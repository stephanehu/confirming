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

import ci.bda.confirming.model.Contrats;
import ci.bda.confirming.service.ContratServiceImpl;

@RestController
@RequestMapping("/confirming/contrat")
public class ContratControlleur {

	@Autowired
	ContratServiceImpl contratService;

	@GetMapping("/")
	public ResponseEntity<Page<Contrats>> selectAll(Pageable pageable) {
		Page<Contrats> pages = contratService.getAllContrats(pageable);
		return new ResponseEntity<Page<Contrats>>(pages, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> select(@PathVariable(name = "id", required = true) Long id) {
		Contrats contrat = contratService.get(id);
		return new ResponseEntity<>(contrat, HttpStatus.OK);
	}
	
	@GetMapping("/cda/{id}")
	public ResponseEntity<Page<Contrats>> selectAllByChargeDAffaire(@PathVariable(name = "id", required = true) Long id,Pageable pageable) {
		Page<Contrats> pages = contratService.getByCda(id, pageable);
		return new ResponseEntity<Page<Contrats>>(pages, HttpStatus.OK);
	}
	
	@GetMapping("/cli/{id}")
	public ResponseEntity<Page<Contrats>> selectAllBylient(@PathVariable(name = "id", required = true) Long id,Pageable pageable) {
		Page<Contrats> pages = contratService.getByCli(id, pageable);
		return new ResponseEntity<Page<Contrats>>(pages, HttpStatus.OK);
	}
	
	public ResponseEntity<?> selectAllByChargeDAffaireAndClients(@PathVariable(name = "id", required = true) Long id1,@PathVariable(name = "id", required = true) Long id) {
		Contrats contrat = contratService.get(id);
		return new ResponseEntity<>(contrat, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> create(@Valid @RequestBody Contrats contrat) {
		contrat = contratService.save(contrat);
		String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(contrat.getId())
				.toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", uri);

		return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Contrats contrat,
			@PathVariable(name = "id", required = true) Long id) {
		contratService.get(id);
		contrat = contratService.save(contrat);
		return new ResponseEntity<>(contrat, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id", required = true) Long id) {
		contratService.delete(id);		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
