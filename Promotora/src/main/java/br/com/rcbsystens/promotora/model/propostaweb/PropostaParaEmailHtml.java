package br.com.rcbsystens.promotora.model.propostaweb;


public class PropostaParaEmailHtml {

	public String PropostaEmHtml(PropostaWeb proposta){
		StringBuffer propostaHtml = new StringBuffer();
		propostaHtml.append("<!DOCTYPE html>");
		propostaHtml.append("<html>");
		propostaHtml.append("<body>");
		propostaHtml.append("<tbody>");
		propostaHtml.append("<tr>");
		propostaHtml.append("<td><label>Fabricante: </label></td>");
		propostaHtml.append("</tr>"); 
		propostaHtml.append("<tr>");
		propostaHtml.append("<dd>" + proposta.getFabricante()+"</dd>");
		propostaHtml.append("</tr>");
		propostaHtml.append("</tbody>");
		propostaHtml.append("</body>");
		propostaHtml.append("</html>");
		String menssagem = new String(propostaHtml.toString());
		return menssagem; 

	}
	
				
						
						
						
						
		/*				
						<p:outputLabel value="Valor Entrada:" />
						<p:inputText id="fabricante"
							value="#{propostaBean.proposta.fabricante}"
							styleClass="fabricante" required="true" > 
							<f:validateLength minimum="2" />
							<p:ajax event="blur" update="fabricante,:formulario:menssagem">
								<f:validator validatorId="fabricante" />
							</p:ajax>
						</p:inputText>
						<p:inputText id="modeloVeiculo"
							value="#{propostaBean.proposta.modeloVeiculo}"
							styleClass="veiculo" />
						<p:inputMask id="ano" value="#{propostaBean.proposta.ano}"
							styleClass="anoModelo" mask="9999" />
						<p:inputMask id="modelo" value="#{propostaBean.proposta.modelo}"
							styleClass="anoModelo" mask="9999" />
						<p:inputText id="valorCompra"
							value="#{propostaBean.proposta.valorCompra}" styleClass="dinheiro">
							<f:convertNumber pattern="#,###,###,##0.00" minFractionDigits="2" />
							<p:ajax update="valorCompra" event="change" />
						</p:inputText>
						<p:inputText id="valorEntrada"
							value="#{propostaBean.proposta.valorEntrada}"
							styleClass="dinheiro">
							<f:convertNumber pattern="#,###,###,##0.00" minFractionDigits="2" />
							<p:ajax listener="#{propostaBean.calculaValorFinanciado}"
								update="valorCompra,valorEntrada,valorFinanciado,plano24,plano36,plano48,parcelas24,parcelas36,parcelas48" event="change"
								process="@this" />
						</p:inputText>
						<p:outputLabel value="Valor financiado: " />
						<p:outputLabel id="valorFinanciado"
							value="#{propostaBean.proposta.valorFinanciado}">
							<f:convertNumber pattern="#,###,###,##0.00" minFractionDigits="2" />
						</p:outputLabel>
			</h:panelGrid>
		</h:form>
	</h:body>
	</html>
	*/

}
