package be.vdab.personeel;

import java.math.BigDecimal;

import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

public class Bediende extends Werknemer {
    private BigDecimal maandwedde;

    public Bediende(int personeelsnummer,
                    String naam,
                    Geslacht geslacht,
                    WerknemersDatum datumInDienst,
                    BigDecimal maandwedde)
            throws WerknemerException {

        super(personeelsnummer, naam, geslacht, datumInDienst);
        setMaandwedde(maandwedde);
    }

    public BigDecimal getMaandwedde() {
        return maandwedde;
    }

    public void setMaandwedde(BigDecimal maandwedde)
            throws WerknemerException {

        if (maandwedde == null
            || maandwedde.compareTo(BigDecimal.valueOf(1129.47)) < 0) {
            throw new WerknemerException(
                    "De maandwedde moet minstens 1129,47 euro zijn."
            );
        }

        this.maandwedde = maandwedde;
    }

    @Override
    public BigDecimal getVerloning() {
        return maandwedde;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + maandwedde;
    }
}
