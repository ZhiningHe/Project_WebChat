package Controller;

import service.ServiceHandle;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//注册
@WebServlet(urlPatterns = "/doRegister")
public class RegistController extends HttpServlet {
    private ServiceHandle serviceHandle = new ServiceHandle();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("check");
        String truecheckCode = (String) req.getSession().getAttribute("check");
        System.out.println(checkCode+"、"+truecheckCode);
        System.out.println(userName+"、"+password);
        //设置界面是text/html格式，字符集是utf-8
        resp.setContentType("text/html;charset=utf8");
        //获取对页面的输出流
        PrintWriter writer = resp.getWriter();
        if (!checkCode.equals(truecheckCode)){
            //验证码不正确
            req.getSession().removeAttribute(checkCode);
            writer.println("<script>\n" +
                    "alert(\"验证码不正确！\");\n" +
                    "window.location.href = \"/registration.html\";\n" +
                    "</script>");
            //重定向
            //req.getRequestDispatcher("registration.html").forward(req, resp);
        }

        if (serviceHandle.service_register(userName,password)) {
            // 用户注册成功，弹框提示，返回登陆界面
            writer.println("<script>\n" +
                    "alert(\"注册成功\");\n" +
                    "window.location.href = \"/index.html\";\n" +
                    "</script>");
        }else {
            // 弹框提示失败，保留原页面
            writer.println("<script>\n" +
                    "alert(\"注册失败\");\n" +
                    "window.location.href = \"/registration.html\";\n" +
                    "</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
