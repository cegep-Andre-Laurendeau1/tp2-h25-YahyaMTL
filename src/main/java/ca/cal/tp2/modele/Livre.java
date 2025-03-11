package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Livre extends Document {
    private String numISBN;
    private String auteur;
    private String editeur;
    private int nbPages;
    private Long tempsEmprunt;


    public Livre(Long id, String titre, int nombreExemplaires,
                 String numISBN, String auteur, String editeur, int nbPages, Long tempsEmprunt) {
        super();
        setId(id);
        setTitre(titre);
        setNbExemplaires(nombreExemplaires);
        this.numISBN = numISBN;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nbPages = nbPages;
        this.tempsEmprunt = obtenirDateRetour();
    }

    public Long obtenirDateRetour() {
        /*  Retourne le nombre de semaines d'emprunt.
            Ici, vu que c'est un livre, la durée est de trois semaines. */
        tempsEmprunt = 3L;
        return tempsEmprunt;
    }
}
