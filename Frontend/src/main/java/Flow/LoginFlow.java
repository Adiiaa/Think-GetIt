package Flow;

import com.microsoft.playwright.Page;
import pages.LoginPage;

public class LoginFlow {
    private LoginPage loginPage;
    private Page page;

    public LoginFlow(Page page){
        this.page = page;
        loginPage = new LoginPage(page);
    }

    public void loginSuccessful(){
        loginPage.login("admin@thinkandgetit.com", "Admin@123456");
    }

    public void loginWithWrongPassword(){
        loginPage.login("admin@thinkandgetit.com", "wrongPassword123");
    }

    public void loginWithWrongEmail(){
        loginPage.login("wrongEmail", "Admin@123456");
    }

    public void loginWithEmptyEmail(){
        loginPage.login("", "Admin@123456");
    }

    public void loginWithEmptyPassword(){
        loginPage.login("admin@thinkandgetit.com", "");
    }

    public boolean isLoginSuccessful(){
        page.waitForURL("https://think-and-get-it-frontend.onrender.com/home");
        System.out.println("Current Url: " + page.url());
        return page.url().contains("home");
    }

    public boolean isLoginFailed(){
        return page.url().contains("login");
    }
}
