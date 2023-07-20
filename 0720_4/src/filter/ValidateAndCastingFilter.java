package filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/calcul/*" })
public class ValidateAndCastingFilter implements Filter {
	private int count = 0;

	public ValidateAndCastingFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		if (req.getParameter("num1") != null && !(req.getParameter("num1").trim().isEmpty())) {
			if (req.getParameter("num2") != null && !(req.getParameter("num2").trim().isEmpty())) {
				count++;
				HttpSession session = req.getSession();
				session.setAttribute("count", count);
				chain.doFilter(req, resp);
			} else {
				req.setAttribute("result", "숫자 하나가 빠졌어요!");
				req.getRequestDispatcher("../Form.jsp").forward(req, resp);
			}
		} else {
			req.setAttribute("result", "숫자 하나가 빠졌어요!");
			req.getRequestDispatcher("../Form.jsp").forward(req, resp);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
