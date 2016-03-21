package org.fasttrackit.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChangePasswordPage {

    @FindBy(how = How.XPATH, using = "//div[@id='preferences-win']//input[@name='password']")
    private WebElement currentPassword;

    @FindBy(how= How.XPATH, using = "//input[@name='newPassword']")
    private WebElement newPassword;

    @FindBy(how=How.XPATH, using = "//div[@id='preferences-win']//input[@name='newPasswordRepeat']")
    private WebElement newPasswordRepeat;

    @FindBy(how=How.CSS, using = "#preferences-win button.btn-warning")
    private WebElement saveBtn;

    @FindBy(how=How.CSS, using = "#preferences-win .status-msg")
    private WebElement statusElement;

    public void changePassword(String oldPass, String newPass, String newPassRepeat) {
        currentPassword.sendKeys(oldPass);
        newPassword.sendKeys(newPass);
        newPasswordRepeat.sendKeys(newPassRepeat);
        saveBtn.click();
    }

    public String getStatusMessage() {
        return statusElement.getText();
    }


}
