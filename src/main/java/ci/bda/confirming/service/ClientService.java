package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import ci.bda.confirming.model.Clients;

@Validated
public interface ClientService {

	@NotNull
	Page<Clients> getAllClients(Pageable pageable);

	Clients get(@Min(value = 1L, message = "Invalid Client ID") Long id);

	Clients save(Clients client);
	
	void delete(@Min(value = 1L, message = "Invalid Client ID") Long id);
}
