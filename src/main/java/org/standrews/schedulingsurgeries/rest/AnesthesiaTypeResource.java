package org.standrews.schedulingsurgeries.rest;

import org.standrews.schedulingsurgeries.domain.*;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/anesthesiatypes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class AnesthesiaTypeResource {
    private static final Long SINGLETON_TIME_TABLE_ID = 1L;
    @POST
    public Response add(AnesthesiaType anesthesiaType) {
        AnesthesiaType.persist(anesthesiaType);
        return Response.accepted(anesthesiaType).build();
    }

    @DELETE
    @Path("{anesthesiaTypeId}")
    public Response delete(@PathParam("anesthesiaTypeId") Long anesthesiaTypeId) {
        AnesthesiaType anesthesiaType = AnesthesiaType.findById(anesthesiaTypeId);
        if (anesthesiaType == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        anesthesiaType.delete();
        return Response.status(Response.Status.OK).build();
    }

    @GET
    public List<AnesthesiaType> getAnesthesiaTypes(){
        TimeTable solution = findById(SINGLETON_TIME_TABLE_ID);
        return solution.findAnesthesiaTypes();
    }

    @Transactional
    protected TimeTable findById(Long id) {
        return new TimeTable(
                OperatingRoom.listAll(),
                Surgery.listAll(),
                Patient.listAll(),
                SurgeryType.listAll(),
                Anesthetist.listAll(),
                AnesthesiaType.listAll(),
                ScheduledSurgery.listAll());
    }
}
