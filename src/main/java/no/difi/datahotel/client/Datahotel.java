package no.difi.datahotel.client;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.difi.datahotel.client.lang.DatahotelException;
import no.difi.datahotel.client.lang.Fetcher;
import no.difi.datahotel.client.lang.InternalResult;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Client for specific data set.
 *
 * @param <T>
 */
public class Datahotel<T> {

    private ObjectMapper mapper;
    private Fetcher fetcher;
    private Class<T> cls;
    private Class<?> raw;
    private String source;
    private String location;
    private JavaType javaType;

    Datahotel(Fetcher fetcher, ObjectMapper mapper, Class<T> cls, Class<?> raw, String source, String location) {
        this.fetcher = fetcher;
        this.mapper = mapper;
        this.cls = cls;
        this.raw = raw;
        this.source = source;
        this.location = location;
        this.javaType = mapper.getTypeFactory().constructParametricType(InternalResult.class,raw == null ? cls : raw);
    }

    Result<T> fetch(URI uri) throws DatahotelException {
        try {
            InternalResult ir = mapper.readValue(fetcher.get(uri), this.javaType);

            if (raw == null) {
                return new Result<T>(ir.getEntries(), ir.getPage(), ir.getPages(), ir.getPosts());
            } else {
                List<T> entries = new ArrayList<T>();
                for (Object o : ir.getEntries())
                    entries.add(cls.getConstructor(raw).newInstance(o));

                return new Result<T>(entries, ir.getPage(), ir.getPages(), ir.getPosts());
            }
        } catch (Exception e) {
            throw new DatahotelException(e.getMessage(), e);
        }
    }

    public Query<T> page(long page) {
        return createQuery().page(page);
    }

    public Query<T> search(String query) {
        return createQuery().search(query);
    }

    public Query<T> field(String key, Object value) {
        return createQuery().field(key, value);
    }

    public Query<T> field(String key, String value) {
        return createQuery().field(key, value);
    }

    public Result<T> fetch() throws DatahotelException {
        return createQuery().fetch();
    }

    /**
     * Traverse the whole data set, not page by page.
     *
     * @return Iterable for looping.
     */
    public Iterable<T> all() {
        try {
            return new Download<T>(fetcher.get(URI.create(source + "download/" + location)), cls, raw);
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    private Query<T> createQuery() {
        return new Query<T>(this, URI.create(source + "api/json/" + location));
    }
}
