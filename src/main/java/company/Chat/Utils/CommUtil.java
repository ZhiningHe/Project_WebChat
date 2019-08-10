package company.Chat.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * json的序列化
 */
public class CommUtil {
    //gson的对象存储一行序列化信息
    private static final Gson gson = new GsonBuilder().create();

    private CommUtil() {
    }

    //根据指定文件名获取配置文件
    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        // 获取当前配置文件夹下的文件输入流
        InputStream in = CommUtil.class.getClassLoader()
                .getResourceAsStream(fileName);//获取全部文件
        // 加载配置文件中的所有内容
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String object2Json(Object obj) {
        return gson.toJson(obj);
    }
    public static Object json2Object(String jsonStr, Class objClass) {
        return gson.fromJson(jsonStr, objClass);
    }

    public static boolean strIsNull(String str) {
        return str == null || str.equals("");
    }
}

