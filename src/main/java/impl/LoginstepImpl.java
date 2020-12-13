package impl;

import Element.Element;
import Driver.driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.TestUtil;

public class LoginstepImpl {

    public void newtest(){
        System.out.println("Starting first case");
    }

    public void verifyTitle(){
        String title = new driver().getTitle();
        System.out.println(title);
        Assert.assertEquals("Cogmento CRM", title);
//        new Element().findElement(By.id(""));
    }

    public void getDataFromExcel(){
        TestUtil.getTestData("contacts");
    }
}
