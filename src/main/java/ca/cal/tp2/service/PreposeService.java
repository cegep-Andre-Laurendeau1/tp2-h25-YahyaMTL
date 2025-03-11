package ca.cal.tp2.service;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import ca.cal.tp2.modele.Livre;
import ca.cal.tp2.repository.CDRepositoryJPA;
import ca.cal.tp2.repository.DVDRepositoryJPA;
import ca.cal.tp2.repository.LivreRepositoryJPA;

import java.util.List;

public class PreposeService {
    private final LivreRepositoryJPA livreRepository;
    private final CDRepositoryJPA cdRepository;
    private final DVDRepositoryJPA dvdRepository;

    public PreposeService (LivreRepositoryJPA livreRepository, CDRepositoryJPA cdRepository,
                           DVDRepositoryJPA dvdRepository) {
        this.livreRepository = livreRepository;
        this.cdRepository = cdRepository;
        this.dvdRepository = dvdRepository;
    }

    public void saveLivre (Long id, String titre, int nombreExemplaires, String numISBN,
                             String auteur, String editeur, int nbPages, Long tempsEmprunt) {
        livreRepository.save(new Livre(id, titre, nombreExemplaires, numISBN, auteur, editeur,
                            nbPages, tempsEmprunt));
    }

    public void saveCD (Long id, String titre, int nombreExemplaires,
                             String artiste, int duree, String genre, Long tempsEmprunt) {
        cdRepository.save(new CD(id, titre, nombreExemplaires, artiste, duree,
                                genre, tempsEmprunt));
    }

    public void saveDVD (Long id, String titre, int nombreExemplaires,
                             String directeur, int duree, String rating, Long tempsEmprunt) {
        dvdRepository.save(new DVD(id, titre, nombreExemplaires, directeur, duree, rating, tempsEmprunt));
    }


    public Livre getLivreById (Long id) {
        return livreRepository.findById(id);
    }

    public Livre getLivreByTitre (String titre) {
        return livreRepository.findByTitle(titre);
    }

    public Livre getLivreByAuthor (String auteur) {
        return livreRepository.findByAuthor(auteur);
    }

    public List<Livre> getLivreByYear (int annee) {
        return livreRepository.findByYear(annee);
    }

    public CD getCDById (Long id) {
        return cdRepository.findById(id);
    }

    public CD getCDByTitre (String titre) {
        return cdRepository.findByTitre(titre);
    }

    public CD getCDByArtist (String artiste) {
        return cdRepository.findByArtist(artiste);
    }

    public List<CD> getCDByYear (int annee) {
        return cdRepository.findByYear(annee);
    }

    public DVD getDVDById (Long id) {
        return dvdRepository.findById(id);
    }

    public DVD getDVDByTitre (String titre) {
        return dvdRepository.findByTitre(titre);
    }

    public DVD getDVDByArtist (String artiste) {
        return dvdRepository.findByDirector(artiste);
    }

    public List<DVD> getDVDByYear (int annee) {
        return dvdRepository.findByYear(annee);
    }

}
