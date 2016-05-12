package org.fasttrackit.example;

import com.sdl.selenium.utils.config.WebDriverConfig;
import com.sdl.selenium.utils.config.WebLocatorConfig;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;

public class GridView {

    public void openGrid() {
        openGrid("Grids", "Grid Data Binding");
    }

    public void openGrid(String title, String example) {
        WebDriverConfig.getDriver().get("http://examples.sencha.com/extjs/6.0.2/examples");

        WebLocator gridTab = new WebLocator().setText(title);
        WebLocator gridDataBinding = new WebLocator().setText(example);
        //mouseover
        gridTab.mouseOver();
        Utils.sleep(2000);
        gridTab.click();
        Utils.sleep(3000);
        gridDataBinding.click();
    }


}
