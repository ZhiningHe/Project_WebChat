package company.Chat.config;
import	java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import freemarker.template.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听器
 * 项目一启动就tomcat会调用这个方法
 * 马上终止的时候，也会调用
 *
 * */

@WebListener
public class FreeMarkerListener implements ServletContextListener {
    public static final String KEY = "_template_";

    //创建的时候回调
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 配置的版本
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
        // 配置加载ftl的路径
        try {
            ///usr/local/tomcat/apache-tomcat-9.0.22/webapps/ROOT
            //D:\ZhiningHe\GitHub\ZhiNing___\Project_WebChat\src\main\webapp
            cfg.setDirectoryForTemplateLoading(
                    new File("/usr/local/tomcat/apache-tomcat-9.0.22/webapps/ROOT"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 配置页面编码
        cfg.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
        sce.getServletContext().setAttribute(KEY,cfg);
    }

    //销毁之前回调
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
