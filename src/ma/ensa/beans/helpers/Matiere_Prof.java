package ma.ensa.beans.helpers;

public class Matiere_Prof {

	private String reference;
	private String description;
	private int volume;
	private int heures;
	public Matiere_Prof(String reference, String description, int volume, int heures) {
		super();
		this.reference = reference;
		this.description = description;
		this.volume = volume;
		this.heures = heures;
	}
	
	public Matiere_Prof(){}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public int getHeures() {
		return heures;
	}

	public void setHeures(int heures) {
		this.heures = heures;
	};
	
	
}
