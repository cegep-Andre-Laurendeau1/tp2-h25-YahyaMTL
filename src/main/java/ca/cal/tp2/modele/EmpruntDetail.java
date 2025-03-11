package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class EmpruntDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn
    private Emprunt emprunt;

    private Date dateRetourPrevue;
    private Date dateRetourActuelle;
    private String status;
    private long documentId;
}
