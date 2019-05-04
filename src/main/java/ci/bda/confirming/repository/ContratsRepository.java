package ci.bda.confirming.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import ci.bda.confirming.model.Contrats;

public interface ContratsRepository extends PagingAndSortingRepository<Contrats, Long> {

	@Query(value = "SELECT cont.* FROM contrats cont JOIN charges_d_affaires cda ON cont.charge_d_affaire_id = cda.id WHERE cda.id=?1",nativeQuery = true)
	Page<Contrats> findByChargesAffaires(Long id,Pageable pageable);
	
	@Query(value = "SELECT cont.* FROM contrats cont JOIN clients cli ON cont.client_Id = cli.id WHERE cli.id=?1",nativeQuery = true)
	Page<Contrats> findByClients(Long id,Pageable pageable);

	@Query(value = "SELECT cont.* FROM contrats cont JOIN charges_d_affaires cda ON cont.charge_d_affaire_id = cda.id WHERE cda.id=?1 AND cont.client_Id=?2",nativeQuery = true)
	Page<Contrats> findByChargesAffairesAndClients(Long chargeAffaireId,Long clientId,Pageable pageable);
}
