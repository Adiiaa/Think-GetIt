package Authentication;

import Base.BaseTest;
import Flow.LoginFlow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    @Test
    void testLogin(){
        LoginFlow loginFlow = new LoginFlow(page);
        loginFlow.loginSuccessful();
        Assertions.assertTrue(loginFlow.isLoginSuccessful());
    }

    @Test
    void testInvalidPassword(){
        LoginFlow loginFlow = new LoginFlow(page);
        loginFlow.loginWithWrongPassword();
        Assertions.assertTrue(loginFlow.isLoginFailed());
    }

    @Test
    void testInvalidEmail(){
        LoginFlow loginFlow = new LoginFlow(page);
        loginFlow.loginWithWrongEmail();
        Assertions.assertTrue(loginFlow.isLoginFailed());
    }
    @Test
    void testEmptyEmail(){
        LoginFlow loginFlow = new LoginFlow(page);
        loginFlow.loginWithEmptyEmail();
        Assertions.assertTrue(loginFlow.isLoginFailed());
    }
    @Test
    void testEmptyPassword(){
        LoginFlow loginFlow = new LoginFlow(page);
        loginFlow.loginWithEmptyPassword();
        Assertions.assertTrue(loginFlow.isLoginFailed());
    }
}
