package Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static Driver.TestBase.driver;

public class Element {

    public WebElement findElement(By webElement){
        return driver.findElement(webElement);
    }
}
