package ci.bda.confirming.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import ci.bda.confirming.model.ChargesAffaires;

public interface ChargeAffaireRepository extends PagingAndSortingRepository<ChargesAffaires, Long> {

}
