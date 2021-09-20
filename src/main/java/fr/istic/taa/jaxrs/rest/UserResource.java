package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.DaoAppointment;
import fr.istic.taa.jaxrs.dao.generic.DaoUser;
import fr.istic.taa.jaxrs.dao.generic.DaoWorker;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/user")
@Produces({"application/json", "application/xml"})
public class UserResource {
	
	DaoUser user = new DaoUser();
	//User client1 = new User();
	
	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("userId") Long userId)  {
		return user.findOne(userId);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll()  {
		return user.findAll();
	}
	
	 @POST
	 @Consumes("application/json")
	 public Response addUser(
			@Parameter(description = "User object that needs to be added to the store", required = true) User user) {
	 		// add user
	    return Response.ok().entity("SUCCESS").build();
	  }
}
