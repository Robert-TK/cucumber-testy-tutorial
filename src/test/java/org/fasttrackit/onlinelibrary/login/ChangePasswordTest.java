package org.fasttrackit.onlinelibrary.login;

import org.fasttrackit.example.ChangePasswordPage;
import org.fasttrackit.example.ChangePasswordView;
import org.fasttrackit.example.LoginPage;
import org.fasttrackit.example.NavbarPage;
import org.fasttrackit.forms.FirstFormView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChangePasswordTest extends TestBase {

    private LoginPage loginPage;
    private ChangePasswordView changePasswordPage = new ChangePasswordView();
    private NavbarPage navbar;

    public ChangePasswordTest() {

        loginPage = PageFactory.initElements(driver, LoginPage.class);
       // changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
        navbar = PageFactory.initElements(driver, NavbarPage.class);
    }

    @Test
    public void successChangePassword() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");
        navbar.openPreferences();
        changePasswordPage.changePassword("eu.pass", "eu.pass2", "eu.pass2");
        String statusMessage = changePasswordPage.getStatusMessage();
        System.out.println(statusMessage);
        assertThat(statusMessage, is("Your password has been successfully changed."));
        changePasswordPage.close();
    }

    @Test
    public void changeDateTest() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");
        FirstFormView form = new FirstFormView();
        form.datePicker.select("29/feb/2012","dd/MMM/yyyy", Locale.ENGLISH);
    }

    private void openLoginPage() {
        System.out.println("Open Login Page.");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }


}

