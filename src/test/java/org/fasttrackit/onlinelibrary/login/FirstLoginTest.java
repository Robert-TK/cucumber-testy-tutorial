package org.fasttrackit.onlinelibrary.login;

import org.fasttrackit.example.ChangePasswordPage;
import org.fasttrackit.example.LoginPage;
import org.fasttrackit.example.NavbarPage;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FirstLoginTest extends TestBase {

    private LoginPage loginPage;
    private ChangePasswordPage changePasswordPage;
    private NavbarPage navbar;

    public FirstLoginTest() {

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
        navbar = PageFactory.initElements(driver, NavbarPage.class);
    }


    @Test
    public void validLoginTest() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException exception) {
            Assert.fail("Logout button not found.");
        }
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

