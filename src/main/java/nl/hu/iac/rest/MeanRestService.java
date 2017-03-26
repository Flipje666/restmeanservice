package nl.hu.iac.rest;

/**
 * Created by Philip on 3/16/2017.
 */

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nl.hu.iac.service.Mean;
import nl.hu.iac.service.ServiceProvider;
import nl.hu.iac.service.MeanServiceImpl;

import java.util.List;

@Path("/mean")
public class MeanRestService {

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response calculateMean(int[] numbers) {
            MeanServiceImpl meanServiceImpl = ServiceProvider.getMeanService();
            Mean mean = meanServiceImpl.getMean(numbers);
            return Response.status(200).entity(mean).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<int[]> giveArrays() {
        MeanServiceImpl meanServiceImpl = ServiceProvider.getMeanService();
        return meanServiceImpl.getArrays();
    }

    @GET
    @Path("/{index}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response giveArray(@PathParam("index") int index) {
        MeanServiceImpl meanServiceImpl = ServiceProvider.getMeanService();
        try {
            int[] result = meanServiceImpl.getArrayByIndex((index - 1));
            return Response.status(200).entity(result).build();
        } catch (IndexOutOfBoundsException e) {
            return Response.status(500).entity("Index out of bounds!").build();
        }

    }


}
