package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CD extends Document {
    private String artiste;
    private int duree;
    private String genre;
    private Long tempsEmprunt;


    public CD(Long id, String titre, int nombreExemplaires,
              String artiste, int duree, String genre, Long tempsEmprunt) {
        super();
        setId(id);
        setTitre(titre);
        setNbExemplaires(nombreExemplaires);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
        this.tempsEmprunt = obtenirDateRetour();
    }

    public Long obtenirDateRetour() {
        /*  Retourne le nombre de semaines d'emprunt.
            Ici, vu que c'est un CD, la durée est de deux semaines. */
        tempsEmprunt = 2L;
        return tempsEmprunt;
    }

    @Override
    public String toString() {
        return  "ID : " + super.getId() + "\n" +
                "Titre : " + super.getTitre() + "\n" +
                "Nombre d'exemplaires : " + super.getNbExemplaires() + "\n" +
                "Artiste : " + artiste + "\n" +
                "Durée : " + duree + " minutes" + "\n" +
                "Nombre de pages : " + genre + "\n";
    }
}
