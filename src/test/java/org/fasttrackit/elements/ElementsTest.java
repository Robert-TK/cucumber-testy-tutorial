package org.fasttrackit.elements;

import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.forms.FirstFormView;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;

public class ElementsTest extends TestBase {

    @Test
    public void checkboxTest (){
        System.out.println("you have created a FirstFormView");
        driver.get("file:///C:/Users/robertt/Desktop/Testy/src/test/functional/app-demo/bootstrap/index.html");
        FirstFormView form = new FirstFormView();
        form.enterCheckbox.assertClick();
        form.stopProcessCheckbox.assertClick();
        Utils.sleep(3000);
        form.enterLabel.assertClick();
        form.stopProcessLabel.assertClick();


    }
}

