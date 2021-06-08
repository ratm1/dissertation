package org.standrews.schedulingsurgeries.rest;

import org.standrews.schedulingsurgeries.domain.Insurance;
import org.standrews.schedulingsurgeries.domain.Speciality;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/specialities")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class SpecialityResource {
    private static final Long SINGLETON_TIME_TABLE_ID = 1L;
    @POST
    @Path("{name}")
    public Response add(@PathParam("name") String name) {
        Speciality speciality = new Speciality(name);
        Speciality.persist(speciality);
        return Response.accepted(speciality).build();
    }

    @DELETE
    @Path("{specialityId}")
    public Response delete(@PathParam("specialityId") Long specialityId) {
        Speciality speciality = Speciality.findById(specialityId);
        if (speciality == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        speciality.delete();
        return Response.status(Response.Status.OK).build();
    }

    @GET
    public List<Speciality> getSpecialities(){
        return Speciality.listAll();
    }
}
