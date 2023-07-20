package error;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/errorHandle")
public class ErrorHandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration<String> e = req.getAttributeNames();
		while (e.hasMoreElements()) {
			String name = e.nextElement();
			Object value = req.getAttribute(name);

			System.out.println(name + " : " + value);

		}
		PrintWriter pw = resp.getWriter();
		pw.println("ERROR");
		pw.flush();
	}

}