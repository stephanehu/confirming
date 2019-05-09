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

import ci.bda.confirming.model.Clients;
import ci.bda.confirming.service.ClientServiceImpl;

@RestController
@RequestMapping("/confirming/client")
public class ClientControlleur {
	@Autowired
	ClientServiceImpl clientService;

	@GetMapping("/")
	public ResponseEntity<Page<Clients>> selectAll(Pageable pageable) {
		Page<Clients> pages = clientService.getAllClients(pageable);
		return new ResponseEntity<Page<Clients>>(pages, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> select(@PathVariable(name = "id", required = true) Long id) {
		Clients client = clientService.get(id);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<?> create(@Valid @RequestBody Clients client) {
		client = clientService.save(client);
//comment test

		
		String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(client.getId())
				.toString();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", uri);

		return new ResponseEntity<>(null, headers, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Clients client,
			@PathVariable(name = "id", required = true) Long id) {
		clientService.get(id);
		client = clientService.save(client);
		return new ResponseEntity<>(client, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(name = "id", required = true) Long id) {
		clientService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
