package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Appointment;

public class DaoAppointment extends AbstractJpaDao<Long, Appointment> {

	public DaoAppointment() {
		super();
		this.setClazz(Appointment.class);
	}

}
