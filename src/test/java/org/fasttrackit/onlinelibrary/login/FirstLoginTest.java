package org.fasttrackit.onlinelibrary.login;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.example.LoginPage;
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

    public FirstLoginTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
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



    @Test
    public void successChangePassword() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");
        WebElement preferencesButton = driver.findElement(By.xpath("//nav//button"));
        preferencesButton.click();

        Utils.sleep(300);

        //css selector: $$("#preferences-win input[name=password]")

        WebElement currentPassField = driver.findElement(By.xpath("//div[@id='preferences-win']//input[@name='password']"));
        currentPassField.sendKeys("eu.pass");

        WebElement newPassField = driver.findElement(By.xpath("//input[@name='newPassword']"));
        newPassField.sendKeys("eu.pass2");

        WebElement repeatPassField = driver.findElement(By.xpath("//div[@id='preferences-win']//input[@name='newPasswordRepeat']"));
        repeatPassField.sendKeys("eu.pass2");

        WebElement saveBtn = driver.findElement(By.cssSelector("#preferences-win button.btn-warning"));
        saveBtn.click();

        WebElement statusElement = driver.findElement(By.cssSelector("#preferences-win .status-msg"));
        System.out.println(statusElement.getText());
        assertThat(statusElement.getText(), is("Your password has been successfully changed."));

    }


    private void openLoginPage() {
        System.out.println("Open Login Page.");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }


}

