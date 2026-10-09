package be.vdab;

import be.vdab.personeel.Arbeider;
import be.vdab.personeel.Bediende;
import be.vdab.personeel.Bedrijf;
import be.vdab.personeel.Geslacht;
import be.vdab.personeel.kader.Functietitel;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.DatumException;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;
import java.io.IOException;

public class BedrijfApp {

    public static void main(String[] args) {

        var bedrijf = new Bedrijf();

        try {
            var arbeider1 = new Arbeider(
                    1,
                    "Jan Stryshenko",
                    Geslacht.M,
                    new WerknemersDatum(15, 3, 2020),
                    BigDecimal.valueOf(18.5)
            );

            var arbeider2 = new Arbeider(
                    2,
                    "Tom Jacobs",
                    Geslacht.M,
                    new WerknemersDatum(10, 6, 2019),
                    BigDecimal.valueOf(18.25)
            );

            var bediende1 = new Bediende(
                    3,
                    "Florence Janssens",
                    Geslacht.V,
                    new WerknemersDatum(1, 5, 2018),
                    BigDecimal.valueOf(2500)
            );

            var bediende2 = new Bediende(
                    4,
                    "Anna Maes",
                    Geslacht.V,
                    new WerknemersDatum(12, 2, 2005),
                    BigDecimal.valueOf(3000)
            );

            var kaderlid1 = new Kaderlid(
                    5,
                    "Peter Janssens",
                    Geslacht.M,
                    new WerknemersDatum(3, 9, 2010),
                    BigDecimal.valueOf(4500),
                    Functietitel.MANAGER
            );

            var kaderlid2 = new Kaderlid(
                    6,
                    "Elisa Vermeulen",
                    Geslacht.V,
                    new WerknemersDatum(8, 4, 2012),
                    BigDecimal.valueOf(6000),
                    Functietitel.DIRECTEUR
            );

            bedrijf.voegWerknemerToe(arbeider1);
            bedrijf.voegWerknemerToe(arbeider2);
            bedrijf.voegWerknemerToe(bediende1);
            bedrijf.voegWerknemerToe(bediende2);
            bedrijf.voegWerknemerToe(kaderlid1);
            bedrijf.voegWerknemerToe(kaderlid2);

            // dezelfde werknemer nog eens:
            bedrijf.voegWerknemerToe(arbeider1);

            IO.println("Alle werknemers:");
            bedrijf.printLijst(bedrijf.getBedrijfslijst());

            IO.println("\nGesorteerde lijst:");
            bedrijf.printLijst(bedrijf.gesorteerdeLijst());

            IO.println("\nAlle arbeiders:");
            bedrijf.printLijst(bedrijf.lijstVanArbeiders());

            IO.println("\nPercentage mannen:");
            IO.println(bedrijf.percentageMannelijkeWerknemers() + "%");

            bedrijf.bewaarLijst();
            IO.println("De lijst is bewaard in personeel.dat.");

        }
        catch (DatumException | WerknemerException | IOException ex) {
            IO.println("Fout: " + ex.getMessage());
        }

        // Foute werknemers testen
        try {
            var fout = new Arbeider(
                    7,
                    "Foute arbeider",
                    Geslacht.M,
                    new WerknemersDatum(10, 5, 2020),
                    BigDecimal.valueOf(5)
            );

            bedrijf.voegWerknemerToe(fout);

        }
        catch (DatumException | WerknemerException ex) {
            IO.println("\nVerwachte fout: " + ex.getMessage());
        }

        try {
            var fout = new Bediende(
                    8,
                    "",
                    Geslacht.V,
                    new WerknemersDatum(10, 5, 2020),
                    BigDecimal.valueOf(2000)
            );

            bedrijf.voegWerknemerToe(fout);

        }
        catch (DatumException | WerknemerException ex) {
            IO.println("Verwachte fout: " + ex.getMessage());
        }

        try {
            var fout = new Kaderlid(
                    9,
                    "Test",
                    Geslacht.M,
                    new WerknemersDatum(1, 1, 1970),
                    BigDecimal.valueOf(4000),
                    Functietitel.CEO
            );

            bedrijf.voegWerknemerToe(fout);

        }
        catch (DatumException | WerknemerException ex) {
            IO.println("Verwachte fout: " + ex.getMessage());
        }
    }
}

