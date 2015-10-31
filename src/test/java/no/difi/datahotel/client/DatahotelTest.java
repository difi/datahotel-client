package no.difi.datahotel.client;

import no.difi.datahotel.client.dataset.BrregEnhetsregisteret;
import no.difi.datahotel.client.dataset.BrregUnderenheter;
import no.difi.datahotel.client.dataset.DifiGeoFylke;
import no.difi.datahotel.client.dataset.DifiGeoKommune;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DatahotelTest {

    @Test
    public void simple() throws Exception {
        Datahotel datahotel = DatahotelBuilder.create(DifiGeoKommune.class).build();
        Result result;

        result = datahotel.fetch();
        Assert.assertEquals(result.getPage(), 1);
        Assert.assertEquals(result.getPages(), 5);
        Assert.assertEquals(result.getPosts(), 428);

        result = datahotel.page(5).fetch();
        Assert.assertEquals(result.getPage(), 5);
        Assert.assertEquals(result.getPages(), 5);
        Assert.assertEquals(result.getPosts(), 428);
        Assert.assertEquals(result.size(), 28);

        result = datahotel.field("fylke", "14").fetch();
        Assert.assertEquals(result.getPages(), 1);
        Assert.assertEquals(result.getPosts(), 26);

        result = datahotel.field("fylke", "14").search("Leikanger").fetch();
        Assert.assertEquals(result.getPages(), 1);
        Assert.assertEquals(result.getPosts(), 1);

        result = datahotel.search("Os*").fetch();
        Assert.assertEquals(result.getPages(), 1);
        Assert.assertEquals(result.getPosts(), 5);
    }

    @Test
    public void brregEnhetsregisteret() throws Exception {
        Datahotel datahotel = DatahotelBuilder.create(BrregEnhetsregisteret.class).build();

        for (BrregEnhetsregisteret o : (List<BrregEnhetsregisteret>) datahotel.page(1).fetch())
            Assert.assertFalse(o.toString().contains("null"));
    }

    @Test
    public void brregUnderenheter() throws Exception {
        Datahotel datahotel = DatahotelBuilder.create(BrregUnderenheter.class).build();

        for (BrregUnderenheter o : (List<BrregUnderenheter>) datahotel.page(1).fetch())
            Assert.assertFalse(o.toString().contains("null"));
    }

    @Test
    public void test404() throws Exception {
        Datahotel datahotel = DatahotelBuilder.create(Object.class, "some/location").build();
        Result result = datahotel.fetch();

        Assert.assertEquals(result.getPage(), 0);
        Assert.assertEquals(result.getPages(), 0);
        Assert.assertEquals(result.getPosts(), 0);
        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void county() throws Exception {
        Datahotel datahotel = DatahotelBuilder.create(DifiGeoFylke.class).build();

        Result result = datahotel.field("nummer", "14").fetch();
        System.out.println(((DifiGeoFylke)result.get(0)).getNavn());

        for (DifiGeoFylke county : (List<DifiGeoFylke>) datahotel.fetch()) {
            System.out.println(String.format("%s: %s", county.getNummer(), county.getNavn()));
        }
    }
}
