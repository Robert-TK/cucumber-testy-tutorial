package org.fasttrackit.elements;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.example.GridView;
import org.fasttrackit.forms.FirstFormView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

public class ElementsTest extends TestBase {

    @Test
    public void checkboxTest() {
        System.out.println("you have created a FirstFormView");
        driver.get("file:///C:/Users/robertt/Desktop/Testy/src/test/functional/app-demo/bootstrap/index.html");
        FirstFormView form = new FirstFormView();
        form.enterCheckbox.assertClick();
        form.stopProcessCheckbox.assertClick();
        Utils.sleep(3000);
        form.enterLabel.assertClick();
        form.stopProcessLabel.assertClick();


    }

    @Test
    public void scrollToViewTest() {
        driver.get("http://examples.sencha.com/extjs/6.0.2/examples");
        GridView grid = new GridView();
        grid.openGrid();

        WebDriverConfig.switchToLastTab();

        WebLocator headerCt = new WebLocator().setClasses("x-grid-header-ct");
        WebLocator header = new WebLocator(headerCt).setText("Manufacturer");
        WebLocator header2 = new WebLocator(headerCt).setText("Title");

        header.click();
        header2.findElement();

        (new Actions(driver)).dragAndDrop(header.currentElement, header2.currentElement).build().perform();

        WebLocator person = new WebLocator().setText("Sidney Sheldon");
        person.click();
    }

    @Test
    public void scrollTest() {

        GridView grid = new GridView();
        grid.openGrid("Miscellaneous", "Resizable");

        WebDriverConfig.switchToLastTab();

        WebLocator basic = new WebLocator().setId("basic");
        WebLocator resizeHandle = new WebLocator(basic).setClasses("x-resizable-handle-southeast");
        resizeHandle.mouseOver();

        (new Actions(driver)).dragAndDropBy(resizeHandle.currentElement, 350, 250).build().perform();

    }

    @Test
    public void iterationThrouElements() {
        driver.get("http://examples.sencha.com/extjs/6.0.2/examples/classic/view/data-view.html");
        /*Utils.sleep(2000);
        List<WebElement> imageList = driver.findElements(By.cssSelector("#dataview-example img"));
        for (WebElement img : imageList) {
            String poza = img.getAttribute("src");
            System.out.println(poza);

        }*/
        WebLocator img = new WebLocator().setElCssSelector("#dataview-example img");
        img.ready();
        for (WebElement image : img.findElements()) {
            String title = image.getAttribute("title");

        }

    }
}

