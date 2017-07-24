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

/**
 *
 * @author Zdeněk Žamberský
 */
public class Config {

    private static final String WebClientURL = "https://127.0.0.1:30000/web-client";
    private static final String WebClientUsername = "test-user";
    private static final String WebClientPassword = "test-pass";
    private static final String WebClientBadPassword = "bad-pass";

    public static String getWebClientUrl() {
        return WebClientURL;
    }

    public static String getWebClientUsername() {
        return WebClientUsername;
    }

    public static String getWebClientPassword() {
        return WebClientPassword;
    }

    public static String getWebClientBadPassword() {
        return WebClientBadPassword;
    }

}
