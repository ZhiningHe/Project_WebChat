package Controller;

import	java.util.HashMap;

import Config.FreeMarkerListener;
import Utils.CommUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import service.ServiceHandle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;


/**
 * 登陆
 */
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private ServiceHandle serviceHandle = new ServiceHandle();
    //已经登陆的用户
    public static CopyOnWriteArraySet<String> loaded = new CopyOnWriteArraySet<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html;charset=utf8");
        PrintWriter out = resp.getWriter();
        if (CommUtil.strIsNull(userName) || CommUtil.strIsNull(password)) {
            // 登录失败,停留登录页面
            out.println("    <script>\n" +
                    "        alert(\"用户名或密码为空!\");\n" +
                    "        window.location.href = \"/index.html\";\n" +
                    "    </script>");
        }
        if (serviceHandle.service_loading(userName,password)) {
            //还未登陆
            if (!loaded.contains(userName)) {
                // 登录成功,跳转到聊天页面
                // 拿到聊天记录
                loaded.add(userName);
                Template template = getTemplate(req, "/chat.ftl");
                Map<String, String> map = new HashMap<>();
                map.put("username", userName);
                try {
                    template.process(map, out);
                } catch (TemplateException e) {
                    e.printStackTrace();
                }
            }else{
                out.println("    <script>\n" +
                        "        alert(\"该用户已经在别地登陆!\");\n" +
                        "        window.location.href = \"/index.html\";\n" +
                        "    </script>");
            }
        }else {
            // 登录失败,停留在登录页面
            out.println("    <script>\n" +
                    "        alert(\"用户名或密码不正确!\");\n" +
                    "        window.location.href = \"/index.html\";\n" +
                    "    </script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private Template getTemplate(HttpServletRequest req,String fileName) {
        Configuration cfg = (Configuration)
                req.getServletContext().getAttribute(FreeMarkerListener.TEMPLATE_KEY);
        try {
            return cfg.getTemplate(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

