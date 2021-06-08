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
    @Path("{code}/{name}")
    public Response add(@PathParam("code") String code, @PathParam("name") String name) {
        SurgeryType surgeryType = new SurgeryType(code, name);
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
        return SurgeryType.listAll();
    }
}
