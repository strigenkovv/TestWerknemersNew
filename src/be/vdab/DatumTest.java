package be.vdab;

import be.vdab.util.Datum;
import be.vdab.util.DatumException;

public class DatumTest {
    static void main() {
        testDatum(13, 5, 1997);
        testDatum(29, 2, 2000);
        testDatum(29, 2, 1900);
        testDatum(31, 4, 2024);
        testDatum(1, 1, 1584);
        testDatum(31, 12, 4099);
        testDatum(0, 5, 2024);
        testDatum(15, 13, 2024);
    }

    private static void testDatum(int dag, int maand, int jaar){
        try {
            var datum = new Datum(dag, maand, jaar);
            IO.println("Geldig  " + datum);
        }
        catch (DatumException ex){
            IO.println("Fout " + ex.getLocalizedMessage());
        }
    }
}
