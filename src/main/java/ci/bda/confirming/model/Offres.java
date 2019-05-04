package ci.bda.confirming.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "offres")
public class Offres {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "reference", unique = true)
	private String reference;

	@Column(name = "date_etablisssement")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateEtablie;

	@Column(name = "date_paiement")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDePaiement;

	@Column(name = "montant")
	private BigDecimal montant;

	@Column(name = "montant_commission_service")
	private BigDecimal montantCommissionService;

	@Column(name = "montant_commission_financement")
	private BigDecimal montanCommissionFinancementt;

	@Column(name = "status")
	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "facture_id",referencedColumnName = "id")
	@Nullable
	private Factures facture;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public LocalDate getDateEtablie() {
		return dateEtablie;
	}

	public void setDateEtablie(LocalDate dateEtablie) {
		this.dateEtablie = dateEtablie;
	}

	public LocalDate getDateDePaiement() {
		return dateDePaiement;
	}

	public void setDateDePaiement(LocalDate dateDePaiement) {
		this.dateDePaiement = dateDePaiement;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public BigDecimal getMontantCommissionService() {
		return montantCommissionService;
	}

	public void setMontantCommissionService(BigDecimal montantCommissionService) {
		this.montantCommissionService = montantCommissionService;
	}

	public BigDecimal getMontanCommissionFinancementt() {
		return montanCommissionFinancementt;
	}

	public void setMontanCommissionFinancementt(BigDecimal montanCommissionFinancementt) {
		this.montanCommissionFinancementt = montanCommissionFinancementt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Factures getFacture() {
		return facture;
	}

	public void setFacture(Factures facture) {
		this.facture = facture;
	}

}
