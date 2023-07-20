package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calcul/minus")
public class MinusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/Form.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		Integer intNum1 = Integer.valueOf(num1);
		Integer intNum2 = Integer.valueOf(num2);

		int result = intNum1 - intNum2;

		request.setAttribute("result2", result);
		HttpSession session = request.getSession();
		session.setAttribute("result2", result);
		request.getRequestDispatcher("../Form.jsp").forward(request, response);
	}

}
