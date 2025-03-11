package ca.cal.tp2.repository;

import ca.cal.tp2.modele.CD;

import java.time.LocalDate;
import java.util.List;

public interface CDRepository {
    void save(CD cd);
    CD findById(long id);
    List<CD> findByYear(int annee);
    CD findByTitle(String titre);
    CD findByArtist(String artiste);
}
