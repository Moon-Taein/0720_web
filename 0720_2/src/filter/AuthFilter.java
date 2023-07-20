package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/service/*")
public class AuthFilter implements Filter {
	// filter를 통해 character - utf-8 과정도 통과시켜서 하게 할 수 있다
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("1. 서블릿이 요청 처리 전");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("AUTH") != null) {
			chain.doFilter(request, response);
		} else {
			String url = req.getContextPath() + "/login";
			resp.sendRedirect(url);
		}

		System.out.println("2. 서블릿이 요청 처리 후");
	}

}