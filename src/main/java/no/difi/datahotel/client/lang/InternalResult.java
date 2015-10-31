package no.difi.datahotel.client.lang;

import java.util.List;

public class InternalResult<T> {

    private List<T> entries;
    private long page;
    private long pages;
    private long posts;

    public List<T> getEntries() {
        return entries;
    }

    public long getPage() {
        return page;
    }

    public long getPages() {
        return pages;
    }

    public long getPosts() {
        return posts;
    }
}
