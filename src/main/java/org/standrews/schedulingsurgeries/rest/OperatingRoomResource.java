package org.standrews.schedulingsurgeries.rest;

import org.standrews.schedulingsurgeries.domain.*;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class OperatingRoomResource {

    private static final Long SINGLETON_TIME_TABLE_ID = 1L;


    @POST
    @Path("{roomName}/{timeId}")
    public Response add(@PathParam("roomName") String roomName, @PathParam("timeId") Long timeId) {
        Time time = Time.findById(timeId);
        OperatingRoom operatingRoom = new OperatingRoom(roomName, time);
        OperatingRoom.persist(operatingRoom);
        return Response.accepted(operatingRoom).build();
    }


    @DELETE
    @Path("{roomId}")
    public Response delete(@PathParam("roomId") Long roomId) {
        OperatingRoom operatingRoom = OperatingRoom.findById(roomId);
        if (operatingRoom == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        operatingRoom.delete();
        return Response.status(Response.Status.OK).build();
    }

    @GET
    public List<OperatingRoom> getOperatingRooms(){
        return OperatingRoom.listAll();
    }
}
