package org.standrews.schedulingsurgeries.rest;

import org.standrews.schedulingsurgeries.domain.*;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/scheduledsurgeries")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class ScheduleSurgeryResource {
    /*
    private static final Long SINGLETON_TIME_TABLE_ID = 1L;

    @POST
    @Path("{surgeryId}")
    public Response add(@PathParam("surgeryId") Long surgeryId) {
        Surgery surgery = Surgery.findById(surgeryId);
        ScheduledSurgery scheduledSurgery = new ScheduledSurgery(surgery);
        ScheduledSurgery.persist(scheduledSurgery);
        return Response.accepted(scheduledSurgery).build();
    }

    @DELETE
    @Path("{scheduledSurgeryId}")
    public Response delete(@PathParam("scheduledSurgeryId") Long scheduledSurgeryId) {
        ScheduledSurgery scheduledSurgery = ScheduledSurgery.findById(scheduledSurgeryId);
        if (scheduledSurgery == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        scheduledSurgery.delete();
        return Response.status(Response.Status.OK).build();
    }

    @GET
    public List<ScheduledSurgery> getScheduledSurgeries(){
        return ScheduledSurgery.listAll();
    }
     */
}
