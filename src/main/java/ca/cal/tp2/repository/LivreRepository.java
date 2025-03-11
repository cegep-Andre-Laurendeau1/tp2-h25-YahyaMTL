package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Livre;

import java.util.List;

public interface LivreRepository {
    void save(Livre livre);
    Livre findById(long id);
    List<Livre> findByYear(int annee);
    Livre findByTitle(String titre);
    Livre findByAuthor(String auteur);
}
