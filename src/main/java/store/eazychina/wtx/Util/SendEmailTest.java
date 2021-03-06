package store.eazychina.wtx.Util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.naming.factory.SendMailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

public class SendEmailTest {
	private static Log log = LogFactory.getLog(SendMailFactory.class);
	 
    @Autowired
    JavaMailSenderImpl javaMailSender;
 
    @Value("${mail.subject}")
    String subject;
    @Value("${mail.sendText}")
    String sendText;
 
    @Scheduled(cron = "*/5 * * * * ?")
    public void timingSendMail() {
        log.info("");
 
//        javaMailSender.send(new SendMailUtil().sendIdentifyingCode(subject, sendText, sendText));
    }

}
