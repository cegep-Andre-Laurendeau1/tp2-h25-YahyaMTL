package ca.cal.tp2.service;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.EmpruntDetail;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.repository.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmprunteurService {
    private final EmprunteurRepositoryJPA emprunteurRepository;
    private final LivreRepositoryJPA livreRepository;
    private final CDRepositoryJPA cdRepository;
    private final DVDRepository dvdRepository;

    public EmprunteurService(EmprunteurRepositoryJPA emprunteurRepository, EmpruntRepositoryJPA empruntRepository,
                    LivreRepositoryJPA livreRepository, CDRepositoryJPA cdRepository, DVDRepository dvdRepository) {

        this.emprunteurRepository = emprunteurRepository;
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
    }

   public Emprunteur getEmprunteur(Long id) {
        return emprunteurRepository.findById(id);
   }

   public List<Emprunt> getEmprunts(Long id) {
        return emprunteurRepository.listerEmprunts(id);
   }

   public void emprunt (Emprunteur emprunteur, Long id) {
        Document doc = null;

        Document tempDoc = livreRepository.findById(id);
        if (tempDoc != null && tempDoc.obtenirDateRetour() == 3L) {
            doc = tempDoc;
        }

       tempDoc = cdRepository.findById(id);
       if (tempDoc != null && tempDoc.obtenirDateRetour() == 2L) {
            doc = tempDoc;        }

       tempDoc = dvdRepository.findById(id);
       if (tempDoc != null && tempDoc.obtenirDateRetour() == 1L) {
            doc = tempDoc;
        }
        if (doc == null) {
            throw new RuntimeException("Il n'existe aucun document avec ces critères.");
        }

        emprunteurRepository.empruntDocument(emprunteur, doc);
   }
}
