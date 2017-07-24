/*
 * Copyright (C) 2017 Zdeněk Žamberský
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.redhat.thermostat.testing.tests;

import com.redhat.thermostat.testing.util.Config;
import com.redhat.thermostat.testing.util.WebClient;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Zdeněk Žamberský
 */
public class WebClientBasicTest {

    WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        FirefoxDriverManager.getInstance().setup();
    }

    @Before
    public void before() {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setAcceptInsecureCerts(true);

        driver = new FirefoxDriver(caps);
    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLogin() {
        String url = Config.getWebClientUrl();
        String username = Config.getWebClientUsername();
        String password = Config.getWebClientPassword();

        WebClient.login(driver, url, username, password);

        // If login was successfull logout button should be present and visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement logoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"logoutButton\"]")));
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
    }

    @Test
    public void testBadLogin() {
        String url = Config.getWebClientUrl();
        String username = Config.getWebClientUsername();
        String password = Config.getWebClientBadPassword();

        WebClient.login(driver, url, username, password);

        // Alert should be displayed on bad login
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
