package ma.ensa.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professeur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;
	private String nom;
	private String prenom;
	private String login;
	private String motpasse;
	
	
	@OneToMany(mappedBy="fk.prof")
	private Set<Enseigner> enseigner=new HashSet<Enseigner>();
	
	public Professeur(String nom, String prenom, String login, String motpasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.motpasse = motpasse;
	}
	
	public Professeur(){}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotpasse() {
		return motpasse;
	}

	public void setMotpasse(String motpasse) {
		this.motpasse = motpasse;
	}

	public Set<Enseigner> getEnseigner() {
		return enseigner;
	}

	public void setEnseigner(Set<Enseigner> enseigner) {
		this.enseigner = enseigner;
	};
	
	

}
