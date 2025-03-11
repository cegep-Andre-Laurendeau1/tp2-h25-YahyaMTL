package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public abstract class Document {
    @Id
    @Column(name = "document_id")
    private Long id;
    private String titre;
    private int nbExemplaires;
    private LocalDate datePublication;

    public boolean estDisponible() {
        return nbExemplaires > 0;
    }

    public void emprunterDocument() {
        this.nbExemplaires--;
    }

    public abstract Long obtenirDateRetour();
}