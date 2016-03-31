package org.fasttrackit.forms;

import com.sdl.selenium.bootstrap.form.CheckBox;
import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.extjs3.form.Label;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;

public class FirstFormView extends WebLocator {

    public FirstFormView() {
        setTag("form");
        WebLocator legend = new WebLocator().setText("Form Title");
        setChildNodes(legend);

    }

    public DatePicker datePicker = new DatePicker(this);
    public WebLocator selectCalendar = new WebLocator(this).setClasses("icon-calendar");

    public WebLocator stopProcessLabel = new WebLocator(this).setTag("label").setText("Stop the process?", SearchType.TRIM);
    public WebLocator enterLabel = new WebLocator(this).setTag("label").setText("Label with Enter", SearchType.TRIM, SearchType.CHILD_NODE);

   // private WebLocator stopProcessContainer = new WebLocator(this).setElPath("/div[3]");
    //private WebLocator enterContainer = new WebLocator(this).setElPath("/div[4]");
    public CheckBox stopProcessCheckbox= new CheckBox(stopProcessLabel);
    public CheckBox enterCheckbox= new CheckBox(enterLabel);



    public static void main(String[] args) {
        FirstFormView formView = new FirstFormView();

        System.out.println(formView.stopProcessLabel.getSelector());
    }
}
