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
        TypedQuery<DVD> query = em.createQuery("SELECT d FROM DVD d WHERE d.id = :id", DVD.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<DVD> findByYear (int annee) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<DVD> query = em.createQuery("SELECT d FROM DVD d "
                + "WHERE d.datePublication BETWEEN :anneeDebut AND :anneeFin", DVD.class);
        query.setParameter("anneeDebut", LocalDate.of(annee, 1, 1));
        query.setParameter("anneeFin", LocalDate.of(annee, 12, 31));
        return query.getResultList();
    }

    public DVD findByDirector (String directeur) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<DVD> query = em.createQuery("SELECT d FROM DVD d " +
                "WHERE d.directeur = :directeur", DVD.class);
        query.setParameter("directeur", directeur);
        return query.getSingleResult();
    }

    public DVD findByTitre(String titre) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<DVD> query = em.createQuery("SELECT d FROM DVD d WHERE d.titre LIKE :titre", DVD.class);
        query.setParameter("titre", "%" + titre + "%");
        return query.getSingleResult();
    }
}
