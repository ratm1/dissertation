package org.standrews.schedulingsurgeries.rest;

import org.standrews.schedulingsurgeries.domain.*;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/surgerytypes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class SurgeryTypeResource {
    private static final Long SINGLETON_TIME_TABLE_ID = 1L;
    @POST
    public Response add(SurgeryType surgeryType) {
        SurgeryType.persist(surgeryType);
        return Response.accepted(surgeryType).build();
    }

    @DELETE
    @Path("{surgeryTypeId}")
    public Response delete(@PathParam("surgeryTypeId") Long surgeryTypeId) {
        SurgeryType surgeryType = SurgeryType.findById(surgeryTypeId);
        if (surgeryType == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        surgeryType.delete();
        return Response.status(Response.Status.OK).build();
    }

    @GET
    public List<SurgeryType> getSurgeryTypes(){
        TimeTable solution = findById(SINGLETON_TIME_TABLE_ID);
        return solution.findSurgeryTypes();
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
