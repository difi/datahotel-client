package no.difi.datahotel.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.difi.datahotel.client.fetcher.ApacheFetcher;
import no.difi.datahotel.client.lang.Dataset;
import no.difi.datahotel.client.lang.Fetcher;

public class DatahotelBuilder<T> {

    private static ObjectMapper defaultMapper;

    public static <T> DatahotelBuilder<T> create(Class<T> cls) {
        if (!cls.isAnnotationPresent(Dataset.class))
            throw new IllegalStateException(String.format("Class %s must have Dataset annotation.", cls));

        DatahotelBuilder<T> builder = create(cls, cls.getAnnotation(Dataset.class).value());

        if (cls.getAnnotation(Dataset.class).raw() != void.class)
            builder.raw(cls.getAnnotation(Dataset.class).raw());

        return builder;
    }

    public static <T> DatahotelBuilder<T> create(Class<T> cls, String location) {
        return new DatahotelBuilder<T>(cls, location);
    }

    private static synchronized ObjectMapper getDefaultMapper() {
        if (defaultMapper == null)
            defaultMapper = new ObjectMapper()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        return defaultMapper;
    }

    private Class<T> cls;
    private Class<?> raw;
    private String location;

    private Fetcher fetcher;
    private ObjectMapper mapper;
    private String source;

    DatahotelBuilder(Class<T> cls, String location) {
        this.cls = cls;
        this.location = location;
    }

    public DatahotelBuilder<T> fetcher(Fetcher fetcher) {
        this.fetcher = fetcher;
        return this;
    }

    public DatahotelBuilder<T> mapper(ObjectMapper mapper) {
        this.mapper = mapper;
        return this;
    }

    public DatahotelBuilder<T> raw(Class<?> raw) {
        this.raw = raw;
        return this;
    }

    public DatahotelBuilder<T> source(String source) {
        this.source = source;
        return this;
    }

    public Datahotel<T> build() {
        if (fetcher == null)
            fetcher(new ApacheFetcher());
        if (mapper == null)
            mapper(getDefaultMapper());
        if (source == null)
            source("https://hotell.difi.no/");

        return new Datahotel<T>(fetcher, mapper, cls, raw, source, location);
    }
}
