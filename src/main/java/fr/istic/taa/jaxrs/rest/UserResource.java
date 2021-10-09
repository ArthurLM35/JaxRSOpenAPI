package fr.istic.taa.jaxrs.rest;

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

import fr.istic.taa.jaxrs.dao.generic.DaoUser;
import fr.istic.taa.jaxrs.domain.User;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/user")
@Produces({"application/json", "application/xml"})
public class UserResource {
	
	DaoUser user = new DaoUser();
	
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
	 @Path("/add")
	 @Consumes("application/json")
	 public Response addUser(
			@Parameter(description = "User object that needs to be added to the store", required = true) User user1) {	
		 	Boolean trouver = false;
		 	DaoUser us = new DaoUser();
		 	for(User u1 : user.findAll()) {
		 		if(trouver == false) {
		 			if(u1.getMail().equals(user1.getMail())) {
		 				trouver=true;
		 			}
		 		}
		 	}
		 	if(trouver == false) {
		 		us.save(user1);	
			    return Response.ok().entity("SUCCESS").build();
		 	}
		 	else {
		 		return Response.ok().entity("Votre adresse mail est déjà utilisée par un autre compte").build();
		 	}		 	
	  }
	 
	 /*{"id":null,"name":"Pierre Paul","mail":"pierre@gmail.com","mdp":"adfgvd"}*/
	 
	 @DELETE
	 @Path("/delete/{id}")
	 public Response deleteUser(@PathParam("id") Long userId) {			 
			 	DaoUser us = new DaoUser();
			 	us.delete(user.findOne(userId));	
		    return Response.ok().entity("SUCCESS").build();
	}
	 
	 @DELETE
	 @Path("/deleteall")
	 public Response deleteAllUser() {			 
			 	DaoUser us = new DaoUser();
			 	for(User u1 :user.findAll()) {
			 		us.delete(user.findOne(u1.getId()));
			 	}			 		
		    return Response.ok().entity("SUCCESS").build();
	}
	 	 
}
