package no.difi.datahotel.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of one page.
 *
 * @param <T>
 */
public class Result<T> extends ArrayList<T> {

    private long page;
    private long pages;
    private long posts;

    @SuppressWarnings("unchecked")
    Result(List entries, long page, long pages, long posts) {
        if (entries != null)
            this.addAll(entries);
        this.page = page;
        this.pages = pages;
        this.posts = posts;
    }

    /**
     * Current page.
     *
     * @return
     */
    public long getPage() {
        return page;
    }

    /**
     * Total amount of pages for query used to fetch this data.
     *
     * @return
     */
    public long getPages() {
        return pages;
    }

    /**
     * Total amount of posts/records/lines for query used to fetch this data.
     * @return
     */
    public long getPosts() {
        return posts;
    }
}
