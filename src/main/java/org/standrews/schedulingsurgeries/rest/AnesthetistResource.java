package org.standrews.schedulingsurgeries.rest;

import org.standrews.schedulingsurgeries.domain.*;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/anesthetists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class AnesthetistResource {
    private static final Long SINGLETON_TIME_TABLE_ID = 1L;

    @POST
    @Path("{anesthetistId}/{firstName}/{lastName}")
    public Response add(@PathParam("anesthetistId") Long anesthetistId, @PathParam("firstName") String firstName,
                        @PathParam("lastName") String lastName) {
        Anesthetist anesthetist = new Anesthetist(anesthetistId, firstName, lastName);
        Anesthetist.persist(anesthetist);
        return Response.accepted(anesthetist).build();
    }

    @DELETE
    @Path("{anesthetistId}")
    public Response delete(@PathParam("anesthetistId") Long anesthetistId) {
        Anesthetist anesthetist = Anesthetist.findById(anesthetistId);
        if (anesthetist == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        anesthetist.delete();
        return Response.status(Response.Status.OK).build();
    }

    @GET
    public List<Anesthetist> getAnesthetists(){
        return Anesthetist.listAll();
    }

}
