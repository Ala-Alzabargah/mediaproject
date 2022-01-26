package shahid.api

import javax.mail.*
import javax.mail.Authenticator
import javax.mail.PasswordAuthentication
import javax.mail.internet.*

import com.kms.katalon.core.annotation.Keyword

import internal.GlobalVariable as GlobalVariable



public class SMTPAuthenticator extends Authenticator {
	public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(GlobalVariable.fromEmail,GlobalVariable.emailPassword);
	}
}


class sendEmail {


	@Keyword
	def public void sendMailByGroovy() {

		def
				d_host = "smtp.gmail.com",
		d_port  = "587", //465,587
		m_subject = "Shahid Check Media Services",
		m_text = "Hey, this is the testing email."

		def props = new Properties()
		props.put("mail.smtp.user", GlobalVariable.fromEmail)
		props.put("mail.smtp.host", d_host)
		props.put("mail.smtp.port", d_port)
		props.put("mail.smtp.starttls.enable","true")
		props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.auth", "true")
		props.put("mail.smtp.socketFactory.port", d_port)
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
		props.put("mail.smtp.socketFactory.fallback", "false")

		def auth = new SMTPAuthenticator()
		println "+++++*****auth::: "+auth
		def session = Session.getInstance(props, auth)
		session.setDebug(true);

		def msg = new MimeMessage(session)
		msg.setText(m_text)
		msg.setSubject(m_subject)
		msg.setFrom(new InternetAddress(GlobalVariable.fromEmail))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("abawad@mbc.net"))
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Mujahed.Abuabdo@Shahid.net"))
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Ala.Alzabargah@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("ahmad.najjar@mbc.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Anas.Ajlouni@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Mohammad.Mango@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Walid.Alnadi@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Ahed.Habahbeh@mbc.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Hadeel.Shawabkeh@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Salsabeel.Jaafreh@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Fouad.Ghandour@shahid.net"))
		//
		//		//****** Devops *****
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Abdallah.Arabyat@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Ahmad.Alasal@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Ahmad.Marie@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Ahmad.Qubbaj@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Alaa.AlKhdarat@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Ehab.AlKhashman@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Esraa.Albarqat@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Murad.Almomani@shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Musab.Zayadneh@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Zaid.Safadi@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Ala.Qasem@Shahid.net"))
		//
		//		//****** Payment *****
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Ahmad.Natsheh@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Amro.Amro@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Mahmoud.Mousa@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Majd.Alhyari@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Mohammad.Abulawi@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Mohammad.Alameer@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Nermeen.Altaher@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Omar.Shqair@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Rana.Alami@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Sarah.Dedan@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Shojaa.Mahmoud@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Waleed.Alabed@Shahid.net"))
		//
		//		//******* QA Team ******
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Alma.Albarghouthi@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Ashraf.Qouzah@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Bader.Bader@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Bara.Issa@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Basil.Almasri@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Dina.Ibdah@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Fatima.Alhanbali@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Fatima.Alzreiqat@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Ibrahim.Alhayek@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Malek.Ismail@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Marwa.Otaibi@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Mohammad.Mango@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Nahwa.Shaqour@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Rula.Iblasi@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Salma.AlMousa@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Suhel.Abboud@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Tala.Alnaber@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Feras.Asfour@Shahid.net"))
		//		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("Mohammad.Salah@Shahid.net"))

		msg.setContent( new emailTemplate().createTemplate(), "text/html")


		Transport transport = session.getTransport("smtps");
		transport.connect(d_host, GlobalVariable.fromEmail, GlobalVariable.emailPassword);
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();

	}
}