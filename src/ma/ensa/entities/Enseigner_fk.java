package ma.ensa.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Enseigner_fk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="code")
	private Professeur prof;
	@ManyToOne
	@JoinColumn(name="reference")
	private Matiere mat;
	public Enseigner_fk(Professeur prof, Matiere mat) {
		super();
		this.prof = prof;
		this.mat = mat;
	}
	public Enseigner_fk(){};
	public Professeur getProf() {
		return prof;
	}
	public void setProf(Professeur prof) {
		this.prof = prof;
	}
	public Matiere getMat() {
		return mat;
	}
	public void setMat(Matiere mat) {
		this.mat = mat;
	}

	
	
}
