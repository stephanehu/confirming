package ci.bda.confirming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "charges_d_affaires")
public class ChargesAffaires {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "code_employer", unique = true)
	private String codeEmployer;

	@Column(name = "firstname", unique = true)
	private String firstname;

	@Column(name = "lastname", unique = true)
	private String lastname;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@OneToOne(optional = true)
	@JoinColumn(name = "backup_id", referencedColumnName = "id")
	@Nullable
	private ChargesAffaires backupId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeEmployer() {
		return codeEmployer;
	}

	public void setCodeEmployer(String codeEmployer) {
		this.codeEmployer = codeEmployer;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ChargesAffaires getBackupId() {
		return backupId;
	}

	public void setBackupId(ChargesAffaires backupId) {
		this.backupId = backupId;
	}

}
