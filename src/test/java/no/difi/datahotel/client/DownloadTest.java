package no.difi.datahotel.client;

import no.difi.datahotel.client.dataset.BrregEnhetsregisteret;
import no.difi.datahotel.client.dataset.BrregSektorkode;
import no.difi.datahotel.client.dataset.DifiGeoKommune;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadTest {

    @Test
    public void simple() throws Exception {
        Datahotel<DifiGeoKommune> datahotel = DatahotelBuilder.create(DifiGeoKommune.class).build();

        int counter = 0;
        for (DifiGeoKommune kommune : datahotel.all()) {
            // System.out.println(kommune);
            counter++;
        }
        Assert.assertEquals(counter, 428);
    }

    @Test
    public void brregSektorkode() throws Exception {
        int counter = 0;
        for (BrregSektorkode sektorkode : DatahotelBuilder.create(BrregSektorkode.class).build().all()) {
            // System.out.println(sektorkode);
            counter++;
        }
        Assert.assertTrue(counter > 20);
    }

    @Test(enabled = false)
    public void brregEnhetsregisteret() throws Exception {
        Datahotel<BrregEnhetsregisteret> datahotel = DatahotelBuilder.create(BrregEnhetsregisteret.class).build();

        int counter = 0;
        for (BrregEnhetsregisteret o : datahotel.all()) {
            if (counter % 100 == 0)
                System.out.println(o);
            counter++;
        }
        System.out.println(counter);
    }
}
