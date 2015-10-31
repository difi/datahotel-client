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

    public void setOrgnr(String orgnr) {
        this.orgnr = orgnr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getOrganisasjonsform() {
        return organisasjonsform;
    }

    public void setOrganisasjonsform(String organisasjonsform) {
        this.organisasjonsform = organisasjonsform;
    }

    public String getForretningsadr() {
        return forretningsadr;
    }

    public void setForretningsadr(String forretningsadr) {
        this.forretningsadr = forretningsadr;
    }

    public String getForradrpostnr() {
        return forradrpostnr;
    }

    public void setForradrpostnr(String forradrpostnr) {
        this.forradrpostnr = forradrpostnr;
    }

    public String getForradrpoststed() {
        return forradrpoststed;
    }

    public void setForradrpoststed(String forradrpoststed) {
        this.forradrpoststed = forradrpoststed;
    }

    public String getForradrkommnr() {
        return forradrkommnr;
    }

    public void setForradrkommnr(String forradrkommnr) {
        this.forradrkommnr = forradrkommnr;
    }

    public String getForradrkommnavn() {
        return forradrkommnavn;
    }

    public void setForradrkommnavn(String forradrkommnavn) {
        this.forradrkommnavn = forradrkommnavn;
    }

    public String getForradrland() {
        return forradrland;
    }

    public void setForradrland(String forradrland) {
        this.forradrland = forradrland;
    }

    public String getPostadresse() {
        return postadresse;
    }

    public void setPostadresse(String postadresse) {
        this.postadresse = postadresse;
    }

    public String getPpostnr() {
        return ppostnr;
    }

    public void setPpostnr(String ppostnr) {
        this.ppostnr = ppostnr;
    }

    public String getPpoststed() {
        return ppoststed;
    }

    public void setPpoststed(String ppoststed) {
        this.ppoststed = ppoststed;
    }

    public String getPpostland() {
        return ppostland;
    }

    public void setPpostland(String ppostland) {
        this.ppostland = ppostland;
    }

    public String getNkode1() {
        return nkode1;
    }

    public void setNkode1(String nkode1) {
        this.nkode1 = nkode1;
    }

    public String getNkode2() {
        return nkode2;
    }

    public void setNkode2(String nkode2) {
        this.nkode2 = nkode2;
    }

    public String getNkode3() {
        return nkode3;
    }

    public void setNkode3(String nkode3) {
        this.nkode3 = nkode3;
    }

    public String getRegiaa() {
        return regiaa;
    }

    public void setRegiaa(String regiaa) {
        this.regiaa = regiaa;
    }

    public String getHovedenhet() {
        return hovedenhet;
    }

    public void setHovedenhet(String hovedenhet) {
        this.hovedenhet = hovedenhet;
    }

    public String getAnsatte_antall() {
        return ansatte_antall;
    }

    public void setAnsatte_antall(String ansatte_antall) {
        this.ansatte_antall = ansatte_antall;
    }

    public String getAnsatte_dato() {
        return ansatte_dato;
    }

    public void setAnsatte_dato(String ansatte_dato) {
        this.ansatte_dato = ansatte_dato;
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
