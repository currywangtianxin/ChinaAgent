package store.eazychina.wtx.Util;
import org.springframework.mail.SimpleMailMessage;

public class SendMailUtil {

	 
    /**
    * Description �ʼ������Զ��巽��
    * @author WEIQI
    * @param subject �ʼ�����
    * @param text  �ʼ�����
    * @createDate 2019/6/14 17:03
    **/
    public SimpleMailMessage sendIdentifyingCode(String subject, String text,String email) {
        
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
 
        simpleMailMessage.setFrom("2537156207@qq.com");
        simpleMailMessage.setTo(email);
 
        return simpleMailMessage;
}
}