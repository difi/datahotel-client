package no.difi.datahotel.client;

import no.difi.datahotel.client.lang.DatahotelException;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.util.Iterator;

public class Query<T> implements Iterable<T> {

    private Datahotel<T> datahotel;
    private URIBuilder uriBuilder;

    Query(Datahotel<T> datahotel, URI uri) {
        this.datahotel = datahotel;
        this.uriBuilder = new URIBuilder(uri);
    }

    public Query<T> page(long page) {
        uriBuilder.setParameter("page", String.valueOf(page));
        return this;
    }

    public Query<T> search(String query) {
        uriBuilder.setParameter("query", query);
        return this;
    }

    public Query<T> field(String key, String value) {
        uriBuilder.setParameter(key, value);
        return this;
    }

    public Result<T> fetch() throws DatahotelException{
        try {
            return datahotel.fetch(uriBuilder.build());
        } catch (DatahotelException e) {
            throw e;
        } catch (Exception e) {
            throw new DatahotelException(e.getMessage(), e);
        }
    }

    @Override
    public Iterator<T> iterator() {
        try {
            return fetch().iterator();
        } catch (DatahotelException e) {
            return null;
        }
    }
}
