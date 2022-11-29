package servlet.championsInsert;

import java.io.IOException;
import java.util.Optional;
import models.Champions;
import repository.ChampionsRepository;
import servlet.BaseServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/championsInser")
public class ChampionsInsert extends BaseServlet {

	ChampionsRepository repository = new ChampionsRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		champions item = getChampionsFromRequest(req);
	
		repository.insert(item);
		redirect(req, resp, "/index.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}