package no.difi.datahotel.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.difi.datahotel.client.lang.DatahotelException;
import no.difi.datahotel.client.lang.Fetcher;
import no.difi.datahotel.client.lang.InternalResult;

import java.net.URI;
import java.util.List;

public class Datahotel {

    private static ObjectMapper mapper = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    private Fetcher fetcher;
    private String source;
    private String location;
    private JavaType javaType;

    Datahotel(Fetcher fetcher, Class<?> dataset, String source, String location) {
        this.fetcher = fetcher;
        this.source = source;
        this.location = location;
        this.javaType = mapper.getTypeFactory().constructParametricType(InternalResult.class, dataset);
    }

    Result fetch(URI uri) throws DatahotelException {
        try {
            InternalResult ir = mapper.readValue(fetcher.get(uri), this.javaType);
            return new Result(ir.getEntries(), ir.getPage(), ir.getPages(), ir.getPosts());
        } catch (Exception e) {
            throw new DatahotelException(e.getMessage(), e);
        }
    }

    public Query page(long page) {
        return createQuery().page(page);
    }

    public Query search(String query) {
        return createQuery().search(query);
    }

    public Query field(String key, String value) {
        return createQuery().field(key, value);
    }

    public Result fetch() throws DatahotelException {
        return createQuery().fetch();
    }

    private Query createQuery() {
        return new Query(this, URI.create(source + "api/json/" + location));
    }
}
