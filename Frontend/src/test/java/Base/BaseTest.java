package Base;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
  protected static Playwright playwright;
  protected static BrowserContext context;
  protected static Browser browser;
  protected Page page;

  @BeforeAll
   static void initialSetup(){
      playwright = Playwright.create();
      browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
  }
  @BeforeEach
    void setup(){
      context = browser.newContext();
      page = context.newPage();
      page.navigate("https://think-and-get-it-frontend.onrender.com/");
  }
  @AfterEach
    void tearDown(){
      context.close();
  }
  @AfterAll
    static void globalTearDown(){
      playwright.close();
  }


}
