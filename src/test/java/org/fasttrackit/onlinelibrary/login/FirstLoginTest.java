package org.fasttrackit.onlinelibrary.login;

import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FirstLoginTest extends TestBase {


    @Test
    public void validLoginTest() {
        openLoginPage();
        doLogin("eu@fast.com", "eu.pass");

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
        doLogin("eu.fast.com", "wrong.pass");

        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        System.out.println(errorMsg.getText());
        assertThat(errorMsg.getText(), is("Invalid user or password!"));
    }

    @Test
    public void whenEnterOnlyEmailIGetErrorMessage() {
        openLoginPage();
        doLogin("eu.fast.com", "");

        WebElement errorMsg = driver.findElement(By.className("error-msg"));
        System.out.println(errorMsg.getText());
        assertThat(errorMsg.getText(), is("Please enter your password!"));
    }


    private void openLoginPage() {
        System.out.println("Open Login Page.");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }

    private void doLogin(String userName, String password) {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(userName);

        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();


    }


}