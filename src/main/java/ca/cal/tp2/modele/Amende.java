package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Amende {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "amende_id")
    private long id;
    private double montant;
    private LocalDate dateCreation;
    private boolean status;

    @ManyToOne
    @JoinColumn
    private Emprunteur emprunteur;
}