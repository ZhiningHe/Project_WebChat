package company.Chat.Utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommUtilTest {

    @Test
    public void loadProperties() {
        System.out.println(CommUtil.loadProperties("datasource.properties"));
    }
}