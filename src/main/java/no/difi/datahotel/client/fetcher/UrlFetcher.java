package no.difi.datahotel.client.fetcher;

import no.difi.datahotel.client.lang.Fetcher;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class UrlFetcher implements Fetcher {

    @Override
    public InputStream get(URI uri) throws IOException {
        return uri.toURL().openConnection().getInputStream();
    }
}
