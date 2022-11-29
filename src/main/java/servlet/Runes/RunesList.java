package servlet.Runes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Runes;
import repository.RunesRepository;
import servlet.BaseServlet;

import java.io.IOException;
import java.util.List;

@WebServlet(name="runesList", value="/runesList")
public class RunesList extends BaseServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doYourThing(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//doNothing()
	}

	private void doYourThing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RunesRepository repository = new RunesRepository();
		List<Runes> runesList = repository.findAll();
		req.setAttribute("runes", runesList);
		redirect(req, resp, "/runes/runesList.jsp");
	}
}
