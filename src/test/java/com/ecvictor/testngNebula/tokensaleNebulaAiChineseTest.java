package com.ecvictor.testngNebula;
/**
 * Created by caoc on 2/10/17.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */


import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class tokensaleNebulaAiChineseTest {
    private WebDriver driver;
    private String baseUrl;
    //private boolean acceptNextAlert = true;
    //private StringBuffer verificationErrors = new StringBuffer();

    @BeforeMethod
    public void setUp() throws Exception {
        //chose driver type
        String os = (System.getProperty("os.name"));
        if (os.equalsIgnoreCase("Mac OS X"))
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        else System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        /**
         * for maximize
         */
        //chromeOptions.addArguments("--kiosk");

        /**
         * Dimension only for Jenkins
         */
        Dimension d = new Dimension(1382, 744);

        driver = new ChromeDriver(chromeOptions);

        baseUrl = "https://tokensale.nebula-ai.network/";
        /**
         * Dimension only for Jenkins
         */
        driver.manage().window().setSize(d);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testTokenSaleCN_wallet() throws Exception {

        // To test home page wallet
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
        assertEquals("NBAI SMART CONTRACT ADDRESS: 0X83C451371EF470D206CF011405D89F6CCB0E915E", driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[6]")).getText());
        System.out.println("home page wallet Test finish");
        //To test wallet medium
        driver.get("https://medium.com/@ccao/nbai-token-sale-instructions-b023c93be202");
        assertEquals("0x83c451371EF470D206cf011405D89f6ccb0e915e",driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/main/article/div/section/div[2]/div/h4[3]/strong")).getText());
        System.out.println("Page medium wallet Test finish");

//        Thread.sleep(300000);
//        testTokenSaleCN_wallet();
    }


    /**
     * Example of mouseover
     */
//    @Test
//    public void temp1() throws Exception {
//        driver.get("https://nebula-ai.com/");
//
//        WebElement settings = driver.findElement(By.xpath("//A[@class='translate-menu-language aLink'][text()='Language']"));
//        Actions action = new Actions(driver);
//        Thread.sleep(500);
//        action.moveToElement(settings).build().perform();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("(//A[text()='繁体 '])[1]")).click();
//        Thread.sleep(5000);
//    }

//    @Test
//    public void testMouseover() throws Exception {
//        driver.get("https://tokensale.nebula-ai.network/#home");
//        //Thread.sleep(5000);
//        WebElement settings = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div/ul/a"));
//        Actions action = new Actions(driver);
//        Thread.sleep(500);
//        action.moveToElement(settings).build().perform();
//        Thread.sleep(500);
//        driver.findElement(By.xpath("//A[@href='https://nebula-ai.com/whitepaper/NBAI_whitepaper_CN.pdf']")).click();
//        Thread.sleep(500);
//    }

    @Test
    public void testTokenSaleCN_home() throws Exception {
        // To test homepage
        //test whitepaper
        driver.get("https://tokensale.nebula-ai.network/#home");
        //Thread.sleep(5000);
        WebElement settings = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[3]/div/ul/a"));
        Actions action = new Actions(driver);
        Thread.sleep(500);
        action.moveToElement(settings).build().perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("//A[@href='https://nebula-ai.com/whitepaper/NBAI_whitepaper_CN.pdf']")).click();
        Thread.sleep(500);
        assertEquals("https://nebula-ai.com/whitepaper/NBAI_whitepaper_CN.pdf", driver.getCurrentUrl());


//        driver.get("https://tokensale.nebula-ai.network/#home");
//        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
//        driver.findElement(By.xpath("//*[@id=\"translate-home-link1\"]")).click();
//        for (String winHandle : driver.getWindowHandles()) {
//            driver.switchTo().window(winHandle);
//        }
//        assertEquals("https://nebula-ai.com/whitepaper/NBAI_whitepaper_CN.pdf", driver.getCurrentUrl());


        //test telegram
        driver.get("https://tokensale.nebula-ai.network/#home");
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
        driver.findElement(By.xpath("//IMG[@src='ressources/images/984222312.jpg']")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        assertEquals("https://t.me/NebulaAICommunity", driver.getCurrentUrl());

        //test page twitter
        driver.get("https://tokensale.nebula-ai.network/#home");
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
        driver.findElement(By.xpath("//IMG[@src='ressources/images/Twitter_Logo_White_On_Image.png']")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        assertEquals("https://twitter.com/Nebula_AI", driver.getCurrentUrl());

        //test page github
        driver.get("https://tokensale.nebula-ai.network/#home");
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
        driver.findElement(By.xpath("//IMG[@src='ressources/images/1883639.png']")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        assertEquals("https://github.com/nebulaai", driver.getCurrentUrl());
        System.out.println("homeTest finish");
        //test page facebook
        driver.get("https://tokensale.nebula-ai.network/#home");
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
        driver.findElement(By.xpath("//IMG[@src='ressources/images/white-facebook-icon-png-like-us-on-facebook-to-stay-up-31.png']")).click();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        assertEquals("https://www.facebook.com/NebulaAI/", driver.getCurrentUrl());
        System.out.println("homeTest finish");

    }


    @Test
    public void testTokenSaleCN_TopBar() throws Exception {

        //To test Login page
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"translate-home-login\"]")).click();
        assertEquals("https://whitelist.nebula-ai.network/kyc/#/login", driver.getCurrentUrl());
// come back home page
        driver.get(baseUrl);
        //test 关于
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"translate-home-about\"]")).click();
        assertEquals("https://tokensale.nebula-ai.network/#about", driver.getCurrentUrl());
        Thread.sleep(1000);
        assertEquals("介绍", driver.findElement(By.cssSelector("html body div#about.about div.content div.header div#translate-about-intro.intro")).getText());
        //test 介绍
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"translate-home-use-case\"]")).click();
        assertEquals("https://tokensale.nebula-ai.network/#use-case", driver.getCurrentUrl());
        Thread.sleep(1000);
        assertEquals("智能分析", driver.findElement(By.cssSelector("#translate-use-case-sub-title")).getText());
        //test 团队
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"translate-home-team\"]")).click();
        assertEquals("https://tokensale.nebula-ai.network/#team", driver.getCurrentUrl());
        Thread.sleep(1000);
        assertEquals("我们的团队", driver.findElement(By.xpath("//*[@id=\"translate-team-title\"]")).getText());

        //test 常问问题
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"translate-home-faq\"]")).click();
        assertEquals("https://tokensale.nebula-ai.network/#faq", driver.getCurrentUrl());
        Thread.sleep(1000);
        assertEquals("常问问题", driver.findElement(By.xpath("//*[@id=\"translate-faq-title\"]")).getText());

        // Test button whitelist
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[7]/a[1]")).click();
        assertEquals("https://whitelist.nebula-ai.network/", driver.getCurrentUrl());
        // Test KYC
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
        String winHandleBeforeKYC = driver.getWindowHandle();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[7]/a[2]")).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        Thread.sleep(1000);
        assertEquals("https://whitelist.nebula-ai.network/kyc/#/login", driver.getCurrentUrl());


        // Test button Buy Token
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
        String winHandleBefore = driver.getWindowHandle();
