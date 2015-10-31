package no.difi.datahotel.client.dataset;

import no.difi.datahotel.client.lang.Dataset;

@Dataset("brreg/underenheter")
public class BrregUnderenheter {

    private String orgnr, navn, organisasjonsform, forretningsadr, forradrpostnr, forradrpoststed, forradrkommnr,
            forradrkommnavn, forradrland, postadresse, ppostnr, ppoststed, ppostland, nkode1, nkode2, nkode3, regiaa,
            hovedenhet, ansatte_antall, ansatte_dato;

    public String getOrgnr() {
        return orgnr;
    }

    public String getNavn() {
        return navn;
    }

    public String getOrganisasjonsform() {
        return organisasjonsform;
    }

    public String getForretningsadr() {
        return forretningsadr;
    }

    public String getForradrpostnr() {
        return forradrpostnr;
    }

    public String getForradrpoststed() {
        return forradrpoststed;
    }

    public String getForradrkommnr() {
        return forradrkommnr;
    }

    public String getForradrkommnavn() {
        return forradrkommnavn;
    }

    public String getForradrland() {
        return forradrland;
    }

    public String getPostadresse() {
        return postadresse;
    }

    public String getPpostnr() {
        return ppostnr;
    }

    public String getPpoststed() {
        return ppoststed;
    }

    public String getPpostland() {
        return ppostland;
    }

    public String getNkode1() {
        return nkode1;
    }

    public String getNkode2() {
        return nkode2;
    }

    public String getNkode3() {
        return nkode3;
    }

    public String getRegiaa() {
        return regiaa;
    }

    public String getHovedenhet() {
        return hovedenhet;
    }

    public String getAnsatte_antall() {
        return ansatte_antall;
    }

    public String getAnsatte_dato() {
        return ansatte_dato;
    }

    @Override
    public String toString() {
        return "BrregUnderenheter{" +
                "orgnr='" + orgnr + '\'' +
                ", navn='" + navn + '\'' +
                ", organisasjonsform='" + organisasjonsform + '\'' +
                ", forretningsadr='" + forretningsadr + '\'' +
                ", forradrpostnr='" + forradrpostnr + '\'' +
                ", forradrpoststed='" + forradrpoststed + '\'' +
                ", forradrkommnr='" + forradrkommnr + '\'' +
                ", forradrkommnavn='" + forradrkommnavn + '\'' +
                ", forradrland='" + forradrland + '\'' +
                ", postadresse='" + postadresse + '\'' +
                ", ppostnr='" + ppostnr + '\'' +
                ", ppoststed='" + ppoststed + '\'' +
                ", ppostland='" + ppostland + '\'' +
                ", nkode1='" + nkode1 + '\'' +
                ", nkode2='" + nkode2 + '\'' +
                ", nkode3='" + nkode3 + '\'' +
                ", regiaa='" + regiaa + '\'' +
                ", hovedenhet='" + hovedenhet + '\'' +
                ", ansatte_antall='" + ansatte_antall + '\'' +
                ", ansatte_dato='" + ansatte_dato + '\'' +
                '}';
    }
}
