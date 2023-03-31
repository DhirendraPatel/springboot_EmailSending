package in.dhirendra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class EmailSendingApp1Application {
	
	
	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		
		SpringApplication.run(EmailSendingApp1Application.class, args);
	}
	
		@EventListener(ApplicationReadyEvent.class)
		public void triggerMail() throws MessagingException
		{
			emailSenderService.sandMailWithAttachment("tdhirendra1997@gmail.com",
					"This is body",
					"This is Email attachment.",
					"C:\\Users\\Public\\Dhirendra.pdf");
		}
}
