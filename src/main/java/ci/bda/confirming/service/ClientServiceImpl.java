package ci.bda.confirming.service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ci.bda.confirming.exception.ResourceNotFoundException;
import ci.bda.confirming.model.Clients;
import ci.bda.confirming.repository.ClientRepository;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	

	public ClientServiceImpl(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}

	public ClientRepository getClientRepository() {
		return clientRepository;
	}

	public void setClientRepository(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public @NotNull Page<Clients> getAllClients(Pageable pageable) {
		return this.clientRepository.findAll(pageable);
	}

	@Override
	public Clients get(@Min(value = 1, message = "Invalid Client ID") Long id) {		
		return this.clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client with id "+id +" not found"));
	}

	@Override
	public Clients save(Clients client) {
		return this.clientRepository.save(client);
	}

	@Override
	public void delete(@Min(value = 1, message = "Invalid Client ID") Long id) {
		this.get(id); 
		this.clientRepository.deleteById(id);
	}

}
