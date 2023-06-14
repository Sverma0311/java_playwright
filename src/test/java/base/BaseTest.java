package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {
    private static Playwright playwright;
    protected static Page page;
    private static Browser browser;

    @BeforeTest
    public void setup(){
        System.out.println("open browser");
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        page.navigate("https://www.saucedemo.com/");
        String title = page.title();
        System.out.println("Title: "+title);

    }

    @AfterTest
    public void tearDown(){
        System.out.println("close browser");
        page.close();
        browser.close();
        playwright.close();
    }
}
