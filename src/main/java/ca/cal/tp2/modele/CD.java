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

    public CD(long id, String titre, int nombreExemplaires,
              String artiste, int duree, String genre) {
        super();
        setId(id);
        setTitre(titre);
        setNbExemplaires(nombreExemplaires);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }
}
