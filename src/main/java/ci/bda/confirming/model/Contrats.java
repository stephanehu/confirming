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
//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "contrats")
public class Contrats {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "numero", unique = true)
	private String numero;

	@Column(name = "date_etablisssement")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateEtablie;

	@Column(name = "date_echeance")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateEcheance;

	@Column(name = "taux")
	private Double taux;

	@Column(name = "montant_ligne_confirming")
	private BigDecimal ligne;

	@Column(name = "taux_commission_service")
	private BigDecimal tauxCommissionDeService;

	@Column(name = "taux_commission_financement")
	private BigDecimal tauxCommissionDeFinancement;

	@ManyToOne
	@JoinColumn(name = "charge_d_affaire_id")
	private ChargesAffaires chargesAffaires;
	
	@ManyToOne
	@JoinColumn(name = "client_Id")
	private Clients client;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

	public BigDecimal getLigne() {
		return ligne;
	}

	public void setLigne(BigDecimal ligne) {
		this.ligne = ligne;
	}

	public BigDecimal getTauxCommissionDeService() {
		return tauxCommissionDeService;
	}

	public void setTauxCommissionDeService(BigDecimal tauxCommissionDeService) {
		this.tauxCommissionDeService = tauxCommissionDeService;
	}

	public BigDecimal getTauxCommissionDeFinancement() {
		return tauxCommissionDeFinancement;
	}

	public void setTauxCommissionDeFinancement(BigDecimal tauxCommissionDeFinancement) {
		this.tauxCommissionDeFinancement = tauxCommissionDeFinancement;
	}

	
	//@JsonIgnore
	public ChargesAffaires getChargesAffaires() {
		return chargesAffaires;
	}

	public void setChargesAffaires(ChargesAffaires chargesAffaires) {
		this.chargesAffaires = chargesAffaires;
	}

	//@JsonIgnore
	public Clients getClient() {
		return client;
	}

	public void setClient(Clients client) {
		this.client = client;
	}

}
