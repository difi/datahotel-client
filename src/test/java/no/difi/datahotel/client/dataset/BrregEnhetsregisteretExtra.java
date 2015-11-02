package no.difi.datahotel.client.dataset;

import no.difi.datahotel.client.lang.Dataset;

/**
 * This is a partial class to show the concept of using a raw object as source for more advanced logic.
 */
@Dataset(value = "brreg/enhetsregisteret", raw = BrregEnhetsregisteret.class)
public class BrregEnhetsregisteretExtra {

    private BrregEnhetsregisteret source;

    public BrregEnhetsregisteretExtra(BrregEnhetsregisteret source) {
        this.source = source;
    }

    public String getIdentifier() {
        return source.getOrgnr();
    }

    public String getName() {
        return source.getNavn();
    }

    public boolean isVat() {
        return "J".equals(source.getRegimva());
    }

    public Address getPostalAddress() {
        return new Address(source.getPostadresse(), source.getPpoststed(), source.getPpoststed(), source.getPpostland());
    }

    public static class Address {
        private String address1;
        private String postalCode;
        private String postalCity;
        private String country;

        public Address(String address1, String postalCode, String postalCity, String country) {
            this.address1 = address1;
            this.postalCode = postalCode;
            this.postalCity = postalCity;
            this.country = country;
        }

        public String getAddress1() {
            return address1;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public String getPostalCity() {
            return postalCity;
        }

        public String getCountry() {
            return country;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "address1='" + address1 + '\'' +
                    ", postalCode='" + postalCode + '\'' +
                    ", postalCity='" + postalCity + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }
}
