package ma.ensa.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ma.ensa.beans.helpers.Matiere_Prof;
import ma.ensa.dao.EschoolDao;
import ma.ensa.dao.HibernateUtil;
import ma.ensa.entities.Enseigner;
import ma.ensa.entities.Matiere;
import ma.ensa.entities.Professeur;

public class EschoolDaoImpl  implements EschoolDao{

	@Override
	public boolean isLogin(String login, String motPass) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("FROM Professeur WHERE login =? and motpasse = ?");
		query.setString(0, login);
		query.setString(1, motPass);
		Professeur c=(Professeur)query.uniqueResult();
		session.getTransaction().commit();
		session.close();
        if(c==null){
        	return false;
        }
        else{
		return true;
        }
	}

	@Override
	public String getNom(String login, String motpass) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("FROM Professeur WHERE login =? and motpasse = ?");
		query.setString(0, login);
		query.setString(1, motpass);
		Professeur c=(Professeur)query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return c.getNom();
	}

	@Override
	public int getCode(String login, String motpass) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("FROM Professeur WHERE login =? and motpasse = ?");
		query.setString(0, login);
		query.setString(1, motpass);
		Professeur c=(Professeur)query.uniqueResult();
		session.getTransaction().commit();
		session.close();
		return c.getCode();
	}

	@Override
	public List<Matiere_Prof> listMatieres(int code) {
		List<String> listReferences=new ArrayList<String>();
		List<Enseigner> list_ens=new ArrayList<Enseigner>();
		List<Matiere> listMatiere=new ArrayList<Matiere>();
		List<Matiere_Prof> list=new ArrayList<Matiere_Prof>();
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("FROM Enseigner WHERE code=?");
		query.setInteger(0, code);
		list_ens=query.list();
		for(Enseigner e:list_ens){
			listReferences.add(e.getFk().getMat().getReference());
		}
		Query query2=session.createQuery("FROM Matiere WHERE reference in(:listref)");
		query2.setParameter("listref", listReferences);
		listMatiere=query2.list();
		int i=0;
		for(Matiere m:listMatiere){
			Matiere_Prof mp=new Matiere_Prof();
			mp.setReference(m.getReference());
			mp.setDescription(m.getDescription());
			mp.setVolume(m.getVolume());
			mp.setHeures(list_ens.get(i).getHeures());
			i=i+1;
			list.add(mp);
		}
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

	@Override
	public void delete(int code, String ref) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("DELETE Enseigner WHERE code =? and reference = ?");
		query.setInteger(0,code);
		query.setString(1, ref);
		int q=query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		
	}
	
	

}
