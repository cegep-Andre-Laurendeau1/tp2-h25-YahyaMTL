package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_utilisateur")

public abstract class Utilisateur {

    @Id
    @Column(name = "utilisateur_id")
    private Long id;
    private String nom;
    private String numeroTelephone;
    private String email;
    private String motDePasse;
}
