package br.com.rcbsystens.promotora.model.dao.hibernate;

import org.hibernate.Session;

public class ConectaHibernateMysql {
	public static void main(String[] args) {
		Session sessao = null;
		sessao = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Conectou!");
		sessao.close();
	}
}
