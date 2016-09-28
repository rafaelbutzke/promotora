package br.com.rcbsystens.promotora.model.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
	
	public void enviarEmail(String destinatario, String tilulo, String menssagem) {
		Properties propriedades = new Properties();
		propriedades.put("mail.smtp.host", "smtp.gmail.com");
		propriedades.put("mail.smtp.socketFactory.port", 587);
		propriedades.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		propriedades.put("mail.smtp.auth", true);
		propriedades.put("mail.smtp.starttls.enable", true);
		propriedades.put("mail.smtp.port", 587);
		propriedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session secao = Session.getDefaultInstance(propriedades,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"bbpromotora@gmail.com", "Act2132br");
					}
				});

		secao.setDebug(false);
		try {
			Message email = new MimeMessage(secao);
			try {
				email.setFrom(new InternetAddress("bbpromotora@gmail.com",
						"BB promotora Sistema"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Address[] toUser = InternetAddress.parse(destinatario);
			email.setRecipients(Message.RecipientType.TO, toUser);
			email.setSubject(tilulo);
			// email.setContent(menssagem, "html/text; charset=utf-8");
			email.setText(menssagem);
			Transport.send(email);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}

	public void enviarEmailInterno(String destinatario, String tilulo, String menssagem) {
		Properties propriedades = new Properties();
		propriedades.put("mail.smtp.from", "sistema@rcbsystems.com.br");
		propriedades.put("mail.smtp.host", "192.168.1.100");
		propriedades.put("mail.smtp.port", 587);
		propriedades.put("mail.smtp.auth", true);
		propriedades.put("mail.smtp.socketFactory.port", 587);
		propriedades.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		propriedades.put("mail.smtp.starttls.enable", true);
		propriedades.put("mail.smtp.ssl.trust", "*");
		

		Session secao = Session.getDefaultInstance(propriedades,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"sistema@rcbsystems.com.br", "Rcb916063");
					}
				});

		secao.setDebug(false);
		try {
			Message email = new MimeMessage(secao);
			try {
				email.setFrom(new InternetAddress("sistema@rcbsystems.com.br",
						"BB promotora Sistema"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Address[] toUser = InternetAddress.parse(destinatario);
			email.setRecipients(Message.RecipientType.TO, toUser);
			email.setSubject(tilulo);
			// email.setContent(menssagem, "html/text; charset=utf-8");
			email.setText(menssagem);
			Transport.send(email);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}
	
	public void enviarEmailHtml(String destinatario, String tilulo,
			String menssagem) {
		Properties propriedades = new Properties();
		propriedades.put("mail.smtp.host", "smtp.gmail.com");
		propriedades.put("mail.smtp.socketFactory.port", 587);
		propriedades.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		propriedades.put("mail.smtp.auth", true);
		propriedades.put("mail.smtp.port", 587);
		propriedades.put("mail.smtp.starttls.enable", true);
		propriedades.put("mail.smtp.ssl.trust", "*");

		Session secao = Session.getDefaultInstance(propriedades,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"bbpromotora@gmail.com", "Act2132br");
					}
				});

		secao.setDebug(false);
		try {
			Message email = new MimeMessage(secao);
			try {
				email.setFrom(new InternetAddress("bbpromotora@gmail.com",
						"BB promotora Sistema"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Address[] toUser = InternetAddress.parse(destinatario);
			email.setRecipients(Message.RecipientType.TO, toUser);
			email.setSubject(tilulo);
			email.setContent(menssagem, "text/html; charset=utf-8");
			// email.setText(menssagem);
			Transport.send(email);

		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

	}
//http://javafree.uol.com.br/topic-3982-Enviando-emails-com-arquivo-anexo.html
	public void enviarEmailComArquivo(String destinatario, String tilulo,
			String menssagem, String arquivo){
		Properties propriedades = new Properties();
		propriedades.put("mail.smtp.host", "smtp.gmail.com");
		propriedades.put("mail.smtp.socketFactory.port", 587);
		propriedades.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		propriedades.put("mail.smtp.auth", true);
		propriedades.put("mail.smtp.starttls.enable", true);
		propriedades.put("mail.smtp.port", 587);
		propriedades.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session secao = Session.getDefaultInstance(propriedades,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"bbpromotora@gmail.com", "Act2132br");
					}
				});

		secao.setDebug(false);
		try {
			Message email = new MimeMessage(secao);
			try {
				email.setFrom(new InternetAddress("bbpromotora@gmail.com",
						"BB Promotora Sistema Ltda"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//parte do email menssagem
			MimeMultipart partesEmail = new MimeMultipart();
			MimeBodyPart corpoEmail = new MimeBodyPart();
			corpoEmail.setContent(menssagem, "text/html; charset=utf-8");
			partesEmail.addBodyPart(corpoEmail);
			//parte do email ARQUIVO
			if (arquivo != null && arquivo.length()>2){
				MimeBodyPart anexo = new MimeBodyPart();
				FileDataSource arquivoFile = new FileDataSource(arquivo);
				anexo.setDataHandler(new DataHandler(arquivoFile));
				anexo.setFileName(arquivoFile.getName());
				partesEmail.addBodyPart(anexo);
			}
			Address[] toUser = InternetAddress.parse(destinatario);
			email.setRecipients(Message.RecipientType.TO, toUser);
			email.setSubject(tilulo);
			email.setContent(partesEmail);
			Transport.send(email);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public void enviarEmailComArquivoInterno(String destinatario, String tilulo,
			String menssagem, String arquivo){
		Properties propriedades = new Properties();
		propriedades.put("mail.smtp.from", "sistema@rcbsystems.com.br");
		propriedades.put("mail.smtp.host", "127.0.0.1");
		propriedades.put("mail.smtp.port", 587);
		propriedades.put("mail.smtp.auth", true);
		propriedades.put("mail.smtp.socketFactory.port", 587);
		propriedades.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		propriedades.put("mail.smtp.starttls.enable", true);
		propriedades.put("mail.smtp.ssl.trust", "*");

		Session secao = Session.getDefaultInstance(propriedades,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"sistema@rcbsystems.com.br", "Rcb916063");
					}
				});

		secao.setDebug(false);
		try {
			Message email = new MimeMessage(secao);
			try {
				email.setFrom(new InternetAddress("sistema@rcbsystems.com.br",
						"BB Promotora Sistema Ltda"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//parte do email menssagem
			MimeMultipart partesEmail = new MimeMultipart();
			MimeBodyPart corpoEmail = new MimeBodyPart();
			corpoEmail.setContent(menssagem, "text/html; charset=utf-8");
			partesEmail.addBodyPart(corpoEmail);
			//parte do email ARQUIVO
			if (arquivo != null && arquivo.length()>2){
				MimeBodyPart anexo = new MimeBodyPart();
				FileDataSource arquivoFile = new FileDataSource(arquivo);
				anexo.setDataHandler(new DataHandler(arquivoFile));
				anexo.setFileName(arquivoFile.getName());
				partesEmail.addBodyPart(anexo);
			}
			Address[] toUser = InternetAddress.parse(destinatario);
			email.setRecipients(Message.RecipientType.TO, toUser);
			email.setSubject(tilulo);
			email.setContent(partesEmail);
			Transport.send(email);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}