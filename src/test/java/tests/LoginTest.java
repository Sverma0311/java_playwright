package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginPage(){
        page.fill("#user-name", "standard_user");
        page.fill("#password", "secret_sauce");
        page.click("#login-button");
        String loginPageTitle = page.textContent("//*[@class='title']");
        System.out.println("login page title: "+ loginPageTitle);
        Assert.assertEquals(loginPageTitle, "Products", " not able to login");

    }
}
