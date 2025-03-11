package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
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

    @ManyToOne
    private Document document;

    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourActuelle;
    private String status;


    public EmpruntDetail(Document document, Date dateRetourPrevue) {
        this.document = document;
        this.dateRetourPrevue = LocalDate.now().plusWeeks(2);
    }
}
