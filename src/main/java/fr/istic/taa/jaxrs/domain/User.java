package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@XmlRootElement(name = "User")
public class User implements Serializable{

	
	private long id;
	private String name;
	private String mail;
	private String mdp;
	private List<Appointment> appoint = new ArrayList<Appointment>();
	
	public User() {
    }
	
	public User(String n, String m, String md){
		this.name=n;
		this.mail=m;
		this.mdp=md;
	}
	
	@Id
	@GeneratedValue
	@XmlElement(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	@XmlElement(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name = "mail")
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	@XmlElement(name = "mdp")
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	@OneToMany(mappedBy="us", cascade=CascadeType.ALL)
	@XmlElementWrapper(name = "appoints")
	@XmlElement(name = "appoint")
	@JsonManagedReference
	public List<Appointment> getAppoint() {
		return appoint;
	}

	public void setAppoint(List<Appointment> appoint) {
		this.appoint = appoint;
	}

	@Override
	public String toString() {
		return "";
	}
	
}
