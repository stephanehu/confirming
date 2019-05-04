package ci.bda.confirming.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ci.bda.confirming.model.Offres;

public interface OffreRepository extends PagingAndSortingRepository<Offres, Long> {

}
