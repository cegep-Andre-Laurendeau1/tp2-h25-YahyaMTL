package ca.cal.tp2.repository;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class LivreRepositoryJPA implements LivreRepository {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");

    public void save(Livre livre) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(livre);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Livre findById(Long id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l WHERE l.id = :id", Livre.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Livre> findByYear(int annee) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l WHERE l.datePublication " +
                                                    "BETWEEN :anneeDebut AND :anneeFin", Livre.class);
        query.setParameter("anneeDebut", LocalDate.of(annee, 1, 1));
        query.setParameter("anneeFin", LocalDate.of(annee, 12, 31));
        return query.getResultList();
    }

    public Livre findByTitle(String titre) {
        EntityManager em = emf.createEntityManager();
        TypedQuery <Livre> query = em.createQuery("SELECT l FROM Livre l WHERE l.titre LIKE :titre", Livre.class);
        query.setParameter("titre", "%" + titre + "%");
        return query.getSingleResult();
    }

    public Livre findByAuthor(String auteur) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l WHERE l.auteur = :auteur", Livre.class);
        query.setParameter("auteur", auteur);
        return query.getSingleResult();
    }
}
