package it.prova.gestionebiglietti.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionebiglietti.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteShowBigliettoServlet
 */
@WebServlet("/ExecuteShowBigliettoServlet")
public class ExecuteShowBigliettoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteShowBigliettoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idBigliettoParam = request.getParameter("idBiglietto");

		if (!NumberUtils.isCreatable(idBigliettoParam)) {
			request.setAttribute("errorMessage", "Attenzione si è verificato un errorino.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		try {
			request.setAttribute("visualizza_biglietto_attr", MyServiceFactory.getBigliettoServiceInstance()
					.caricaSingoloElemento(Long.parseLong(idBigliettoParam)));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Attenzione si è verificato un errore.");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("/biglietto/show.jsp").forward(request, response);
	}

}
