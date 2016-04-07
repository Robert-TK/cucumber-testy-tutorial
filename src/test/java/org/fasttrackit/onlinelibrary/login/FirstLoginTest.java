package org.fasttrackit.onlinelibrary.login;

import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.web.link.WebLink;
import com.sdl.selenium.web.utils.PropertiesReader;
import com.sun.xml.internal.fastinfoset.sax.Properties;
import org.fasttrackit.example.LoginView;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.sdl.selenium.web.utils.PropertiesReader.RESOURCES_DIRECTORY_PATH;

public class FirstLoginTest extends TestBase {

    private LoginView loginPage = new LoginView();

    @Test
    public void validLoginTest() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        WebLink logoutBtn1 = new WebLink().setText("Logout");
        logoutBtn1.assertClick();

    }
    @DataProvider
    public static Object[][] invalidLogin() {
        return new Object[][]{
                {"eu.fast.com", "wrong.pass","Invalid user or password!"},
                {"eu.fast.com", "", "Please enter your password!"},
                {"", "some.pass", "Please enter your email!"},
                {"", "", "Please enter your email!"}

        };
    }

    @Test(dataProvider = "invalidLogin")
    public void invalidLoginTest (String email, String pass, String errorMsg){
        System.out.println("invalid login test:" + email + " - " + pass + " - " + errorMsg);
        openLoginPage();
        loginPage.doLogin(email,pass);
        loginPage.assertThatErrorIs(errorMsg);
    }

    private Form form = new Form("Form Title");
    private UploadFile uploadBtn = new UploadFile(form, "TPT Test:");

    @Test
    public void uploadTest() {
        openLoginPage();
        System.out.println(PropertiesReader.RESOURCES_DIRECTORY_PATH);
        uploadBtn.upload("Select file", new String[]{
                PropertiesReader.RESOURCES_DIRECTORY_PATH + "\\upload.exe",
                PropertiesReader.RESOURCES_DIRECTORY_PATH + "\\feature\\login\\login.feature"
        });

    }

    private void openLoginPage() {
        System.out.println("Open Login Page.");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/bootstrap/index.html");
    }


}

