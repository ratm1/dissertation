package org.standrews.schedulingsurgeries.rest;

import org.standrews.schedulingsurgeries.domain.*;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/insurances")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class InsuranceResource {
    private static final Long SINGLETON_TIME_TABLE_ID = 1L;
    @POST
    public Response add(Insurance insurance) {
        Insurance.persist(insurance);
        return Response.accepted(insurance).build();
    }

    @DELETE
    @Path("{insuranceId}")
    public Response delete(@PathParam("insuranceId") Long insuranceId) {
        Insurance insurance = Insurance.findById(insuranceId);
        if (insurance == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        insurance.delete();
        return Response.status(Response.Status.OK).build();
    }

    @GET
    public List<Insurance> getInsurances(){
        return Insurance.listAll();
    }
}
