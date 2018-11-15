package ma.ensa.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Matiere {
	@Id
	private String reference;
	private String description;
	private int volume;
	
	@OneToMany(mappedBy="fk.prof")
	private Set<Enseigner> enseigner=new HashSet<Enseigner>();
	
	public Matiere(String reference, String description, int volume) {
		super();
		this.reference = reference;
		this.description = description;
		this.volume = volume;
	}
	
	public Matiere(){}

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
	};
	

}
