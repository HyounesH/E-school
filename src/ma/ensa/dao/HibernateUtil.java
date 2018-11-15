package ma.ensa.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory=null;
	public static SessionFactory getSessionFactory(){
		factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		//StandardServiceRegistry registre=new StandardServiceRegistryBuilder().configure().build();
		//factory=new MetadataSources(registre).buildMetadata().buildSessionFactory();
        return factory;
	}

}
