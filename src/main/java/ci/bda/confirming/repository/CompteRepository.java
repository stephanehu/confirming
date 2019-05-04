package ci.bda.confirming.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ci.bda.confirming.model.Compte;

public interface CompteRepository extends PagingAndSortingRepository<Compte, Long> {

}
