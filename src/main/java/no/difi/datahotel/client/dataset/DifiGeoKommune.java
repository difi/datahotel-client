package no.difi.datahotel.client.dataset;

import no.difi.datahotel.client.lang.Dataset;

@Dataset("difi/geo/kommune")
public class DifiGeoKommune {

    private String fylke;
    private String navn;
    private String kommune;

    public String getFylke() {
        return fylke;
    }

    public void setFylke(String fylke) {
        this.fylke = fylke;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getKommune() {
        return kommune;
    }

    public void setKommune(String kommune) {
        this.kommune = kommune;
    }

    @Override
    public String toString() {
        return "DifiGeoKommune{" +
                "fylke='" + fylke + '\'' +
                ", navn='" + navn + '\'' +
                ", kommune='" + kommune + '\'' +
                '}';
    }
}
