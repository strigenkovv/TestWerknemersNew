package be.vdab;

import java.math.BigDecimal;

import be.vdab.personeel.Arbeider;
import be.vdab.personeel.Bediende;
import be.vdab.personeel.Geslacht;
import be.vdab.personeel.kader.Functietitel;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.DatumException;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

public class PersoneelTest {
    static void main() {
        try {
            var arbeider = new Arbeider(
                    1,
                    "Jan Peeters",
                    Geslacht.M,
                    new WerknemersDatum(15, 3, 2020),
                    BigDecimal.valueOf(15.50)
            );

            var bediende = new Bediende(
                    2,
                    "Sarah Janssens",
                    Geslacht.V,
                    new WerknemersDatum(10, 5, 2018),
                    BigDecimal.valueOf(2500)
            );

            var kaderlid = new Kaderlid(
                    3,
                    "Tom Claes",
                    Geslacht.M,
                    new WerknemersDatum(1, 9, 2015),
                    BigDecimal.valueOf(4500),
                    Functietitel.MANAGER
            );

            IO.println(arbeider);
            IO.println(bediende);
            IO.println(kaderlid);

        }
        catch (DatumException | WerknemerException ex) {
            IO.println("Fout: " + ex.getMessage());
        }
    }

}
