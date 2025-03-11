package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class DVD extends Document {
    private String directeur;
    private int duree;
    private String rating;
    private Long tempsEmprunt;


    public DVD(Long id, String titre, int nombreExemplaires,
               String directeur, int duree, String rating, Long tempsEmprunt) {
        super();
        setId(id);
        setTitre(titre);
        setNbExemplaires(nombreExemplaires);
        this.directeur = directeur;
        this.duree = duree;
        this.rating = rating;
        this.tempsEmprunt = obtenirDateRetour();
    }

    public Long obtenirDateRetour() {
        /*  Retourne le nombre de semaines d'emprunt.
            Ici, vu que c'est un DVD, la durée est d'une semaine. */
        tempsEmprunt = 1L;
        return tempsEmprunt;
    }

    @Override
    public String toString() {
        return  "ID : " + super.getId() + "\n" +
                "Titre : " + super.getTitre() + "\n" +
                "Nombre d'exemplaires : " + super.getNbExemplaires() + "\n" +
                "Directeur : " + directeur + "\n" +
                "Durée : " + duree + " minutes" + "\n" +
                "Note : " + rating + "\n";
    }

}
