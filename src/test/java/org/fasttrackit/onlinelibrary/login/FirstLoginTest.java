package org.fasttrackit.onlinelibrary.login;

import com.sdl.selenium.web.link.WebLink;
import org.fasttrackit.example.LoginView;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FirstLoginTest extends TestBase {

    private LoginView loginPage = new LoginView();

    @Test
    public void validLoginTest() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        WebLink logoutBtn1 = new WebLink().setText("Logout");
        logoutBtn1.assertClick();

    }
    @DataProvider
    public static Object[][] invalidLogin() {
        return new Object[][]{
                {"eu.fast.com", "wrong.pass","Invalid user or password!"},
                {"eu.fast.com", "", "Please enter your password!"},
                {"", "some.pass", "Please enter your email!"},
                {"", "", "Please enter your email!"}

        };
    }

    @Test(dataProvider = "invalidLogin")
    public void invalidLoginTest (String email, String pass, String errorMsg){
        System.out.println("invalid login test:" + email + " - " + pass + " - " + errorMsg);
        openLoginPage();
        loginPage.doLogin(email,pass);
        loginPage.assertThatErrorIs(errorMsg);
    }

    private void openLoginPage() {
        System.out.println("Open Login Page.");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }


}

