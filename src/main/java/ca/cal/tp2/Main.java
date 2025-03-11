package ca.cal.tp2;

import ca.cal.tp2.repository.*;
import ca.cal.tp2.service.EmprunteurService;
import ca.cal.tp2.service.PreposeService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, InterruptedException {
        TcpServer.startTcpServer();

        PreposeService preposeService = new PreposeService(
                new LivreRepositoryJPA(),
                new CDRepositoryJPA(),
                new DVDRepositoryJPA());

        EmprunteurService emprunteurService = new EmprunteurService (
                new EmprunteurRepositoryJPA(),
                new LivreRepositoryJPA(),
                new CDRepositoryJPA(),
                new DVDRepositoryJPA());

        preposeService.saveLivre(1L, "Garfield #10", 4, "2895432295",
                "Jim Davis", "Presses Aventure", 96, 3L);

        preposeService.saveCD(1L, "Thriller", 3,
                "Michael Jackson", 42, "Pop", 2L);

        preposeService.saveDVD(1L, "Pokémon The Movie : 2000", 2,
                "Kunihiko Yuyama", 102, "Excellent", 1L);

        System.out.println(preposeService.getLivreById(1L));
        System.out.println(preposeService.getLivreByAuthor("Jim Davis"));
        System.out.println(preposeService.getLivreByTitre("Garfield"));

        System.out.println(preposeService.getCDById(1L));
        System.out.println(preposeService.getCDByTitre("Thril"));
        System.out.println(preposeService.getCDByArtist("Michael Jackson"));

        System.out.println(preposeService.getDVDById(1L));
        System.out.println(preposeService.getDVDByTitre("ok"));
        System.out.println(preposeService.getDVDByDirector("Kunihiko Yuyama"));

        emprunteurService.saveEmprunteur(1L, "Osman", "514-415-1414", "cal@cal.com", "Djibouti25");
        System.out.println(emprunteurService.getEmprunteur(1L));


        emprunteurService.emprunt(emprunteurService.getEmprunteur(1L), 1L);

        // Petit bug ici.
        System.out.println(emprunteurService.getEmprunts(1L));

        Thread.currentThread().join();
    }
}
