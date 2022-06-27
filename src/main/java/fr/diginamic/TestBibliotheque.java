package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

public class TestBibliotheque {
    public static void main(String[] args) {
        EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("tp-livre");

        EntityManager et = entityManager.createEntityManager();

        et.getTransaction().begin();

         Livre livre = et.find(Livre.class, 1);
        System.out.println(livre);

        Client client  = et.find(Client.class, 1);

//        if (client != null) {
//            Emprunt emprunt = new Emprunt(LocalDateTime.now(), LocalDateTime.now().plusWeeks(2L), 10, client);
//            et.persist(emprunt);
//        }

        // Réaliser une requête qui permet d’extraire un emprunt en fonction son id.
        Emprunt emprunt = et.find(Emprunt.class, 1);

        // Affichez tous les livres associés
        System.out.println("Livres associés à l'emprunt 1");
        emprunt.getLivres().forEach(System.out::println);

        // Réaliser une requête qui permet d’extraire tous les emprunts d’un client donné.
        System.out.println("emprunts du client 1");
        TypedQuery<Emprunt> empruntsDunClient = et.createQuery("select e from Emprunt e where " +
                "client=:id", Emprunt.class);
        Client toFind = new Client();
        toFind.setId(1);
        empruntsDunClient.setParameter("id", toFind);
        List<Emprunt> emprunts = empruntsDunClient.getResultList();
        emprunts.forEach(System.out::println);

        et.getTransaction().commit();


    }

}
