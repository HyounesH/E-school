package ma.ensa.dao;

import java.util.List;

import ma.ensa.beans.helpers.Matiere_Prof;

public interface EschoolDao {
  
	
	public boolean isLogin(String login , String motPass);
	public String getNom(String login,String motpass);
	public int getCode(String login , String motpass);
	public List<Matiere_Prof> listMatieres(int code);
	public void delete(int code ,String ref);
}
