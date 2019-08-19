package chat.Service;

import org.junit.Test;
import service.ServiceHandle;

public class ServiceHandleTest {

    @Test
    public void service_loading() {
        ServiceHandle serviceHandle = new ServiceHandle();
        boolean issuccess = serviceHandle.service_loading("test10","123");
        System.out.println(issuccess);
    }

    @Test
    public void service_register() {
        ServiceHandle serviceHandle = new ServiceHandle();
        boolean issuccess = serviceHandle.service_register("test10","123");
        System.out.println(issuccess);
    }
}