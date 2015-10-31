package no.difi.datahotel.client;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DatahotelBuilderTest {

    @Test
    public void simple() {
        try {
            DatahotelBuilder.create(Object.class);
            Assert.fail("Exception expected.");
        } catch (IllegalStateException e) {
            // No action.
        }

        DatahotelBuilder.create(Object.class, "some/location");
    }

}
