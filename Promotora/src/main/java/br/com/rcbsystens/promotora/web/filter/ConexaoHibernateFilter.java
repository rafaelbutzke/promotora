package br.com.rcbsystens.promotora.web.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.rcbsystens.promotora.model.dao.hibernate.HibernateUtil;

@WebFilter(urlPatterns={"*.jsf","*.xhtml"})
public class ConexaoHibernateFilter implements Filter{
	private SessionFactory sf;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.sf = HibernateUtil.getSessionFactory();
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Session currentSession = this.sf.getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = currentSession.beginTransaction();
			chain.doFilter(request, response);
			transaction.commit();
			if (currentSession.isOpen()) {
				currentSession.close();
			}
			
		} catch (Throwable ex) {
		try {
			if(transaction.isActive()){
				transaction.rollback();
			}
		} catch (Exception t) {
			t.printStackTrace();
		}
		throw new ServletException(ex);
		}
	System.out.println("Passou filtro!");	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


	
}
