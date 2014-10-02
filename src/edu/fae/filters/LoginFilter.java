package edu.fae.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.fae.model.Usuario;

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		if(precisaLogin((HttpServletRequest) request)) {
			
			//Verifica se está logado
			HttpSession session = ((HttpServletRequest) request).getSession();
			
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			if(usuario==null) {
				//Não processa a página e faz o redirect para o login.jsf
				((HttpServletResponse) response).sendRedirect("login.jsf");	
			}else{
				//Faz o processamento da página
				chain.doFilter(request, response);
			}
			
		}else{
			
			//Faz o processamento da página
			chain.doFilter(request, response);	
		}
		
	}

	
	private boolean precisaLogin(HttpServletRequest request) {
		String paginaAcessada = request.getRequestURI();
		
		String contextPath = ((HttpServletRequest) request).getContextPath();
		if(!contextPath.endsWith("/")) {
			contextPath = contextPath + "/";
			
		}
		
		if(paginaAcessada.startsWith(contextPath+"javax.faces.resource/")) {
			//Nao Precisa de login
			return false;
		}
		
		if(paginaAcessada.equals(contextPath+"login.jsf")) {
			//Nao Precisa de login
			return false;
		}
		
		//Precisa de login
		return true;
	}
	
	public void init(FilterConfig config) throws ServletException {
	}

}
