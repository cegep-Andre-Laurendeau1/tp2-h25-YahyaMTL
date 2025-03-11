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

    public Livre(long id, String titre, int nombreExemplaires,
                 String numISBN, String auteur, String editeur, int nbPages) {
        super();
        setId(id);
        setTitre(titre);
        setNbExemplaires(nombreExemplaires);
        this.numISBN = numISBN;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nbPages = nbPages;
    }
}
