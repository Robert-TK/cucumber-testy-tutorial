package org.fasttrackit.onlinelibrary.login;

import com.sdl.selenium.web.link.WebLink;
import org.fasttrackit.example.LoginView;
import org.fasttrackit.util.TestBase;
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

    @Test
    public void errorWhenInvalidPassword() {
        openLoginPage();
        loginPage.doLogin("eu.fast.com", "wrong.pass");
        loginPage.assertThatErrorIs("Invalid user or password!");
    }

    @Test
    public void whenEnterOnlyEmailIGetErrorMessage() {
        openLoginPage();
        loginPage.doLogin("eu.fast.com", "");
        loginPage.assertThatErrorIs("Please enter your password!");

    }

    @Test
    public void whenEnterOnlyPasswordGetErrorMessage() {
        openLoginPage();
        loginPage.doLogin("", "eu.pass");
        loginPage.assertThatErrorIs("Please enter your email!");
    }

    @Test
    public void noCredentials() {
        openLoginPage();
        loginPage.doLogin("", "");
        loginPage.assertThatErrorIs("Please enter your email!");
    }

    private void openLoginPage() {
        System.out.println("Open Login Page.");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }


}

