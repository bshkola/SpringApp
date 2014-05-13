package pw.bshkola.mail;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import pw.bshkola.model.Category;

@Service("mailService")
public class MailService implements Mail{

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public void sendAddingCategoryConfirmation(final Category category) {
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
				message.setTo("twist093@gmail.com");
				message.setFrom(messageSource.getMessage("email.address", null, Locale.getDefault()), 
						messageSource.getMessage("email.personal", null, Locale.getDefault()));
				message.setSubject(messageSource.getMessage("email.addingCategory", null, Locale.getDefault()));
				Map<String, Object> model = new HashMap<String, Object>();
				model.put("category", category);
				
				String text = "New category + " + category.getName() + " has been created.";
				message.setText(text, true);
			}
		};
		
		MimeMessagePreparator[] messages = { preparator };
		mailSender.send(messages);
	}
	
}
