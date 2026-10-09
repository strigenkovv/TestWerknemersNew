package be.vdab.personeel;

import java.math.BigDecimal;
import java.math.RoundingMode;

import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

public class Arbeider extends Werknemer {
    private BigDecimal uurloon;

    public Arbeider(int personeelsnummer,
                    String naam,
                    Geslacht geslacht,
                    WerknemersDatum datumInDienst,
                    BigDecimal uurloon) throws WerknemerException {
        super(personeelsnummer, naam, geslacht, datumInDienst);

        setUurloon(uurloon);
    }


    public BigDecimal getUurloon() {
        return uurloon;
    }

    public void setUurloon(BigDecimal aUurloon) throws WerknemerException {

        if (aUurloon == null
            || aUurloon.compareTo(BigDecimal.valueOf(9.76)) < 0) {
            throw new WerknemerException(
                    "Het uurloon moet minstens 9,76 euro zijn."
            );
        }

        uurloon = aUurloon;
    }

    @Override
    public BigDecimal getVerloning() {
        return uurloon.multiply(BigDecimal.valueOf(7.6))
                      .multiply(BigDecimal.valueOf(65))
                      .divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + uurloon;
    }
}
