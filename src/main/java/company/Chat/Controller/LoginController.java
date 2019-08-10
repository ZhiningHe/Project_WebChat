package company.Chat.Controller;
import	java.util.HashMap;


import company.Chat.Service.ServiceHandle;
import company.Chat.Utils.CommUtil;
import company.Chat.config.FreeMarkerListener;
import company.Chat.dao.BaseDao;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 服务端通过对dao层封装，对浏览器不同的做法的返回
 * 控制下一步返回给浏览器的内容
 */

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    private ServiceHandle serviceHandle = new ServiceHandle();
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
            // 登录成功,跳转到聊天页面chat.ftl
            //template相当于全局常量
            Template template = getTemplate(req,"/chat.ftl");
            Map<String, String> map = new HashMap<>();
            map.put("username",userName);
            try {
                //把map（username）传到前端去
                template.process(map, out);
            } catch (TemplateException e) {
                e.printStackTrace();
            }
        } else {
            // 登录失败,停留在登录页面
            out.println("    <script>\n" +
                    "        alert(\"用户名或密码不正确,或者在其他地方已经登陆~\");\n" +
                    "        window.location.href = \"/index.html\";\n" +
                    "    </script>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    //传入跳转前页面的信息 和要加载的ftl路径
    //获取ftl（全局对象）监听器
    private Template getTemplate(HttpServletRequest req,String fileName) {
        Configuration cfg = (Configuration)
                req.getServletContext().getAttribute(FreeMarkerListener.KEY);
        try {
            return cfg.getTemplate(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
