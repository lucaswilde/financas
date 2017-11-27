package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Categoria;
import controle.CategoriaDAO;

public class CategoriaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		processRequest(req, resp);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Categoria> lista = new CategoriaDAO().listar();

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<html><body>");

		for (Categoria categoria : lista) {
			pw.println(categoria.getDescricao() + "<br>");
		}
		pw.println("</body></html>");

		pw.close();
	}
}
