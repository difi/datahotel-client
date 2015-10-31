package no.difi.datahotel.client;

import no.difi.datahotel.client.fetcher.ApacheFetcher;
import no.difi.datahotel.client.lang.Dataset;
import no.difi.datahotel.client.lang.Fetcher;

public class DatahotelBuilder {

    public static DatahotelBuilder create(Class<?> cls) {
        if (!cls.isAnnotationPresent(Dataset.class))
            throw new IllegalStateException(String.format("Class %s must have Dataset annotation.", cls));

        return create(cls, cls.getAnnotation(Dataset.class).value());
    }

    public static DatahotelBuilder create(Class<?> cls, String location) {
        return new DatahotelBuilder(cls, location);
    }

    private Class cls;
    private String location;

    private Fetcher fetcher;
    private String source;

    DatahotelBuilder(Class<?> cls, String location) {
        this.cls = cls;
        this.location = location;
    }

    public DatahotelBuilder fetcher(Fetcher fetcher) {
        this.fetcher = fetcher;
        return this;
    }

    public DatahotelBuilder source(String source) {
        this.source = source;
        return this;
    }

    public Datahotel build() {
        if (fetcher == null)
            fetcher(new ApacheFetcher());
        if (source == null)
            source("https://hotell.difi.no/");

        return new Datahotel(fetcher, cls, source, location);
    }
}
