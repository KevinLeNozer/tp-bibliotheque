package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestBibliotheque {
    public static void main(String[] args) {
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("tp-livre");

        EntityManager et = entityManager.createEntityManager();

        et.getTransaction().begin();

         Livre livre = et.find(Livre.class, 1);
        System.out.println(livre);

        TypedQuery<Emprunt> query1 = et.createQuery("select ");

        et.getTransaction().commit();


    }
}
