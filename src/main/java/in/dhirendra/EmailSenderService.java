package in.dhirendra;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderService 
{
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sandMailWithAttachment(String toEmail,
											String body,
											String subject,
											String attachment)throws MessagingException
	{
		MimeMessage maimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(maimeMessage, true);
		
		mimeMessageHelper.setFrom("tanudhirendra@gmail.com");
		mimeMessageHelper.setTo(toEmail);
		mimeMessageHelper.setText(body);
		mimeMessageHelper.setSubject(subject);
		
		FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
		mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
		
		javaMailSender.send(maimeMessage);
		System.out.println("Mail with attachment send sucessfull");
		
	}
}
