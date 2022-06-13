<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mailFrom.Java Mailing</title>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.activation.*"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.mail.*"%>
<%@ page import="javax.mail.internet.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sender = request.getParameter("sender");
	String receiver = request.getParameter("receiver");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String server = "imap.gmail.com";//메일서버 주소
	String port = "465"; // 메일서버 포트 (일반:25)
	Properties properties = new Properties();
	properties.put("mail.smtp.host", server);
	properties.put("mail.smtp.port", port);
	properties.put("mail.smtp.starttls.enable", "true");
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.debug", "true");
	properties.put("mail.smtp.socketFactory.port", port);
	properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	properties.put("mail.smtp.socketFactory.fallback", "false");
	try {
		Session s = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("lacanchea","비번");
			} // Lacanchea 는  구글 ID입니다. 
		});
		Message message = new MimeMessage(s);
		Address sender_address = new InternetAddress(sender);
		Address receiver_address = new InternetAddress(receiver);
		message.setHeader("content-type", "text/html;charset=UTF-8");
		message.setFrom(sender_address);//보내는 사람 정보
		message.addRecipient(Message.RecipientType.TO, receiver_address);//받는 사람정보
		message.setSubject(subject);
		message.setContent(content, "text/html;charset=UTF-8");
		message.setSentDate(new java.util.Date());
		Transport.send(message, message.getAllRecipients());
		out.print("정상적으로 발송되었습니다.");
	} catch (Exception e) {
		e.printStackTrace();
		out.println("SMTP 서버가 잘못 설정되었거나, 서비스에 문제가 있습니다.");
	}
%>
</head>
<body>
<form action="mailSend.jsp" method="post" name="frm" >
	<table border="1" width="450">
		<tr>
			<td colspan="2"> Java Mailing </td>
		</tr>
		<tr>
			<td>보낸 사람 메일 : </td>
			<td><input type="text" name ="sender" /> </td>
		</tr>
		<tr>
			<td>받는 사람 메일 : </td>
			<td><input type="text" name ="receiver" /> </td>
		</tr>
		<tr>
			<td>죄 목 : </td>
			<td><input type="text" name ="subject" /></td>
		</tr>
		<tr>
			<td>내 용 : </td>
			<td><textarea rows="20" cols="40" name="content"></textarea ></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value ="저세상보내기"/> 
			</td>
		</tr>
	</table>
</form>

</body>

</html>

