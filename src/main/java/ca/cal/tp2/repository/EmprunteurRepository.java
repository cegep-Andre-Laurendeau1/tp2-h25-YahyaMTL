package ca.cal.tp2.repository;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Emprunteur;

import java.util.List;

public interface EmprunteurRepository {
    void save(Emprunteur emprunteur);
    Emprunteur findById(Long id);
    void empruntDocument(Emprunteur emprunteur, Document document);
    List<Emprunt> listerEmprunts(Long id);
}
