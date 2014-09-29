package jpa;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Personne;
import domain.Voiture;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			

			ArrayList <Voiture> list_v1 = new ArrayList <Voiture>();
			
			
			ArrayList <Voiture> list_v2 = new ArrayList <Voiture>();
			
			
			
			ArrayList <Voiture> list_v3 = new ArrayList <Voiture>();
			

			Personne p =new Personne( "Jean", "Duran", list_v1);
			Personne p2 =new Personne( "Michel", "Jack", list_v1);
			Personne p3 =new Personne( "Patrick", "Dupontel", list_v3);

			Voiture v =new Voiture(5, p2);
			Voiture v1 =new Voiture(5, p);
			Voiture v2 =new Voiture(4, p);
			Voiture v3 =new Voiture(5, p3);

			list_v1.add(v);
			list_v2.add(v1);
			list_v2.add(v2);
			list_v3.add(v3);
			
			manager.persist(p);
			manager.persist(p2);
			manager.persist(p3);
			
			manager.persist(v);
			manager.persist(v2);
			manager.persist(v3);
			
			System.err.println(p2.getId_personne());
			
			//manager.persist(et);
			

					
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		/*
		Enseignant es = (Enseignant) manager.createQuery(
				"select e1 from Enseignant as e1 where e1.nom='barais'")
				.getSingleResult();*/
		
	}

}
