package be.vdab.util;

import java.util.Objects;
import java.io.Serializable;

public class Datum implements IDatum, Comparable<Datum>, Serializable {

    private static final long serialVersionUID = 1L;

    private final int dag;
    private final int maand;
    private final int jaar;

    public Datum(int dag, int maand, int jaar) throws DatumException {
        if (jaar < 1584 || jaar > 4099) {
            throw new DatumException("Ongeldig jaar");
        }

        if (maand < 1 || maand > 12){
            throw new DatumException("Ongeldig maand");
        }

        int aantalDagen = getAantalDagenInMaand(maand, jaar);

        if (dag < 1 || dag > aantalDagen){
            throw new DatumException("Ongeldig dag");
        }

        this.dag = dag;
        this.maand = maand;
        this.jaar = jaar;
    }

    @Override
    public int getDag() {
        return dag;
    }

    @Override
    public int getMaand() {
        return maand;
    }

    @Override
    public int getJaar() {
        return jaar;
    }

    @Override
    public int compareTo(Datum andereData) {
        int resultaat = Integer.compare(jaar, andereData.jaar);

        if (resultaat == 0) {
            resultaat = Integer.compare(maand, andereData.maand);
        }

        if (resultaat == 0) {
            Integer.compare(dag, andereData.dag);
        }
        return resultaat;
    }

    private boolean isSchrikkeljaar(int jaar) {
        return jaar % 400 == 0
                || (jaar % 4 == 0 && jaar % 100 != 0);
    }

    private int getAantalDagenInMaand(int maand, int jaar) {
        return switch (maand) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isSchrikkeljaar(jaar) ? 29 : 28;
            default -> 0;
        };
    }

    @Override
    public String toString(){
        return "%02d/%02d/%04d".formatted(dag, maand, jaar);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Datum datum)) {
            return false;
        }

        return dag == datum.dag
               && maand == datum.maand
               && jaar == datum.jaar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dag, maand, jaar);
    }
}
