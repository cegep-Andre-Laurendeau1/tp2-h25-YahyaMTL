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
    private int tempsEmprunt;


    public DVD(long id, String titre, int nombreExemplaires,
               String directeur, int duree, String rating, int tempsEmprunt) {
        super();
        setId(id);
        setTitre(titre);
        setNbExemplaires(nombreExemplaires);
        this.directeur = directeur;
        this.duree = duree;
        this.rating = rating;
        this.tempsEmprunt = tempsEmprunt;
    }

}
