package be.vdab;

import be.vdab.personeel.Geslacht;
import be.vdab.personeel.Werknemer;
import be.vdab.util.DatumException;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.math.BigDecimal;

public class WerknemerTest {
    static void main() {
        testWerknemer(
                1,
                "Jan Peeters",
                Geslacht.M,
                15, 3, 2020
        );

        testWerknemer(
                0,
                "Sarah Janssens",
                Geslacht.V,
                10, 5, 2021
        );

        testWerknemer(
                2,
                "",
                Geslacht.V,
                10, 5, 2021
        );

        testWerknemer(
                3,
                "Tom Claes",
                Geslacht.M,
                11, 2, 1977
        );
    }

    private static void testWerknemer(
            int personeelsnummer,
            String naam,
            Geslacht geslacht,
            int dag,
            int maand,
            int jaar) {

        try {
            var datumInDienst =
                    new WerknemersDatum(dag, maand, jaar);

            var werknemer =
                    new Werknemer(
                            personeelsnummer,
                            naam,
                            geslacht,
                            datumInDienst
                    ) {
                        @Override
                        public BigDecimal getVerloning() {
                            return BigDecimal.ZERO;
                        }
                    };

            IO.println("Geldig:");
            IO.println(werknemer);

        }
        catch (DatumException | WerknemerException ex) {
            IO.println("Fout: " + ex.getMessage());
        }
    }

}
