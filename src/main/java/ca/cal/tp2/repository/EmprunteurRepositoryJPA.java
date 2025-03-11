package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.*;

import java.util.List;

public class EmprunteurRepositoryJPA implements EmprunteurRepository {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");

    @Override
    public void save(Emprunteur emprunteur) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(emprunteur);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Emprunteur findById(Long id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Emprunteur> query = em.createNamedQuery("SELECT id FROM Emprunteur" +
                                                            "WHERE id = :id", Emprunteur.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public void empruntDocument(Emprunteur emprunteur, Document document) {
        if (!document.estDisponible()) {
            throw new RuntimeException("Ce document est présentment indisponible. Veuillez réessayer plus tard.");
        }
        EntityManager em = emf.createEntityManager();
        Emprunt emprunt = new Emprunt();

        em.getTransaction().begin();
        document.emprunterDocument();
        emprunt.setEmprunteur(emprunteur);
        emprunt.ajouterEmprunt(document);
        em.persist(emprunt);
        em.merge(document);
        em.getTransaction().commit();
        em.close();
    }

    public List<Emprunt> listerEmprunts(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("SELECT e FROM Emprunteur e" + "WHERE e.emprunteur.id = :id");
        query.setParameter("id", id);

        List<Emprunt> emprunts = query.getResultList();

        for (Emprunt emprunt : emprunts) {
            Query queries = em.createNamedQuery("SELECT e FROM EmprunteurDetail e"
                    + "WHERE e.empruntDetail.id = :emprunt_id");
            queries.setParameter("emprunt_id", emprunt.getId());
            emprunt.setDocuments(queries.getResultList());
        }
        return emprunts;
    }
}
