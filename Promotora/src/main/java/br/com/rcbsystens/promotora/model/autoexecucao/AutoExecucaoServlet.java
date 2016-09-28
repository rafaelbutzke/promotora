package br.com.rcbsystens.promotora.model.autoexecucao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AutoExecucaoServlet implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		new AutoExecucao(3600);
		
	}
}
