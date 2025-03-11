package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Emprunteur extends Utilisateur {

    @OneToMany(mappedBy = "emprunteur")
    private List<Amende> amendes;

    @OneToMany(mappedBy = "emprunteur")
    private List<Emprunt> emprunt;

    public Emprunteur(Long id, String nom,  String numeroTelephone, String email, String motDePasse) {
        super(id, nom, numeroTelephone, email, motDePasse);
    }

    @Override
    public String toString() {
        return  "ID : " + super.getId() + "\n" +
                "Nom : " + super.getNom() + "\n" +
                "Téléphone : " + super.getNumeroTelephone() + "\n" +
                "Email : " + super.getEmail() + "\n" +
                "Mot de passe : " + super.getMotDePasse();
    }
}
