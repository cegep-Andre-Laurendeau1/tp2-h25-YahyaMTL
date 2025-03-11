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
public class EmpruntDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Emprunt emprunt;

    @ManyToOne
    private Document document;

    private LocalDate dateRetourPrevue;
    private LocalDate dateRetourActuelle;
    private String status;


    public EmpruntDetail(Document document, LocalDate dateRetourPrevue) {
        this.document = document;
        this.dateRetourPrevue = LocalDate.now().plusWeeks(document.obtenirDateRetour());
    }

    @Override
    public String toString() {
        return
                "Document(s) emprunté(s) : " + document.getTitre() + "\n" +
                "Status : " + status + "\n" +
                "Date de retour : " + dateRetourPrevue + "\n";
    }
}
