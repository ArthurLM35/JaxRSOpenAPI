package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "Worker")
public class Worker extends User implements Serializable {
	
	private String job;
	
	public Worker() {
		super();
	}
	
	public Worker(String n, String m, String md,String job) {
		super(n, m, md);		
		this.job = job;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}	

}
