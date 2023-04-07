package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.util.List;

import static org.apache.commons.lang3.CharSetUtils.count;
import static org.testng.TestNGAntTask.Mode.junit;

public class AppTest {

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser","url"})

    void setUpDriver(String browser,String link){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.get(link);
        driver.manage().window().maximize();
    }

    @Test
    public void googleTest() throws InterruptedException {
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("login_field")).sendKeys("gangadharlalam710@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("Ganga1432@");
        Thread.sleep(2000);
        driver.findElement(By.name("commit")).click();
        Thread.sleep(3000);
    }

    @AfterClass
    void close(){
        driver.close();
    }


}