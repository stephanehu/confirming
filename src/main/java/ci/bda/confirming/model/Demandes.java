package ci.bda.confirming.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "demandes")
public class Demandes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "reference", unique = true)
	private String reference;

	@Column(name = "numero_de_siret", unique = true)
	private String numeroDeSiret;

	@Column(name = "date_etablisssement")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateEtablie;

	@Column(name = "date_echeance")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateEcheance;

	@ManyToOne
	@JoinColumn(name = "contrat_id")
	private Contrats contrat;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "demande_id")
	private Set<Factures> factures;

	@Column(name = "montant")
	private BigDecimal montant;

	@Column(name = "description")
	private String description;

	@Column(name = "status")
	private String status;

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

	public String getNumeroDeSiret() {
		return numeroDeSiret;
	}

	public void setNumeroDeSiret(String numeroDeSiret) {
		this.numeroDeSiret = numeroDeSiret;
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

	@JsonIgnore
	public Set<Factures> getFactures() {
		return factures;
	}

	public void setFactures(Set<Factures> factures) {
		this.factures = factures;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Contrats getContrat() {
		return contrat;
	}

	public void setContrat(Contrats contrat) {
		this.contrat = contrat;
	}

}
