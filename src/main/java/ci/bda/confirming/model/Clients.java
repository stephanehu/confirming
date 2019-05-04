package ci.bda.confirming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Clients {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name",unique = true)
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "profil_banque")
	private String profilBanque;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getProfilBanque() {
		return profilBanque;
	}

	public void setProfilBanque(String profilBanque) {
		this.profilBanque = profilBanque;
	}

	
}
