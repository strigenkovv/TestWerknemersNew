package be.vdab.personeel.kader;

import java.math.BigDecimal;

import be.vdab.personeel.Bediende;
import be.vdab.personeel.Geslacht;
import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

public class Kaderlid extends Bediende {

    private Functietitel functietitel;

    public Kaderlid(int personeelsnummer,
                    String naam,
                    Geslacht geslacht,
                    WerknemersDatum datumInDienst,
                    BigDecimal maandwedde,
                    Functietitel aFunctietitel)
            throws WerknemerException {

        super(personeelsnummer, naam, geslacht, datumInDienst, maandwedde);

        functietitel = aFunctietitel;
    }

    public Functietitel getFunctietitel() {
        return functietitel;
    }

    public void setFunctietitel(Functietitel aFunctietitel)
            throws WerknemerException {

        if (functietitel == null) {
            throw new WerknemerException(
                    "Functietitel is verplicht."
            );
        }

        functietitel = aFunctietitel;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + functietitel;
    }

}
