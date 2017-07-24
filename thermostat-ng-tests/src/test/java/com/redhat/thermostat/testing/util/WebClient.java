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
package com.redhat.thermostat.testing.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Zdeněk Žamberský
 */
public class WebClient {

    public static void login(WebDriver driver, String url, String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.get(url);

        WebElement usernameInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"username\"]")));
        WebElement passwordInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]")));
        WebElement submitButtion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"kc-login\"]")));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButtion.click();
    }

}
