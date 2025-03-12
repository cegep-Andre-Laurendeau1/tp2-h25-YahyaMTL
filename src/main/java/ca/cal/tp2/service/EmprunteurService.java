package ca.cal.tp2.service;

import ca.cal.tp2.modele.Document;
import ca.cal.tp2.modele.Emprunt;
import ca.cal.tp2.modele.Emprunteur;
import ca.cal.tp2.repository.*;
import java.util.List;

public class EmprunteurService {
    private final EmprunteurRepositoryJPA emprunteurRepository;
    private final LivreRepositoryJPA livreRepository;
    private final CDRepositoryJPA cdRepository;
    private final DVDRepository dvdRepository;

    public EmprunteurService(EmprunteurRepositoryJPA emprunteurRepository,
                    LivreRepositoryJPA livreRepository, CDRepositoryJPA cdRepository, DVDRepository dvdRepository) {

        this.emprunteurRepository = emprunteurRepository;
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
    }

    public void saveEmprunteur(Long id, String nom,  String numeroTelephone, String email, String motDePasse) {
        emprunteurRepository.save(new Emprunteur(id, nom, numeroTelephone, email, motDePasse));
    }

   public Emprunteur getEmprunteur(Long id) {
        return emprunteurRepository.findById(id);
   }

   public List<Emprunt> getEmprunts(Long id) {
        return emprunteurRepository.listerEmprunts(id);
   }

    public void emprunt(Emprunteur emprunteur, Long id) {
        Document tempDoc = null;
        Document doc = null;

        if ((tempDoc = livreRepository.findById(id)) != null && tempDoc.obtenirDateRetour() == 3L) {
            doc = tempDoc;
        }
        else if ((tempDoc = cdRepository.findById(id)) != null && tempDoc.obtenirDateRetour() == 2L) {
            doc = tempDoc;
        }
        else if ((tempDoc = dvdRepository.findById(id)) != null && tempDoc.obtenirDateRetour() == 1L) {
            doc = tempDoc;
        }
        else {
            throw new RuntimeException("Il n'existe aucun document avec ces critères.");
        }

        Emprunt emprunt = new Emprunt();
        emprunt.setEmprunteur(emprunteur);
        emprunt.ajouterEmprunt(doc);
        emprunt.setStatus("En cours.");

        emprunteurRepository.empruntDocument(emprunteur, doc);
    }
}
