package ci.bda.confirming.model.dto;

import java.util.Set;

import ci.bda.confirming.model.Factures;

public class FactureDuFournisseur {

	private Long fournisseurId;
	private Set<Factures> factures;

	public Long getFournisseurId() {
		return fournisseurId;
	}

	public void setFournisseurId(Long fournisseurId) {
		this.fournisseurId = fournisseurId;
	}

	public Set<Factures> getFactures() {
		return factures;
	}

	public void setFactures(Set<Factures> factures) {
		this.factures = factures;
	}

}
