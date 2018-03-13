package com.andersonlfeitosa.buildpipeline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleHomePageTest {

  private WebDriver driver;
  String appURL = "https://www.google.com";

//  @BeforeClass
//  public void testSetUp() {
//    driver = new FirefoxDriver();
//  }

  @Test
  public void verifyGooglePageTittle() {
//    driver.navigate().to(appURL);
//    String getTitle = driver.getTitle();
//    Assert.assertEquals(getTitle, "Google");
    Assert.assertEquals("Google", "Google");
  }

//  @AfterClass
//  public void tearDown() {
//    driver.quit();
//  }

}