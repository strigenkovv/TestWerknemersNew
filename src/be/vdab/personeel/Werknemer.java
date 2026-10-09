package be.vdab.personeel;


import be.vdab.util.WerknemerException;
import be.vdab.util.WerknemersDatum;

import java.util.Objects;
import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Werknemer implements Comparable<Werknemer>, Serializable {

    private static final long serialVersionUID = 1L;

    private final int personeelsnummer;
    private String naam;
    private Geslacht geslacht;
    private WerknemersDatum datumInDienst;

    public Werknemer(int personeelsnummer,
                     String naam,
                     Geslacht geslacht,
                     WerknemersDatum datumInDienst)
            throws WerknemerException {

        if (personeelsnummer <= 0) {
            throw new WerknemerException(
                    "Personeelsnummer moet groter zijn dan 0."
            );
        }

        if (naam == null || naam.isBlank()) {
            throw new WerknemerException(
                    "Naam is verplicht."
            );
        }

        if (geslacht == null) {
            throw new WerknemerException(
                    "Geslacht is verplicht."
            );
        }

        if (datumInDienst == null) {
            throw new WerknemerException(
                    "Datum in dienst is verplicht."
            );
        }

        this.personeelsnummer = personeelsnummer;
        this.naam = naam;
        this.geslacht = geslacht;
        this.datumInDienst = datumInDienst;
    }

    public int getPersoneelsnummer() {
        return personeelsnummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) throws WerknemerException {
        if (naam == null || naam.isBlank()) {
            throw new WerknemerException("Naam is verplicht.");
        }
        this.naam = naam;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht)
            throws WerknemerException {
        if (geslacht == null) {
            throw new WerknemerException("Geslacht is verplicht.");
        }
        this.geslacht = geslacht;
    }

    public WerknemersDatum getDatumInDienst() {
        return datumInDienst;
    }

    public void setDatumInDienst(WerknemersDatum datumInDienst)
            throws WerknemerException {
        if (datumInDienst == null) {
            throw new WerknemerException(
                    "Datum in dienst is verplicht."
            );
        }
        this.datumInDienst = datumInDienst;
    }

    public abstract BigDecimal getVerloning();

    @Override
    public int compareTo(Werknemer andere) {
        return Integer.compare(
                personeelsnummer,
                andere.personeelsnummer
        );
    }

    @Override
    public String toString() {
        return personeelsnummer + "\t"
               + datumInDienst + "\t"
               + naam + "\t"
               + geslacht + "\t"
               + getVerloning();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Werknemer werknemer)) {
            return false;
        }

        return personeelsnummer == werknemer.personeelsnummer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personeelsnummer);
    }
}
