package com.freshshop.service;


import com.freshshop.model.Customer;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;



@Service
public class MailService {
	@Autowired
	JavaMailSender sender;

	public void sendEmail(Customer customer, String emailFrom, String emailTo) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		// Sử dụng Helper để thiết lập các thông tin cần thiết cho message
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		String subject  = "Fresh shop - Recovery password /n ";
		String content = "<html>"
				+ "<head>"
				+ "<style>"
				+ "body { font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif; color: #333333; line-height: 1.5; margin: 0; padding: 0; }"
				+ ".container { max-width: 600px; margin: 0 auto; padding: 20px; }"
				+ "h1 { font-size: 24px; margin-bottom: 20px; }"
				+ "p { font-size: 16px; margin-bottom: 10px; }"
				+ "strong { color: #000000; font-weight: bold; }"
				+ "</style>"
				+ "</head>"
				+ "<body>"
				+ "<div class='container'>"
				+ "<h1>Welcome, " + customer.getCustomerName() + "!</h1>"
				+ "<p>Thank you for joining our website. We have generated a new password for you:</p>"
				+ "<p><strong>" + customer.getConfirmPwd() + "</strong></p>"
				+ "<p>Please keep this password confidential and ensure its security.</p>"
				+ "<p>If you did not request a password reset, please contact our support team immediately.</p>"
				+ "<p>Best regards,</p>"
				+ "<p>Fresh Shop Team</p>"
				+ "</div>"
				+ "</body>"
				+ "</html>";

		helper.setFrom(emailFrom);
		helper.setTo(emailTo);
		helper.setSubject(subject);
		helper.setText(content, true);
		helper.setReplyTo(emailFrom);
		// Gửi message đến SMTP server
		sender.send(message);
	}


}
