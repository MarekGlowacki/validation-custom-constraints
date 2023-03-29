package online.javafun.customLimitsAnnotations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ValidationCustomConstraintsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ValidationCustomConstraintsApplication.class, args);
        EmailMessage emailMessage = new EmailMessage(
                "abc@abc.com",
                "xyz@xyz.com",
                "Hejo! Co tam kurde u Ciebie słychać wariacie? Pozdro"
        );
        EmailService emailService = context.getBean(EmailService.class);
        emailService.sendMessage(emailMessage);
    }

}
