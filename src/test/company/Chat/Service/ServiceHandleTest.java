package company.Chat.Service;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceHandleTest {

    @Test
    public void service_loading() {
        ServiceHandle serviceHandle = new ServiceHandle();
        boolean issuccess = serviceHandle.service_loading("test","123");
        System.out.println(issuccess);
    }

    @Test
    public void service_register() {
        ServiceHandle serviceHandle = new ServiceHandle();
        boolean issuccess = serviceHandle.service_register("test1","123");
        System.out.println(issuccess);
    }
}