// Perform the click operation that opens new window
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[7]/a[3]")).click();
// Switch to new window opened
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        assertEquals("https://medium.com/@ccao/nbai-token-sale-instructions-b023c93be202", driver.getCurrentUrl());
        // Close the new window, if that window no more required
        driver.close();

// Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);

        System.out.println("Top Bar Test Finish");
    }

    @Test
    public void rest() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"translate\"]")).click();
        Thread.sleep(500);
        driver.get("https://tokensale.nebula-ai.network/#roadmap");
        Thread.sleep(1000);
        assertEquals("路线图", driver.findElement(By.xpath("//*[@id=\"translate-roadmap-title\"]")).getText());
        driver.findElement(By.xpath("/html/body/div[1]/ul/li[6]/a")).click();
        Thread.sleep(1000);
        assertEquals("ICO 计划", driver.findElement(By.xpath("//*[@id=\"translate-token-distribution-title\"]")).getText());
        driver.findElement(By.cssSelector("#nav-team > a:nth-child(1)")).click();
        Thread.sleep(1000);
        assertEquals("我们的团队", driver.findElement(By.xpath("//*[@id=\"translate-team-title\"]")).getText());
        driver.findElement(By.xpath("/html/body/div[1]/ul/li[8]/a")).click();
        Thread.sleep(1000);
        assertEquals("区块链专家", driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div[1]/div[2]/p/span")).getText());
        driver.findElement(By.xpath("/html/body/div[1]/ul/li[9]/a")).click();
        Thread.sleep(1000);
        assertEquals("合作伙伴", driver.findElement(By.xpath("//*[@id=\"translate-partners-title\"]")).getText());
        driver.findElement(By.xpath("/html/body/div[1]/ul/li[10]/a")).click();
        Thread.sleep(1000);
        assertEquals("战略投资者", driver.findElement(By.xpath("//*[@id=\"translate-investors-title\"]")).getText());
        driver.findElement(By.xpath("/html/body/div[1]/ul/li[11]/a")).click();
        Thread.sleep(1000);
        assertEquals("常问问题", driver.findElement(By.xpath("//*[@id=\"translate-faq-title\"]")).getText());
        System.out.println("The rest test finish");
    }


    @AfterMethod

    public void testDown() throws Exception {
        driver.close();
        driver.quit();

//        String verificationErrorString = verificationErrors.toString();
//        if (!"".equals(verificationErrorString)) {
//            fail(verificationErrorString);
//        }
    }


}
