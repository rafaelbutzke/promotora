package br.com.rcbsystens.promotora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = new FabricaConexao().getConnection();
		System.out.println("Conexao aberta!!!");
		String consultaVazia = null;
		String cep = new String("71250025");
		String sql = ("select Cep, Tipo_logradouro, Logradouro, bairro, cidade, uf from cepbr_endereco, cepbr_bairro, cepbr_cidade where cepbr_endereco.id_bairro = cepbr_bairro.id_bairro and cepbr_endereco.id_cidade = cepbr_cidade.id_cidade and cep like '" +cep+ "%'");
		System.out.println(sql);
		PreparedStatement consulta = con.prepareStatement(sql);
		ResultSet resultadoConsulta = consulta.executeQuery();
		while (resultadoConsulta.next()){
			consultaVazia = "1";
			System.out.print(resultadoConsulta.getString("Cep")+ " ");
			System.out.print(resultadoConsulta.getString("Tipo_logradouro")+ " ");
			System.out.print(resultadoConsulta.getString("Logradouro")+" ");
			System.out.print(resultadoConsulta.getString("bairro")+" ");
			System.out.print(resultadoConsulta.getString("cidade")+ " ");
			System.out.print(resultadoConsulta.getString("uf"));
			System.out.print("\n");
		}
		if (consultaVazia==null) {
			System.out.println("CEP não encontrado!!!");
		}
		resultadoConsulta.close();
		consulta.close();
		con.close();
		System.out.println("Fim da consulta");
	}

}
