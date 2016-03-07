package org.fasttrackit.onlinelibrary.login;

import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstLoginTest extends TestBase {


    @Test
    public void validLoginTest() {
        System.out.println("Open Login Page.");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
        //driver.findElement(By.id("email")).sendKeys("eu@fast.com");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("eu@fast.com");

        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys("eu.pass");

        WebElement loginBtn = driver.findElement(By.className("btn"));
        loginBtn.click();

        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException exception) {
            Assert.fail("Logout button not found.");
        }
    }

    @Test
    public void errorWhenInvalidPassword() {
        System.out.println("Open Login Page.");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
        //driver.findElement(By.id("email")).sendKeys("eu@fast.com");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("eu@fast.com");

        WebElement passField = driver.findElement(By.id("password"));
        passField.sendKeys("eu.passwrong");

        WebElement loginBtn = driver.findElement(By.className("btn"));
        loginBtn.click();

    }



}