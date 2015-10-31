package no.difi.datahotel.client.dataset;

import no.difi.datahotel.client.lang.Dataset;

@Dataset("brreg/naeringskode")
public class BrregNaeringskode {

    private String naerk, naerk_tekst, naerk_tekst_engelsk;

    public String getNaerk() {
        return naerk;
    }

    public void setNaerk(String naerk) {
        this.naerk = naerk;
    }

    public String getNaerk_tekst() {
        return naerk_tekst;
    }

    public void setNaerk_tekst(String naerk_tekst) {
        this.naerk_tekst = naerk_tekst;
    }

    public String getNaerk_tekst_engelsk() {
        return naerk_tekst_engelsk;
    }

    public void setNaerk_tekst_engelsk(String naerk_tekst_engelsk) {
        this.naerk_tekst_engelsk = naerk_tekst_engelsk;
    }

    @Override
    public String toString() {
        return "BrregNaeringskode{" +
                "naerk='" + naerk + '\'' +
                ", naerk_tekst='" + naerk_tekst + '\'' +
                ", naerk_tekst_engelsk='" + naerk_tekst_engelsk + '\'' +
                '}';
    }
}
