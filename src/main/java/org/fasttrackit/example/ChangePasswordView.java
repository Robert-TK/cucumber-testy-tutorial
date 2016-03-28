package org.fasttrackit.example;

import com.sdl.selenium.web.WebLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChangePasswordView {

    private WebElement currentPassField = new WebLocator().setElPath("//div[@id='preferences-win']//input[@name='password']");
    private WebElement newPassField = new WebLocator().setElPath("//input[@name='newPassword']");
    private WebElement repeatPassField = new WebLocator().setElPath("//div[@id='preferences-win']//input[@name='newPasswordRepeat']");
    private WebElement saveBtn = new WebLocator().setElCssSelector("#preferences-win button.btn-warning");
    private WebElement statusElement = new WebLocator().setElCssSelector("#preferences-win .status-msg");

    public void changePassword(String oldPass, String newPass, String newPassRepeat) {
        currentPassField.sendKeys(oldPass);
        newPassField.sendKeys(newPass);
        repeatPassField.sendKeys(newPassRepeat);
        saveBtn.click();
    }

    public String getStatusMessage() {

        return statusElement.getText();
    }


}
