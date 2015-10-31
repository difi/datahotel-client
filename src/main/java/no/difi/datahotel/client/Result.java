package no.difi.datahotel.client;

import java.util.ArrayList;
import java.util.List;

public class Result<T> extends ArrayList<T> {

    private long page;
    private long pages;
    private long posts;

    @SuppressWarnings("unchecked")
    public Result(List entries, long page, long pages, long posts) {
        if (entries != null)
            this.addAll(entries);
        this.page = page;
        this.pages = pages;
        this.posts = posts;
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
