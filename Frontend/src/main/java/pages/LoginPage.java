package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    private final Locator signInButton;
    private final Locator emailField;
    private final Locator passwordField;
    private final Locator submitButton;

    public LoginPage(Page page){
        this.page = page;
        this.signInButton = page.locator("a[href='/login']");
        this.emailField = page.getByPlaceholder("you@example.com");
        this.passwordField = page.getByPlaceholder("••••••••");
        this.submitButton = page.locator("button[type='submit']");
    }

    public void clickSigninButton(){
        signInButton.click();
    }
    public void enterEmail(String email){
        emailField.fill(email);
    }
    public void enterPassword(String password){
        passwordField.fill(password);
    }
    public void clickSubmitButton(){
        submitButton.click();
    }
    public void login(String email, String password){
        clickSigninButton();
        enterEmail(email);
        enterPassword(password);
        clickSubmitButton();
    }


}
