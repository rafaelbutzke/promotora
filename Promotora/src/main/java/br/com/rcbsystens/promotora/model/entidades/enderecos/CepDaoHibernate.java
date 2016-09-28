package br.com.rcbsystens.promotora.model.entidades.enderecos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import br.com.rcbsystens.promotora.model.imutaveis.Estados;

public class CepDaoHibernate implements CepDao {

	private Session sessao;

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public Enderecos Consulta(String cep) {
		// TODO Auto-generated method stub
		Enderecos end = new Enderecos();
		try {
			String cep2 = cep.replace("-", "");
			String sql = ("select Cep, Tipo_logradouro, Logradouro, bairro, cidade, uf from cepbr_endereco, cepbr_bairro, cepbr_cidade where cepbr_endereco.id_bairro = cepbr_bairro.id_bairro and cepbr_endereco.id_cidade = cepbr_cidade.id_cidade and cep like '" + cep2 + "%'");
			// PreparedStatement consulta = this.conexao.prepareStatement(sql);
			// ResultSet resultadoConsulta = consulta.executeQuery();
			 SQLQuery query = this.sessao.createSQLQuery(sql);
			 query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			 List<> resultadoConsulta = query.list();
			
			while (resultadoConsulta.next()) {
				end.setLogradouro(resultadoConsulta.getString("Tipo_logradouro") + " " + resultadoConsulta.getString("Logradouro"));
				end.setBairro(resultadoConsulta.getString("bairro"));
				end.setCidade(resultadoConsulta.getString("cidade"));
				end.setEstado(Estados.valueOf(resultadoConsulta.getString("uf")));
				end.setCep(resultadoConsulta.getString("Cep"));
			}
			resultadoConsulta.close();
			consulta.close();

			if (end.getLogradouro() == null) {
				FacesContext context1 = FacesContext.getCurrentInstance();
				context1.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "CEP: " + cep, "Não localizado!!! Não impede de você continuar, mas cadastre seu endereco com os mínimos detalhes."));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return end;
	}
}
