package no.difi.datahotel.client;

import no.difi.datahotel.client.dataset.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatahotelTest {

    @Test
    public void simple() throws Exception {
        Datahotel<DifiGeoKommune> datahotel = DatahotelBuilder.create(DifiGeoKommune.class).build();
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
        Datahotel<BrregEnhetsregisteret> datahotel = DatahotelBuilder.create(BrregEnhetsregisteret.class).build();

        for (BrregEnhetsregisteret o : datahotel.page(1).fetch())
            Assert.assertFalse(o.toString().contains("null"));
    }

    @Test
    public void brregEnhetsregisteretAdvanced() throws Exception {
        Datahotel<BrregEnhetsregisteretExtra> datahotel = DatahotelBuilder.create(BrregEnhetsregisteretExtra.class).build();

        BrregEnhetsregisteretExtra difi = datahotel.field("orgnr", "991825827").single();
        Assert.assertNotNull(difi);
        Assert.assertEquals(difi.getIdentifier(), "991825827");
        Assert.assertEquals(difi.getName(), "DIREKTORATET FOR FORVALTNING OG IKT");
        Assert.assertEquals(difi.getPostalAddress().getCountry(), "Norge");

        for (BrregEnhetsregisteretExtra o : datahotel.fetch()) {
            Assert.assertNotNull(o.getPostalAddress().getCountry());
            System.out.println(o.getPostalAddress());
        }
    }

    @Test
    public void brregUnderenheter() throws Exception {
        Datahotel<BrregUnderenheter> datahotel = DatahotelBuilder.create(BrregUnderenheter.class).build();

        for (BrregUnderenheter o : datahotel.page(1).fetch())
            Assert.assertFalse(o.toString().contains("null"));
    }

    @Test
    public void test404() throws Exception {
        Datahotel<Object> datahotel = DatahotelBuilder.create(Object.class, "some/location").build();
        Result result = datahotel.fetch();

        Assert.assertEquals(result.getPage(), 0);
        Assert.assertEquals(result.getPages(), 0);
        Assert.assertEquals(result.getPosts(), 0);
        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void county() throws Exception {
        Datahotel<DifiGeoFylke> datahotel = DatahotelBuilder.create(DifiGeoFylke.class).build();

        DifiGeoFylke fylke = datahotel.field("nummer", 14).single();
        System.out.println(fylke.getNavn());

        for (DifiGeoFylke county : datahotel.page(1)) {
            System.out.println(String.format("%s: %s", county.getNummer(), county.getNavn()));
        }
    }
}
