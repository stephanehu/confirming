package ci.bda.confirming.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ci.bda.confirming.model.Demandes;

public interface DemandeRepository extends PagingAndSortingRepository<Demandes, Long> {

}
