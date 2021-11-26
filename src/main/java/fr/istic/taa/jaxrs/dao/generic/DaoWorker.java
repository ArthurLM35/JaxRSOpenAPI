package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Worker;

public class DaoWorker extends AbstractJpaDao<Long, Worker> {

	public DaoWorker() {
		super();
		this.setClazz(Worker.class);
	}

}
