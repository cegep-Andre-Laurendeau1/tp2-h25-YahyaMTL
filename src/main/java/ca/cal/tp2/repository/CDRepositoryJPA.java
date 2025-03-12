package ca.cal.tp2.repository;

import ca.cal.tp2.modele.CD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class CDRepositoryJPA implements CDRepository {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");

    public void save(CD cd) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(cd);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CD findById(Long id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<CD> query = em.createQuery("SELECT c FROM CD c WHERE c.id = :id", CD.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public CD findByTitre(String titre) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<CD> query = em.createQuery("SELECT c FROM CD c WHERE c.titre LIKE :titre", CD.class);
        query.setParameter("titre", "%" + titre + "%");
        return query.getResultList().get(0);
    }

    public CD findByArtist(String artiste) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<CD> query = em.createQuery("SELECT c FROM CD c WHERE c.artiste = :artiste", CD.class);
        query.setParameter("artiste", artiste);
        return query.getResultList().get(0);
    }

    public List<CD> findByYear(int annee) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<CD> query = em.createQuery("SELECT c FROM CD c " +
                "WHERE c.datePublication BETWEEN :anneeDebut AND :anneeFin", CD.class);
        query.setParameter("anneeDebut", LocalDate.of(annee, 1, 1));
        query.setParameter("anneeFin", LocalDate.of(annee, 12, 31));
        return query.getResultList();
    }
}
