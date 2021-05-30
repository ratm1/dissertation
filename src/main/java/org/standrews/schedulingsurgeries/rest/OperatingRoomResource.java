package org.standrews.schedulingsurgeries.rest;

import org.standrews.schedulingsurgeries.domain.OperatingRoom;
import org.standrews.schedulingsurgeries.domain.ScheduledSurgery;
import org.standrews.schedulingsurgeries.domain.Surgery;
import org.standrews.schedulingsurgeries.domain.TimeTable;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/rooms")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class OperatingRoomResource {
    private static final Long SINGLETON_TIME_TABLE_ID = 1L;
    @POST
    public Response add(OperatingRoom operatingRoom) {
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
        TimeTable solution = findById(SINGLETON_TIME_TABLE_ID);
        return solution.getOperatingRooms();
    }

    @Transactional
    protected TimeTable findById(Long id) {
        return new TimeTable(
                OperatingRoom.listAll(),
                Surgery.listAll(),
                ScheduledSurgery.listAll());
    }
}
