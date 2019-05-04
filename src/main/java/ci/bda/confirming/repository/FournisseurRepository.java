package ci.bda.confirming.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ci.bda.confirming.model.Fournisseurs;

public interface FournisseurRepository extends PagingAndSortingRepository<Fournisseurs, Long> {

}
