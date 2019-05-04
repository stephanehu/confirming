package ci.bda.confirming.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ci.bda.confirming.model.Clients;

public interface ClientRepository extends PagingAndSortingRepository<Clients, Long> {

}
