package ca.cal.tp2.repository;

import ca.cal.tp2.modele.DVD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class DVDRepositoryJPA implements DVDRepository {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2");

    public void save(DVD dvd) {
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(dvd);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public DVD findById(Long id) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<DVD> query = em.createNamedQuery("SELECT id FORM DVD" + "WHERE id = :id", DVD.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<DVD> findByYear (int annee) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<DVD> query = em.createNamedQuery("SELECT datePublication FROM DVD"
                + "WHERE datePublication BETWEEN :anneeDebut AND :anneeFin", DVD.class);
        query.setParameter("anneeDebut", LocalDate.of(annee, 1, 1));
        query.setParameter("anneeFin", LocalDate.of(annee, 12, 31));
        return query.getResultList();
    }

    public DVD findByDirector (String director) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<DVD> query = em.createNamedQuery("SELECT directeur FROM DVD" +
                " WHERE directeur.directeur = :director", DVD.class);
        query.setParameter("director", director);
        return query.getResultList().get(0);
    }

    public DVD findByTitre(String titre) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<DVD> query = em.createNamedQuery("SELECT titre FROM DVD" +
                " WHERE titre = :titre", DVD.class);
        query.setParameter("titre", titre);
        return query.getResultList().get(0);
    }
}
