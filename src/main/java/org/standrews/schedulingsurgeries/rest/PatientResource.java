package org.standrews.schedulingsurgeries.rest;

import org.standrews.schedulingsurgeries.domain.*;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class PatientResource {
    private static final Long SINGLETON_TIME_TABLE_ID = 1L;

    @POST
    @Path("{patientId}/{firstName}/{lastName}")
    public Response add(@PathParam("patientId") Long patientId, @PathParam("firstName") String firstName, @PathParam("lastName") String lastName) {
        Patient patient = new Patient(patientId, firstName, lastName);
        Patient.persist(patient);
        return Response.accepted(patient).build();
    }

    @DELETE
    @Path("{patientId}")
    public Response delete(@PathParam("patientId") Long patientId) {
        Patient patient = Patient.findById(patientId);
        if (patient == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        patient.delete();
        return Response.status(Response.Status.OK).build();
    }

    @GET
    public List<Patient> getPatients(){
        return Patient.listAll();
    }

}
