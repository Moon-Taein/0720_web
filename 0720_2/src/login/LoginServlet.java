package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// url을 통해 form 보여주는 쪽
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/loginForm.jsp").forward(request, response);
	}

	// post 처리하는 쪽
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		if (id.equals(password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("AUTH", id);
			response.getWriter().println("OK");
		} else {
			response.getWriter().println("NOT OK");
		}
	}

}
