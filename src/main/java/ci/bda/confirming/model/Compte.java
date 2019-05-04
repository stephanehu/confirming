package ci.bda.confirming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comptes")
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "numero")
	private String numero;
	
	@Column(name = "banque_domiciliere")
	private String banqueDomiciliere;
	
	@Column(name = "type_de_compte")
	private String typeDeCompte;

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

	public String getBanqueDomiciliere() {
		return banqueDomiciliere;
	}

	public void setBanqueDomiciliere(String banqueDomiciliere) {
		this.banqueDomiciliere = banqueDomiciliere;
	}

	public String getTypeDeCompte() {
		return typeDeCompte;
	}

	public void setTypeDeCompte(String typeDeCompte) {
		this.typeDeCompte = typeDeCompte;
	}
	
	
}
