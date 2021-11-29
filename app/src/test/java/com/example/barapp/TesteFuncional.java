package com.example.barapp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TesteFuncional {
  private AndroidDriver driver;
  
  @Before
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("deviceName", "LGM70029a76107");
    desiredCapabilities.setCapability("automationName", "uiautomator2");
    desiredCapabilities.setCapability("appPackage", "com.example.barapp");
    desiredCapabilities.setCapability("appActivity", "com.example.barapp.MainActivity");
    
    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
    
    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
  }
  
  @Test
  public void testeItemUnico() throws InterruptedException {
    MobileElement el1 = (MobileElement) driver.findElementById("com.example.barapp:id/cb_cachaca");
    el1.click();
    MobileElement el2 = (MobileElement) driver.findElementById("com.example.barapp:id/bt_efetuarPedido");
    el2.click();
    Thread.sleep(5000); // Aguarda 5 segundos da splashscreen
    MobileElement el3 = (MobileElement) driver.findElementById("com.example.barapp:id/tv_resumoPedido");
    el3.click();
    Assert.assertEquals("1 Cachaça\n", el3.getText());
  }
  
  @Test
  public void testeTodosItens() throws InterruptedException {
    MobileElement el1 = (MobileElement) driver.findElementById("com.example.barapp:id/cb_cerveja");
    el1.click();
    MobileElement el2 = (MobileElement) driver.findElementById("com.example.barapp:id/cb_agua");
    el2.click();
    MobileElement el3 = (MobileElement) driver.findElementById("com.example.barapp:id/cb_cigarro");
    el3.click();
    MobileElement el4 = (MobileElement) driver.findElementById("com.example.barapp:id/cb_vodka");
    el4.click();
    MobileElement el5 = (MobileElement) driver.findElementById("com.example.barapp:id/cb_cachaca");
    el5.click();
    MobileElement el6 = (MobileElement) driver.findElementById("com.example.barapp:id/cb_whisky");
    el6.click();
    MobileElement el7 = (MobileElement) driver.findElementById("com.example.barapp:id/bt_efetuarPedido");
    el7.click();
    Thread.sleep(5000); // Aguarda 5 segundos da splashscreen
    MobileElement el8 = (MobileElement) driver.findElementById("com.example.barapp:id/tv_resumoPedido");
    el8.click();
  
    Assert.assertEquals(
    "1 Água\n" +
            "1 Cachaça\n" +
            "1 Cerveja\n" +
            "1 Cigarro\n" +
            "1 Vodka\n" +
            "1 Whisky\n", el8.getText());
  }
  
  @After
  public void tearDown() {
    driver.quit();
  }
}
