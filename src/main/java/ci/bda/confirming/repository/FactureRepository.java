package ci.bda.confirming.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ci.bda.confirming.model.Factures;
public interface FactureRepository extends PagingAndSortingRepository<Factures, Long> {

}
