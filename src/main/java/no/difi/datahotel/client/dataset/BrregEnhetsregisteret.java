package no.difi.datahotel.client.dataset;

import no.difi.datahotel.client.lang.Dataset;

@Dataset("brreg/enhetsregisteret")
public class BrregEnhetsregisteret {

    private String orgnr, navn, organisasjonsform, forretningsadr, forradrpostnr, forradrpoststed, forradrkommnr,
            forradrkommnavn, forradrland, postadresse, ppostnr, ppoststed, ppostland, regifr, regimva, nkode1, nkode2,
            nkode3, sektorkode, konkurs, avvikling, tvangsavvikling, regiaa, regifriv, regdato, stiftelsesdato, tlf,
            tlf_mobil, url, regnskap, hovedenhet, ansatte_antall, ansatte_dato;

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

    public String getRegifr() {
        return regifr;
    }

    public String getRegimva() {
        return regimva;
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

    public String getSektorkode() {
        return sektorkode;
    }

    public String getKonkurs() {
        return konkurs;
    }

    public String getAvvikling() {
        return avvikling;
    }

    public String getTvangsavvikling() {
        return tvangsavvikling;
    }

    public String getRegiaa() {
        return regiaa;
    }

    public String getRegifriv() {
        return regifriv;
    }

    public String getRegdato() {
        return regdato;
    }

    public String getStiftelsesdato() {
        return stiftelsesdato;
    }

    public String getTlf() {
        return tlf;
    }

    public String getTlf_mobil() {
        return tlf_mobil;
    }

    public String getUrl() {
        return url;
    }

    public String getRegnskap() {
        return regnskap;
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
        return "BrregEnhetsregisteret{" +
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
                ", regifr='" + regifr + '\'' +
                ", regimva='" + regimva + '\'' +
                ", nkode1='" + nkode1 + '\'' +
                ", nkode2='" + nkode2 + '\'' +
                ", nkode3='" + nkode3 + '\'' +
                ", sektorkode='" + sektorkode + '\'' +
                ", konkurs='" + konkurs + '\'' +
                ", avvikling='" + avvikling + '\'' +
                ", tvangsavvikling='" + tvangsavvikling + '\'' +
                ", regiaa='" + regiaa + '\'' +
                ", regifriv='" + regifriv + '\'' +
                ", regdato='" + regdato + '\'' +
                ", stiftelsesdato='" + stiftelsesdato + '\'' +
                ", tlf='" + tlf + '\'' +
                ", tlf_mobil='" + tlf_mobil + '\'' +
                ", url='" + url + '\'' +
                ", regnskap='" + regnskap + '\'' +
                ", hovedenhet='" + hovedenhet + '\'' +
                ", ansatte_antall='" + ansatte_antall + '\'' +
                ", ansatte_dato='" + ansatte_dato + '\'' +
                '}';
    }
}
