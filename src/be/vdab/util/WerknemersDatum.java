package be.vdab.util;

public class WerknemersDatum extends Datum {

    public WerknemersDatum(int dag, int maand, int jaar)
            throws DatumException {

        super(dag, maand, jaar);

        if (jaar < 1977
            || (jaar == 1977 && maand < 2)
            || (jaar == 1977 && maand == 2 && dag < 12)) {

            throw new DatumException(
                    "Werknemersdatum mag niet voor 12/02/1977 liggen."
            );
        }
    }
}
