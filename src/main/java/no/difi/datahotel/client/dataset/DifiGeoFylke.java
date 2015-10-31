package no.difi.datahotel.client.dataset;

import no.difi.datahotel.client.lang.Dataset;

@Dataset("difi/geo/fylke")
public class DifiGeoFylke {
    private String nummer, navn;

    public String getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return "DifiGeoFylke{" +
                "nummer='" + nummer + '\'' +
                ", navn='" + navn + '\'' +
                '}';
    }
}
