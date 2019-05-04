package ci.bda.confirming.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="factures")
public class Factures {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="reference",unique = true)
	private String reference;
	
	@Column(name="montant")
	private BigDecimal montant;
	
	@Column(name="date_etablisssement")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateEtablie;
	
	@Column(name="date_echeance")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateEcheance;
	
	@Column(name="infos")
	private String infoSupplementaire;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="fournisseur_Id")
	private Fournisseurs fournisseur;

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

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public LocalDate getDateEtablie() {
		return dateEtablie;
	}

	public void setDateEtablie(LocalDate dateEtablie) {
		this.dateEtablie = dateEtablie;
	}

	public LocalDate getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(LocalDate dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public String getInfoSupplementaire() {
		return infoSupplementaire;
	}

	public void setInfoSupplementaire(String infoSupplementaire) {
		this.infoSupplementaire = infoSupplementaire;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Fournisseurs getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseurs fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	
}
