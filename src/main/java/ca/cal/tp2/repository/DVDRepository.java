package ca.cal.tp2.repository;

import ca.cal.tp2.modele.DVD;

import java.util.List;

public interface DVDRepository {
    void save (DVD dvd);
    DVD findById(long id);
    List<DVD> findByYear(int annee);
    DVD findByTitle(String titre);
    DVD findByDirector(String directeur);
}
