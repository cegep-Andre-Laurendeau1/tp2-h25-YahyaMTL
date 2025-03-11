package ca.cal.tp2.repository;

import ca.cal.tp2.modele.CD;

import java.util.List;

public interface CDRepository {
    void save(CD cd);
    CD findById(Long id);
    List<CD> findByYear(int annee);
    CD findByTitre(String titre);
    CD findByArtist(String artiste);
}
