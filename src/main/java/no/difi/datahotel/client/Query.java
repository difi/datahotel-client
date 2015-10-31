package no.difi.datahotel.client;

import no.difi.datahotel.client.lang.DatahotelException;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;

public class Query {

    private Datahotel datahotel;
    private URIBuilder uriBuilder;

    Query(Datahotel datahotel, URI uri) {
        this.datahotel = datahotel;
        this.uriBuilder = new URIBuilder(uri);
    }

    public Query page(long page) {
        uriBuilder.setParameter("page", String.valueOf(page));
        return this;
    }

    public Query search(String query) {
        uriBuilder.setParameter("query", query);
        return this;
    }

    public Query field(String key, String value) {
        uriBuilder.setParameter(key, value);
        return this;
    }

    public Result fetch() throws DatahotelException{
        try {
            return datahotel.fetch(uriBuilder.build());
        } catch (DatahotelException e) {
            throw e;
        } catch (Exception e) {
            throw new DatahotelException(e.getMessage(), e);
        }
    }
}
