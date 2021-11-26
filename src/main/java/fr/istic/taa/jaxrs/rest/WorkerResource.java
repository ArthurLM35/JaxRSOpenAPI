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

import fr.istic.taa.jaxrs.dao.generic.DaoWorker;
import fr.istic.taa.jaxrs.domain.Worker;
import io.swagger.v3.oas.annotations.Parameter;

@Path("/worker")
@Produces({"application/json", "application/xml"})
public class WorkerResource {

	DaoWorker work = new DaoWorker();
	
	@GET
	@Path("/job/{workerJob}")
	@Produces(MediaType.APPLICATION_JSON)
	public Worker getWorkerByJob(@PathParam("workerJob") Long workerJob)  {
		return work.findOne(workerJob);
	}
	
	@GET
	@Path("/{workerId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Worker getWorkerById(@PathParam("workerId") Long workerId)  {
		return work.findOne(workerId);
	}
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Worker> getAll()  {
		return work.findAll();
	}
	
	 @POST
	 @Path("/add")
	 @Consumes("application/json")
	 public Response addWorker(
			@Parameter(description = "User object that needs to be added to the store", required = true) Worker worker) {
		 	Boolean trouver = false;
		 	DaoWorker work1 = new DaoWorker();
		 	for(Worker u1 : work.findAll()) {
		 		if(trouver == false) {
		 			if(u1.getMail().equals(worker.getMail())) {
		 				trouver=true;
		 			}
		 		}
		 	}
		 	if(trouver == false) {
		 		work1.save(worker);	
			    return Response.ok().entity("SUCCESS").build();
		 	}
		 	else {
		 		return Response.ok().entity("Votre adresse mail est déjà utilisée par un autre compte").build();
		 	}
	  }
	 
	 /* {"job":"kinésithérapeute","id":null,"name":"Vincent Rochelle","mail":"vincentrochelle@gmail.com","mdp":"adfgefevd","appoint":[]} */
	 
	 @DELETE
	 @Path("/delete/{id}")
	 public Response deleteWorker(@PathParam("id") Long workerId) {			 
		 		DaoWorker work1 = new DaoWorker();
		 		work1.delete(work.findOne(workerId));	
		    return Response.ok().entity("SUCCESS").build();
	}
	
	 @DELETE
	 @Path("/deleteall")
	 public Response deleteAll() {			 
			 	DaoWorker work1 = new DaoWorker();
			 	for(Worker u1 :work.findAll()) {
			 		work1.delete(work.findOne(u1.getId()));
			 	}			 		
		    return Response.ok().entity("SUCCESS").build();
	} 
}
