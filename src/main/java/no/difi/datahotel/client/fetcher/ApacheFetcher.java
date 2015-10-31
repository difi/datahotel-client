package no.difi.datahotel.client.fetcher;

import no.difi.datahotel.client.lang.Fetcher;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class ApacheFetcher implements Fetcher {
    @Override
    public InputStream get(URI uri) throws IOException {
        HttpClient httpClient = HttpClients.createMinimal();
        return httpClient.execute(new HttpGet(uri)).getEntity().getContent();
    }
}
