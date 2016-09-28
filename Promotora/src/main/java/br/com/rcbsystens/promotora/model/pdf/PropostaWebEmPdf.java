package br.com.rcbsystens.promotora.model.pdf;

import java.io.FileOutputStream;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import br.com.rcbsystens.promotora.model.entidades.DataFormatada;
import br.com.rcbsystens.promotora.model.entidades.NumeroFormatado;
import br.com.rcbsystens.promotora.model.propostaweb.PropostaWeb;

public class PropostaWebEmPdf {
	public void preencher(String arquivo, PropostaWeb proposta) {
		NumeroFormatado numeroFormatado = new NumeroFormatado();
		DataFormatada dataFormatada = new DataFormatada();

		final String ARQUIVO_SAIDA = (System.getProperty("user.home") + "/promotora-tv1/" + arquivo + ".pdf");
		final String TEMPLATE = "/template/proposta_web.pdf";
		try {
			//System.out.println(request.getServletContext().getRealPath("/"));
			FileOutputStream saida = new FileOutputStream(ARQUIVO_SAIDA);
			PdfReader leitor = new PdfReader(
					PropostaWebEmPdf.class.getResourceAsStream(TEMPLATE));
			PdfStamper stamper = new PdfStamper(leitor, saida);
			PdfContentByte over = stamper.getOverContent(1);
			BaseFont bfTextoSimples = BaseFont.createFont();
			// over.drawTextField(60,714,145,729);
			over.beginText();
			over.setFontAndSize(bfTextoSimples, 8);
			if(proposta.getNomeVendedor() != null){
				over.setTextMatrix(398,816);
				over.showText("Vendedor - acesso público, sem vínculo.");
				over.setTextMatrix(398,806);
				over.showText("Nome: "+ proposta.getNomeVendedor().toUpperCase());
			}
			if(proposta.getFoneVendedor()!=null){
				over.setTextMatrix(398,796);
				over.showText("Fone: " + proposta.getFoneVendedor());
			}
			if(proposta.getEmailVendedor()!=null){
				over.setTextMatrix(398,786);
				over.showText("E-mail: " + proposta.getEmailVendedor());
			}
			over.setTextMatrix(65, 718);
			over.showText(proposta.getFabricante());
			over.setTextMatrix(150, 718);
			over.showText(proposta.getModeloVeiculo());
			over.setTextMatrix(323, 718);
			over.showText(proposta.getAno());
			over.setTextMatrix(361, 718);
			over.showText(proposta.getModelo());
			over.setTextMatrix(398, 718);
			over.showText(numeroFormatado.comDuasCasasDecimais(proposta
					.getValorCompra()));
			over.setTextMatrix(474, 718);
			over.showText(numeroFormatado.comDuasCasasDecimais(proposta
					.getValorEntrada()));
			over.setTextMatrix(130, 702);
			over.showText(numeroFormatado.comDuasCasasDecimais(proposta
					.getValorFinanciado()));
			over.setTextMatrix(180, 702);
			over.showText("Plano: " + proposta.getPlano());
			over.setTextMatrix(65, 665);
			over.showText(proposta.getNomeCliente());
			over.setTextMatrix(327, 665);
			over.showText(proposta.getCpfCliente());
			over.setTextMatrix(430, 665);
			over.showText(dataFormatada.DataSemHora(proposta
					.getDataNascimentoCliente()));
			over.setTextMatrix(65, 641);
			over.showText(proposta.getRegistroGeralCliente());
			over.setTextMatrix(167, 641);
			over.showText(proposta.getOrgaoEmissorCliente());
			over.setTextMatrix(269, 641);
			over.showText(proposta.getUfOrgaoEmissorCliente().toString());
			over.setTextMatrix(307, 641);
			over.showText(dataFormatada.DataSemHora(proposta
					.getDataEmissaoCliente()));
			over.setTextMatrix(409, 641);
			over.showText(proposta.getNacionalidadaCliente().toString());
			over.setTextMatrix(65, 618);
			over.showText(proposta.getNaturalidadeCliente());
			over.setTextMatrix(167, 618);
			over.showText(proposta.getUfOrgaoEmissorCliente().toString());
			over.setTextMatrix(205, 618);
			over.showText(proposta.getSexoCliente().toString());
			over.setTextMatrix(273, 618);
			over.showText(proposta.getEstadoCivilCliente().toString());
			over.setTextMatrix(347, 618);
			over.showText(proposta.getEscolaridadeCliente().toString());
			over.setTextMatrix(65, 595);
			over.showText(proposta.getPaiCliente());
			over.setTextMatrix(308, 595);
			over.showText(proposta.getMaeCliente());
			over.setTextMatrix(65, 572);
			over.showText(proposta.getFoneResidencial());
			over.setTextMatrix(158, 572);
			over.showText(proposta.getCelularCliente());
			over.setTextMatrix(249, 572);
			over.showText(proposta.getEmail());
			over.setTextMatrix(65, 549);
			over.showText(proposta.getResCep());
			over.setTextMatrix(130, 549);
			over.showText(proposta.getTipoResidencia().toString());
			over.setTextMatrix(203, 549);
			over.showText(numeroFormatado.comDuasCasasDecimais(proposta
					.getValorAluguel()));
			over.setTextMatrix(278, 549);
			over.showText(dataFormatada.DataSomenteMesAno(proposta
					.getTempoResidencia()));
			over.setTextMatrix(65, 525);
			over.showText(proposta.getResLogradouro());
			over.setTextMatrix(329, 525);
			over.showText(proposta.getResNumero());
			over.setTextMatrix(393, 525);
			over.showText(proposta.getResComplemento());
			over.setTextMatrix(65, 502);
			over.showText(proposta.getResBairro());
			over.setTextMatrix(329, 502);
			over.showText(proposta.getResCidade());
			over.setTextMatrix(430, 502);
			over.showText(proposta.getResUf().toString());
			over.setTextMatrix(65, 469);
			over.showText(proposta.getClassificacaoLocalTrabalho().toString());
			over.setTextMatrix(220, 469);
			over.showText(proposta.getEmpresa());
			over.setTextMatrix(427, 469);
			over.showText(dataFormatada.DataSemHora(proposta.getDataAdmissao()));
			over.setTextMatrix(65, 446);
			over.showText(proposta.getCnpj());
			over.setTextMatrix(167, 446);
			over.showText(proposta.getCargo());
			over.setTextMatrix(311, 446);
			over.showText(numeroFormatado.comDuasCasasDecimais(proposta
					.getSalario()));
			over.setTextMatrix(387, 446);
			over.showText(proposta.getFoneLocalTrabalho());
			over.setTextMatrix(477, 446);
			over.showText(proposta.getComCep());
			over.setTextMatrix(65, 423);
			over.showText(proposta.getComLogradouro());
			over.setTextMatrix(329, 423);
			over.showText(proposta.getComNumero());
			over.setTextMatrix(393, 423);
			over.showText(proposta.getComComplemento());
			over.setTextMatrix(65, 400);
			over.showText(proposta.getComBairro());
			over.setTextMatrix(329, 400);
			over.showText(proposta.getComCidade());
			over.setTextMatrix(430, 400);
			over.showText(proposta.getComUf().toString());
			over.setTextMatrix(65, 377);
			over.showText(proposta.getProvenienteRenda2());
			over.setTextMatrix(479, 377);
			over.showText(numeroFormatado.comDuasCasasDecimais(proposta
					.getRenda2()));
			over.setTextMatrix(65, 344);
			over.showText(proposta.getReferencia1());
			over.setTextMatrix(218, 344);
			over.showText(proposta.getFoneRefencia1());
			over.setTextMatrix(311, 344);
			over.showText(proposta.getReferencia2());
			over.setTextMatrix(462, 344);
			over.showText(proposta.getFoneReferencia2());
			over.setTextMatrix(65, 320);
			over.showText(proposta.getBanco().toString());
			over.setTextMatrix(308, 320);
			over.showText(proposta.getAgencia());
			over.setTextMatrix(350, 320);
			over.showText(proposta.getConta());
			over.setTextMatrix(418, 320);
			over.showText(dataFormatada.DataSomenteMesAno(proposta
					.getAbertura()));
			if (proposta.getNomeConjugue().length() > 3) {
				over.setTextMatrix(65, 289);
				over.showText(proposta.getNomeConjugue());
				over.setTextMatrix(327, 289);
				over.showText(proposta.getCpfConjugue());
				over.setTextMatrix(430, 289);
				over.showText(dataFormatada.DataSemHora(proposta
						.getDataNascimentoConjugue()));
				over.setTextMatrix(65, 265);
				over.showText(proposta.getRegistroGeralConjugue());
				over.setTextMatrix(167, 265);
				over.showText(proposta.getOrgaoEmissorConjugue());
				over.setTextMatrix(269, 265);
				over.showText(proposta.getUfOrgaoEmissorConjugue().toString());
				over.setTextMatrix(307, 265);
				over.showText(dataFormatada.DataSemHora(proposta
						.getDataEmissaoConjugue()));
				over.setTextMatrix(409, 265);
				over.showText(proposta.getNacionalidadaConjugue().toString());
				over.setTextMatrix(65, 242);
				over.showText(proposta.getNaturalidadeConjugue());
				over.setTextMatrix(167, 242);
				over.showText(proposta.getUfNaturalidadeConjugue().toString());
				over.setTextMatrix(205, 242);
				over.showText(proposta.getSexoConjugue().toString());
				over.setTextMatrix(273, 242);
				over.showText(proposta.getEstadoCivilCliente().toString());
				over.setTextMatrix(347, 242);
				over.showText(proposta.getEscolaridadeConjugue().toString());
				over.setTextMatrix(65, 219);
				over.showText(proposta.getPaiConjugue());
				over.setTextMatrix(308, 219);
				over.showText(proposta.getMaeConjugue());
				over.setTextMatrix(65, 196);
				over.showText(proposta.getCelularConjugue());
				over.setTextMatrix(158, 196);
				over.showText(proposta.getEmailConjugue());
				over.setTextMatrix(65, 163);
				over.showText(proposta.getClassificacaoLocalTrabalhoConjugue()
						.toString());
				over.setTextMatrix(220, 163);
				over.showText(proposta.getEmpresaConjugue());
				over.setTextMatrix(427, 163);
				over.showText(dataFormatada.DataSemHora(proposta
						.getDataAdmissaoConjugue()));
				over.setTextMatrix(65, 139);
				over.showText(proposta.getCnpjConjugue());
				over.setTextMatrix(167, 139);
				over.showText(proposta.getCargoConjugue());
				over.setTextMatrix(311, 139);
				over.showText(numeroFormatado.comDuasCasasDecimais(proposta
						.getRenda2Conjugue()));
				over.setTextMatrix(387, 139);
				over.showText(proposta.getFoneLocalTrabalhoConjugue());
				over.setTextMatrix(477, 139);
				over.showText(proposta.getComCepConjugue());
				over.setTextMatrix(65, 116);
				over.showText(proposta.getComLogradouroConjugue());
				over.setTextMatrix(329, 116);
				over.showText(proposta.getComNumeroConjugue());
				over.setTextMatrix(393, 116);
				over.showText(proposta.getComComplementoConjugue());
				over.setTextMatrix(65, 94);
				over.showText(proposta.getComBairroConjugue());
				over.setTextMatrix(329, 94);
				over.showText(proposta.getComCidadeConjugue());
				over.setTextMatrix(430, 94);
				over.showText(proposta.getComUfConjugue().toString());
				over.setTextMatrix(65, 70);
				over.showText(proposta.getProvenienteRenda2Conjugue());
				over.setTextMatrix(479, 70);
				over.showText(numeroFormatado.comDuasCasasDecimais(proposta
						.getRenda2Conjugue()));
				over.setTextMatrix(65, 36);
				over.showText(proposta.getBancoConjugue().toString());
				over.setTextMatrix(308, 36);
				over.showText(proposta.getAgencia());
				over.setTextMatrix(350, 36);
				over.showText(proposta.getContaConjugue());
				over.setTextMatrix(418, 36);
				over.showText(dataFormatada.DataSomenteMesAno(proposta
						.getAberturaConjugue()));
			}
			over.endText();
			over.closePath();
			stamper.close();
			leitor.close();
			saida.close();
			System.out.println("Gerou o pdf...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
