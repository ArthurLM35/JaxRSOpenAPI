package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@XmlRootElement(name = "Appointment")
public class Appointment implements Serializable {

	private long id;
	private String date;
	private int lenght;
	private User us;
	private Worker work;
	private String description;
	
	public Appointment() {
    }
	
	public Appointment(String date,int lenght, User us, Worker work, String desc) {
		this.date = date;
		this.lenght = lenght;
		this.us = us;
		this.work = work;
		this.description = desc;		
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
	
	@XmlElement(name = "date")
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	@XmlElement(name = "lenght")
	public int getLenght() {
		return lenght;
	}
	
	public void setLenght(int lenght) {
		this.lenght = lenght;
	}
	
	@ManyToOne
	@XmlElementWrapper(name = "uss")
	@XmlElement(name = "us")
	//@JsonBackReference   /* Si décommenté -> n'affiche pas user */
	public User getUs() {
		return us;
	}
	
	public void setUs(User us) {
		this.us = us;
	}
	
	@OneToOne
	@XmlElement(name="work")
	public Worker getWork() {
		return work;
	}
	
	public void setWork(Worker work) {
		this.work = work;
	}

	@XmlElement(name="description")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "";
	}

}
