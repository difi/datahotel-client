package no.difi.datahotel.client;

import no.difi.datahotel.client.fetcher.ApacheFetcher;
import no.difi.datahotel.client.lang.Dataset;
import no.difi.datahotel.client.lang.Fetcher;

public class DatahotelBuilder<T> {

    public static <T> DatahotelBuilder<T> create(Class<T> cls) {
        if (!cls.isAnnotationPresent(Dataset.class))
            throw new IllegalStateException(String.format("Class %s must have Dataset annotation.", cls));

        return create(cls, cls.getAnnotation(Dataset.class).value());
    }

    public static <T> DatahotelBuilder<T> create(Class<T> cls, String location) {
        return new DatahotelBuilder<T>(cls, location);
    }

    private Class<T> cls;
    private String location;

    private Fetcher fetcher;
    private String source;

    DatahotelBuilder(Class<T> cls, String location) {
        this.cls = cls;
        this.location = location;
    }

    public DatahotelBuilder<T> fetcher(Fetcher fetcher) {
        this.fetcher = fetcher;
        return this;
    }

    public DatahotelBuilder<T> source(String source) {
        this.source = source;
        return this;
    }

    public Datahotel<T> build() {
        if (fetcher == null)
            fetcher(new ApacheFetcher());
        if (source == null)
            source("https://hotell.difi.no/");

        return new Datahotel<T>(fetcher, cls, source, location);
    }
}
