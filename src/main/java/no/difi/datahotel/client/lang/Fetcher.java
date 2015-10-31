package no.difi.datahotel.client.lang;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public interface Fetcher {

    InputStream get(URI uri) throws IOException;

}
