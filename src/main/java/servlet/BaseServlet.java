package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Champions;

import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

    protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws ServletException, IOException{
        req.getRequestDispatcher(jsp).forward(req, resp);
    }
    protected Champions getChampionsFromRequest(HttpServletRequest req) {
		Champions c = new Champions();
		c.setChampion_name(req.getParameter("champion_name"));
		c.setTitle(req.getParameter("title"));
		c.setLore(req.getParameter("lore"));
		c.setTags(req.getParameter("tags"));
		return c;
	}
}
