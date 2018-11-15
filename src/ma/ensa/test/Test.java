package ma.ensa.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure().buildSessionFactory();

}
}
