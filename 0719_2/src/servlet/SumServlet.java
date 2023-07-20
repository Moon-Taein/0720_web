package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SumServlet")
public class SumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/form2.html").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("사용자 Post 요청 확인");

		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");

		if (num1 == null || num2 == null) {
			System.out.println("사용자 입력 파라미터 없음");

			resp.setCharacterEncoding("utf-8");
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.setHeader("Content-Type", "text/plain;charset=utf-8");

			PrintWriter pw = resp.getWriter();
			pw.println("정수 2개를 정확히 입력해야합니다!");
			pw.flush();
		} else {
			System.out.println("입력값1: " + num1);
			System.out.println("입력값2: " + num2);

			Integer i1 = Integer.valueOf(num1);
			Integer i2 = Integer.valueOf(num2);

			Integer sum = i1 + i2;

			req.setAttribute("sum", sum);
			req.getRequestDispatcher("/WEB-INF/sum.jsp").forward(req, resp);
		}
	}

}