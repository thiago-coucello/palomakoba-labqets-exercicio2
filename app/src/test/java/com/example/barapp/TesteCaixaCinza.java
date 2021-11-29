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

public class TesteCaixaCinza {

    private AndroidDriver<MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "K7AXB60350088V6");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.example.barapp");
        desiredCapabilities.setCapability("appActivity", "com.example.barapp.MainActivity");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

    }

    @Test
    public void deveInteragirUmCheckbox() throws InterruptedException {
        MobileElement el1 = driver.findElementById("com.example.barapp:id/cb_cerveja");
        el1.click();
        MobileElement el2 = driver.findElementById("com.example.barapp:id/bt_efetuarPedido");
        el2.click();
        Thread thread = new Thread();
        thread.sleep(5000);
        MobileElement el3 = driver.findElementById("com.example.barapp:id/tv_resumoPedido");
        el3.click();
        Assert.assertEquals("1 Cerveja\n", el3.getText());

    }

    @Test
    public void deveInteragirTodosCheckbox() throws InterruptedException {
        MobileElement el1 = driver.findElementById("com.example.barapp:id/cb_cerveja");
        el1.click();
        MobileElement el2 = driver.findElementById("com.example.barapp:id/cb_agua");
        el2.click();
        MobileElement el3 = driver.findElementById("com.example.barapp:id/cb_cigarro");
        el3.click();
        MobileElement el4 = driver.findElementById("com.example.barapp:id/cb_vodka");
        el4.click();
        MobileElement el5 = driver.findElementById("com.example.barapp:id/cb_cachaca");
        el5.click();
        MobileElement el6 = driver.findElementById("com.example.barapp:id/cb_whisky");
        el6.click();
        MobileElement el7 = driver.findElementById("com.example.barapp:id/bt_efetuarPedido");
        el7.click();
        Thread thread = new Thread();
        thread.sleep(5000);
        MobileElement el9 = driver.findElementById("com.example.barapp:id/tv_resumoPedido");
        el9.click();
        Assert.assertEquals("1 Água\n" + "1 Cachaça\n" + "1 Cerveja\n"
                + "1 Cigarro\n" + "1 Vodka\n" + "1 Whisky\n", el9.getText());
    }

    @After
    public void tearDown() {

        driver.quit();
    }
}
