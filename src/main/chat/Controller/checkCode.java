package Controller;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;



//验证码
@WebServlet(urlPatterns = "/checkCode")
public class checkCode extends HttpServlet {
    int width = 100;
    int height = 50;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建对象，图片
        BufferedImage image = new BufferedImage(width,height,1);
        //美化图片
        Graphics g = image.getGraphics();//画笔
        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);
        //边框
        g.setColor(Color.gray);
        g.drawRect(0,0,width-1,height-1);
        //写验证码
        String str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
        Random ran = new Random();
        String thisstr = null;
        for (int i=1; i<=4; i++){
            int index = ran.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);
            thisstr += ch;
            g.drawString(ch+"",width/5*i,height/2);
        }

        Cookie cookie = new Cookie("checkCode",thisstr);

        //画干扰线
        g.setColor(Color.ORANGE);
        for (int i=0; i<10; i++){
            int x1=ran.nextInt(width);
            int x2=ran.nextInt(width);
            int y1=ran.nextInt(height);
            int y2=ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);

        }
        //图片输出到页面
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }
}
