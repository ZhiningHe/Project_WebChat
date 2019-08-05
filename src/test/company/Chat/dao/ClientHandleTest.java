package company.Chat.dao;

import company.Chat.User;
import org.junit.Assert;
import org.junit.Test;

public class ClientHandleTest {
    private ClientHandle ClientHandle = new ClientHandle();
    @Test
    public void client_loading() {
        User user = ClientHandle.Client_loading("test","123");
        System.out.println(user);
        Assert.assertNotNull(user);
    }

    @Test
    public void client_register() {
        User user = new User();
        user.setUserName("test");
        user.setPassword("123");
        ClientHandle.Client_register(user);
    }

    @Test
    public void client_register1() {
    }
}