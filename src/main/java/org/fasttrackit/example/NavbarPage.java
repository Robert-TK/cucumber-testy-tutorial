package org.fasttrackit.example;

import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavbarPage {
    @FindBy(how = How.XPATH, using = "//nav//button")
    private WebElement preferencesButton;

    public void openPreferences() {
        preferencesButton.click();
        Utils.sleep(300);

    }

}
