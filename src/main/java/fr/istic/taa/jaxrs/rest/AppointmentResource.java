package fr.istic.taa.jaxrs.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.DaoAppointment;
import fr.istic.taa.jaxrs.domain.Appointment;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/appointment")
@Produces({"application/json", "application/xml"})
public class AppointmentResource {
	
	DaoAppointment appoint = new DaoAppointment();
	
	@GET
	@Path("/{appointmentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Appointment getAppointmentById(@PathParam("appointmentId") Long appointmentId)  {
		return appoint.findOne(appointmentId);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Appointment> getAll()  {
		return appoint.findAll();
	}
	
	@GET
	@Path("/listId/{appointmentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Appointment> getlistId(@PathParam("appointmentId") Long userId)  {
		List<Appointment> list = new ArrayList<Appointment>();
		for(Appointment u1 : appoint.findAll()){
			if(u1.getUs().getId() == userId) {
				list.add(u1);
			}
		}
		return list;
	}
	
	/* http://localhost:8080/appointment/listId/2 */
	
	@GET
	@Path("/listIdName/{appointmentName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Appointment> getlistName(@PathParam("appointmentName") String userName)  {
		List<Appointment> list = new ArrayList<Appointment>();
		for(Appointment u1 : appoint.findAll()){
			if(u1.getUs().getName().equals(userName)) {
				list.add(u1);
			}
		}
		return list;
	}
	
	 @POST
	 @Path("/add")
	 @Consumes("application/json")
	 public Response addRdv(
			@Parameter(description = "Appaintment object that needs to be added to the store", required = true) Appointment appoint) {
	 		
		DaoAppointment app = new DaoAppointment();
	 	app.save(appoint);	
	    return Response.ok().entity("SUCCESS").build();
	  }
	 
	 /* {"id":null,"lenght":30,"us":null,"work":null,"description":"mal de tete"} */
	 
	 @DELETE
	 @Path("/delete/{id}")
	 public Response deleteAppointment(@PathParam("id") Long appointId) {			 
		 		DaoAppointment app = new DaoAppointment();
			 	app.delete(appoint.findOne(appointId));	
		    return Response.ok().entity("SUCCESS").build();
	}
	 
	 /* localhost:8080/appointment/delete/74 */
	 
	 @DELETE
	 @Path("/deleteall")
	 public Response deleteAll() {			 
		 		DaoAppointment app = new DaoAppointment();
			 	for(Appointment u1 :app.findAll()) {
			 		app.delete(appoint.findOne(u1.getId()));
			 	}			 		
		    return Response.ok().entity("SUCCESS").build();
	}

}
