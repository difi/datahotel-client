package no.difi.datahotel.client.dataset;

import no.difi.datahotel.client.lang.Dataset;

@Dataset("difi/geo/fylke")
public class DifiGeoFylke {
    private String nummer, navn;

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public String toString() {
        return "DifiGeoFylke{" +
                "nummer='" + nummer + '\'' +
                ", navn='" + navn + '\'' +
                '}';
    }
}
