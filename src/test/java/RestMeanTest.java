import org.junit.Test;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.hu.iac.service.Mean;
import nl.hu.iac.service.ServiceProvider;
import nl.hu.iac.service.MeanServiceImpl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
/**
 * Created by Philip on 3/24/2017.
 */


public class RestMeanTest {
    MeanServiceImpl meanServiceImpl;
    int[] values = new int[5];

    @org.junit.Before
    public void setUp() throws Exception {
        meanServiceImpl = ServiceProvider.getMeanService();
    }

    @org.junit.After
    public void destroy() throws Exception {

    }

    @Test
    public void positiveMeanTest() throws Exception {
        values[0] = 1;
        values[1] = 1;
        values[2] = 1;
        values[3] = 1;
        values[4] = 1;
        Mean result = meanServiceImpl.getMean(values);

        assertNotNull("Response is null!",result.getResult());
        assertEquals(1.0, result.getResult(), 0.005);
    }

    @Test
    public void largeMeanTest() throws Exception {
        values[0] = 1000000000;
        values[1] = 1000000000;
        values[2] = 1000000000;
        values[3] = 1000000000;
        values[4] = 1000000000;
        Mean result = meanServiceImpl.getMean(values);

        assertNotNull("Response is null!",result.getResult());
        assertEquals(1.0E9, result.getResult(), 0.005);
    }

    @Test
    public void negativeMeanTest() throws Exception {
        values[0] = -1;
        values[1] = -1;
        values[2] = -1;
        values[3] = -1;
        values[4] = -1;
        Mean result = meanServiceImpl.getMean(values);

        assertNotNull("Response is null!",result.getResult());
        assertEquals(-1.0, result.getResult(), 0.005);
    }

    @Test
    public void decimalMeanTest() throws Exception {
        values[0] = 2;
        values[1] = 5;
        values[2] = 6;
        values[3] = 1;
        values[4] = 7;
        Mean result = meanServiceImpl.getMean(values);

        assertNotNull("Response is null!",result.getResult());
        assertEquals(4.2, result.getResult(), 0.005);
    }

    @Test
    public void repeatingMeanTest() throws Exception {
        int[] three = new int[3];
        three[0] = 1;
        three[1] = 0;
        three[2] = 0;
        Mean result = meanServiceImpl.getMean(three);

        assertNotNull("Response is null!",result.getResult());
        assertEquals(0.333, result.getResult(), 0.005);
    }
}
