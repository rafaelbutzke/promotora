package br.com.rcbsystens.promotora.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.rcbsystens.promotora.model.imutaveis.Estados;
import br.com.rcbsystens.promotora.model.entidades.enderecos.Enderecos;

public class CepDao {
	
	private Connection conexao; 
	
	public CepDao(){
		try {
			this.conexao = new FabricaConexao().getConnection();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public CepDao(Connection conexao){
		this.conexao = conexao;
	}
	
	public Enderecos Consulta(String cep) {
		Enderecos end = new Enderecos();
		try {
			
			String cep2 = cep.replace("-", "");
			String sql = ("select Cep, Tipo_logradouro, Logradouro, bairro, cidade, uf from cepbr_endereco, cepbr_bairro, cepbr_cidade where cepbr_endereco.id_bairro = cepbr_bairro.id_bairro and cepbr_endereco.id_cidade = cepbr_cidade.id_cidade and cep like '" + cep2 + "%'");
			PreparedStatement consulta = this.conexao.prepareStatement(sql);
			ResultSet resultadoConsulta = consulta.executeQuery();
			while(resultadoConsulta.next()){
	  			end.setLogradouro(resultadoConsulta.getString("Tipo_logradouro") + " " +resultadoConsulta.getString("Logradouro"));
	  			end.setBairro(resultadoConsulta.getString("bairro"));
	  			end.setCidade(resultadoConsulta.getString("cidade"));
	  			end.setEstado(Estados.valueOf(resultadoConsulta.getString("uf"))); 
	  			end.setCep(resultadoConsulta.getString("Cep"));
			}
			resultadoConsulta.close();
			consulta.close();
			
			if (end.getLogradouro() == null) {
				FacesContext context1 = FacesContext.getCurrentInstance();
				context1.addMessage(
						null,
						new FacesMessage(
								FacesMessage.SEVERITY_WARN,
								"CEP: " + cep,
								"Não localizado!!! Não impede de você continuar, mas cadastre seu endereco com os mínimos detalhes."));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return end; 
	} 
}
