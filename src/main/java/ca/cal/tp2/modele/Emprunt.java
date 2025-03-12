package ca.cal.tp2.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
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

    @OneToMany(mappedBy = "emprunt", cascade = CascadeType.MERGE)
    private List<EmpruntDetail> documents = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private Emprunteur emprunteur;

    public void ajouterEmprunt(Document document) {
        if (this.documents == null) {
            this.documents = new ArrayList<>();
        }

        this.dateEmprunt = LocalDate.now();
        EmpruntDetail empruntDetail = new EmpruntDetail(document, LocalDate.now().plusWeeks(document.obtenirDateRetour()));
        empruntDetail.setEmprunt(this);
        empruntDetail.setDocument(document);

        this.documents.add(empruntDetail);
    }

    @Override
    public String toString() {
        return "ID de l'emprunteur : " + id + "\n" +
                "Date d'emprunt : " + dateEmprunt + "\n" +
                "Status : " + status + "\n" +
                "Emprunteur : " + emprunteur.getNom() + "\n" +
                "Documents empruntés : " +  documents.size() + "\n";
    }
}
