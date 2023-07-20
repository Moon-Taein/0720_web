package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calcul/sum")
public class SumServlet extends HttpServlet {
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

		int result = intNum1 + intNum2;

		System.out.println("여기 아예 동작을 안하니?");

		request.setAttribute("result1", result);
		HttpSession session = request.getSession();
		session.setAttribute("result1", result);
		request.getRequestDispatcher("../Form.jsp").forward(request, response);
		// forward 하면 url 이 유지가 되어버리네

	}

}
