package ma.ensa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Enseigner {
	@Id
	private Enseigner_fk fk;
	private int heures;
	
	public Enseigner(Professeur prof,Matiere mat,int heures){
		this.fk=new Enseigner_fk(prof, mat);
		this.heures=heures;
	}
	
	public Enseigner(){};
	
	public Enseigner_fk getFk() {
		return fk;
	}
	public void setFk(Enseigner_fk fk) {
		this.fk = fk;
	}
	public int getHeures() {
		return heures;
	}
	public void setHeures(int heures) {
		this.heures = heures;
	}
	
	

}
