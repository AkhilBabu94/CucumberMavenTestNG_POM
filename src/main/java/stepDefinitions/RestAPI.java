package stepDefinitions;

import cucumber.api.java.en.Given;
import impl.RestAPIImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RestAPI {

    RestAPIImpl restAPIimpl = new RestAPIImpl();

    @Given("Registration")
    public void registration(){
//        restAPIimpl.registration();
//        restAPIimpl.authenticationAPI();
        restAPIimpl.yo();
        restAPIimpl.yoyo();
    }

    @Given("Java Programs")
    public void javaPrograms() throws FileNotFoundException, InterruptedException, AWTException {
//        restAPIimpl.stringreverese();
//        restAPIimpl.stringrevwithoutfunction();
//        restAPIimpl.swap2numbersusing3rdvariable();
//        restAPIimpl.numberofwordsinstringhashmap();
//        restAPIimpl.ArraySort();
//        restAPIimpl.JSONParsing();
//        restAPIimpl.uploadFile();
//        restAPIimpl.selectCheckboxes();
//        restAPIimpl.alertContextmenu();
//        restAPIimpl.digestAuthentication();
//        restAPIimpl.draganddrop();
        restAPIimpl.addAtStart();
    }

    @Given("Database Integration")
    public void database() throws SQLException, ClassNotFoundException {
        restAPIimpl.dbrelated();
    }

}
