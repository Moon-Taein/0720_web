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
import javax.servlet.annotation.WebInitParam;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = {
		"/*" }, initParams = @WebInitParam(name = "charset", value = "utf-8"))

// annotation 으로 정한 필터는 순서를 정할 수 없다.
// web_xml 에서는 먼저 기술한대로 순서대로 동작
public class EncodingFilter implements Filter {
	private String charset;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("인코딩 필터 동작 확인");

		// place your code here
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);

		// pass the request along the filter chain
		chain.doFilter(request, response);

	}

	// 초기 설정값
	public void init(FilterConfig fConfig) throws ServletException {
		charset = fConfig.getInitParameter("charset");

	}

}