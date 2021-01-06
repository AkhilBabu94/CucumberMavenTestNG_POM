package impl;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Sample {

    WebDriver driver;

    public void composeAndSendMail() throws AWTException, InterruptedException {
        driver.get("https://www.gmail.com");

        //enter email
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("our_emailid");
        driver.findElement(By.xpath("//div[@id='identifierNext']")).click();

        //enter password
        WebElement passwordButton = driver.findElement(By.xpath("//input[@name='password']"));
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(passwordButton));
        passwordButton.sendKeys("our_password");
        driver.findElement(By.xpath("//div[@id='passwordNext']")).click();

        //Click on compose button
        driver.findElement(By.xpath("//div[text()='Compose']")).click();

        //Enter the sender mail id
        driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("sender_mailid");
        Robot robot =new Robot();
        robot.keyPress(KeyEvent.VK_TAB);

        //Enter subject and text body
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Selenium script");
        driver.findElement(By.xpath("//div[contains(@class,'Am Al editable LW-avf tS-tW')]")).sendKeys("https://github.com/AkhilBabu94/CucumberMavenTestNG_POM");

        //Click on send
        driver.findElement(By.xpath("//div[text()='Send']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='bAq'][contains(.,'Message sent.')]")));
    }
}
