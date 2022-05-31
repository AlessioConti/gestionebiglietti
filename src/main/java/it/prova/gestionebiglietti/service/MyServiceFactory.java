package it.prova.gestionebiglietti.service;

import it.prova.gestionebiglietti.dao.BigliettoDAO;
import it.prova.gestionebiglietti.dao.BigliettoDAOImpl;

public class MyServiceFactory {
	private static BigliettoService BIGLIETTO_SERVICE_INSTANCE = null;
	private static BigliettoDAO BIGLIETTOODAO_INSTANCE = null;

	public static BigliettoService getBigliettoServiceInstance() {
		if (BIGLIETTO_SERVICE_INSTANCE == null)
			BIGLIETTO_SERVICE_INSTANCE = new BigliettoServiceImpl();

		if (BIGLIETTOODAO_INSTANCE == null)
			BIGLIETTOODAO_INSTANCE = new BigliettoDAOImpl();

		BIGLIETTO_SERVICE_INSTANCE.setBigliettoDao(BIGLIETTOODAO_INSTANCE);

		return BIGLIETTO_SERVICE_INSTANCE;
	}

}
