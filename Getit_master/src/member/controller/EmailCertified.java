package member.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;

import member.model.service.MemberService;

/**
 * Servlet implementation class EmailCertified
 */
@WebServlet("/email/certified")
public class EmailCertified extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberservice;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailCertified() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("name");
		String authNum = "";
		
		authNum = RandomNum();
		
		sendEmail(email, authNum);
		
		request.setAttribute("email", email);
		request.setAttribute("authNum", authNum);
		request.getRequestDispatcher("/WEB-INF/views/member/emailCertified.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
	public String RandomNum() {
		StringBuffer buffer = new StringBuffer();
		
		for (int i=0;i<=6;i++) {
			int n = (int)(Math.random()*10);
			buffer.append(n);
		}
		return buffer.toString();
	}
	
	
	
	public void sendEmail(String email, String authNum) {
		String host = "smtp.gmail.com";
		String subject = "Assemble 회원가입 인증번호";
		String fromName = "Assemble 관리자";
		String from = "KHassemble@gmail.com";
		String to1 = email;
		
		String content = "Assemble 회원가입 인증번호 ["+authNum+"]";
		
		try {
			Properties p = new Properties();
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.transport.protocol", "smtp");
			p.put("mail.smtp.host", host);
			p.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.put("mail.smtp.port", "465");
			p.put("mail.smtp.user", from);
			p.put("mail.smtp.auth", "true");
			
			Session mailSession = Session.getInstance(p, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("KHassemble", "getit1234"); // 관리자의 gmail 아이디, 비밀번호
				}
			});
			
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName, "UTF-8", "B")));
			InternetAddress[] address1 = {new InternetAddress(to1)};
			msg.setRecipients(Message.RecipientType.TO, address1);
			msg.setSubject(subject);
			msg.setSentDate(new java.util.Date());
			msg.setContent(content, "text/html;charset=UTF-8");
			
			Transport.send(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
