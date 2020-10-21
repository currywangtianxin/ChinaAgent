package store.eazychina.wtx.service.checkCode;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/codeBuilder")
public class CheckCodeServlet extends HttpServlet {
@Override
public void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("image/jpg");

	// ���
	int width = 80;
	int height = 40;

	// ����һ��ͼƬ����d 
	BufferedImage img = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);

	// ��ȡ����,������
	Graphics2D graphic = img.createGraphics();
	// ������ɫ
	graphic.setColor(Color.white);
	// x��y���Ǵ�0 ��ʼ ȫ�����ɰ�ɫ
	graphic.fillRect(0, 0, width, height);

	// ������ɫ
	graphic.setColor(Color.BLACK);
	// ���߿�
//	graphic.drawRect(0, 0, width, height);

	// �����������
	// ����,�Ӵ�б��,�����С
	Font font = new Font("����", Font.BOLD + Font.ITALIC,
			(int) (height * 0.8));
	// �������õ�������
	graphic.setFont(font);
	String code = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";

	// ����� �������4����ĸ
	int num = 4;
	Random random = new Random();
	StringBuilder codeBuilder = new StringBuilder();
	for (int i = 0; i < num; i++) {
		int index = random.nextInt(code.length());
		char value = code.charAt(index);
		codeBuilder.append(value);
	}
	// System.out.println(codeBuilder.toString());

	String checkcode = codeBuilder.toString();


	// ������ɵ���֤��
	//session������֤��,ÿ��ˢ��,������������һ����֤�벢����
		HttpSession session=request.getSession();
		session.setAttribute("count",checkcode );
		
		
		
		
	// ѭ����������,��ɫ���
	for (int i = 0; i < num; i++) {
		 graphic.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		 // �� ��֤��ÿһ���ó���,����д��
		 String c = checkcode.charAt(i)+"";
		 // ��������,���Ը��� ����߶ȵ�1/3 
		 // ���� �� 150  �����y��(����������) ����Ϊ 100 ~ 150  ���ǿ��Ե�
		 graphic.drawString(c, i*(width/num), height-(random.nextInt(height/3)));
	}

	// ������
	for (int i = 0; i < (width+height)*2; i++) {
		 graphic.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		 
		 // �����
		 graphic.drawOval(random.nextInt(width), random.nextInt(height), 1, 1);
	}
	
	// ��Ӹ�����
	for (int i = 0; i < 4; i++) {
		 graphic.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		 // x1Ϊx����ʼ
		 // y1��y����ʼ
		 // x1Ϊ0 y1�߶����, ˵�� ��� ����߿��ϵ�����λ��
		 graphic.drawLine(0, random.nextInt(height), width, random.nextInt(height));
	}
	
	// ����ͼƬ
	OutputStream os = response.getOutputStream();
	ImageIO.write(img, "jpg", os);
//	request.getRequestDispatcher("CherkServlet").forward(request,response);

}
}
