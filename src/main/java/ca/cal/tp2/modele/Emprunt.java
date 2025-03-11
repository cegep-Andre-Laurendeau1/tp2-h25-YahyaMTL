package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate dateEmprunt;
    private String status;

    @OneToMany(mappedBy = "empruntDetail", cascade = CascadeType.ALL)
    private List<EmpruntDetail> documents;

    @ManyToOne
    @JoinColumn
    private Emprunteur emprunteur;
}
