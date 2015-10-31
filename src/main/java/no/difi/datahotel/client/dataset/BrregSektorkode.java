package no.difi.datahotel.client.dataset;

import no.difi.datahotel.client.lang.Dataset;

@Dataset("brreg/sektorkode")
public class BrregSektorkode {

    private String sektorkode_isek, sektorkode_isek_tekst, sektorkode_isek_tekst_engelsk;

    public String getSektorkode_isek() {
        return sektorkode_isek;
    }

    public void setSektorkode_isek(String sektorkode_isek) {
        this.sektorkode_isek = sektorkode_isek;
    }

    public String getSektorkode_isek_tekst() {
        return sektorkode_isek_tekst;
    }

    public void setSektorkode_isek_tekst(String sektorkode_isek_tekst) {
        this.sektorkode_isek_tekst = sektorkode_isek_tekst;
    }

    public String getSektorkode_isek_tekst_engelsk() {
        return sektorkode_isek_tekst_engelsk;
    }

    public void setSektorkode_isek_tekst_engelsk(String sektorkode_isek_tekst_engelsk) {
        this.sektorkode_isek_tekst_engelsk = sektorkode_isek_tekst_engelsk;
    }

    @Override
    public String toString() {
        return "BrregSektorkode{" +
                "sektorkode_isek='" + sektorkode_isek + '\'' +
                ", sektorkode_isek_tekst='" + sektorkode_isek_tekst + '\'' +
                ", sektorkode_isek_tekst_engelsk='" + sektorkode_isek_tekst_engelsk + '\'' +
                '}';
    }
}
