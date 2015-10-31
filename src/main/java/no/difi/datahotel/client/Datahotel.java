package no.difi.datahotel.client;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.difi.datahotel.client.lang.DatahotelException;
import no.difi.datahotel.client.lang.Fetcher;
import no.difi.datahotel.client.lang.InternalResult;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;

public class Datahotel<T> implements Iterable<T> {

    private ObjectMapper mapper;
    private Fetcher fetcher;
    private Class<T> cls;
    private String source;
    private String location;
    private JavaType javaType;

    Datahotel(Fetcher fetcher, ObjectMapper mapper, Class<T> cls, String source, String location) {
        this.fetcher = fetcher;
        this.mapper = mapper;
        this.cls = cls;
        this.source = source;
        this.location = location;
        this.javaType = mapper.getTypeFactory().constructParametricType(InternalResult.class, cls);
    }

    Result<T> fetch(URI uri) throws DatahotelException {
        try {
            InternalResult ir = mapper.readValue(fetcher.get(uri), this.javaType);
            return new Result<T>(ir.getEntries(), ir.getPage(), ir.getPages(), ir.getPosts());
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

    public Query<T> field(String key, String value) {
        return createQuery().field(key, value);
    }

    public Result<T> fetch() throws DatahotelException {
        return createQuery().fetch();
    }

    @Override
    public Iterator<T> iterator() {
        try {
            return new Download<T>(fetcher.get(URI.create(source + "download/" + location)), cls);
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    private Query<T> createQuery() {
        return new Query<T>(this, URI.create(source + "api/json/" + location));
    }
}
