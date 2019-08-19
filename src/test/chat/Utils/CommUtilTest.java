package chat.Utils;

import Utils.CommUtil;
import org.junit.Test;

public class CommUtilTest {

    @Test
    public void loadProperties() {
        System.out.println(CommUtil.loadProperties("datasource.properties"));
    }
}