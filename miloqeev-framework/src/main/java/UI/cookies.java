package UI;

import org.openqa.selenium.Cookie;

import java.util.Date;
import java.util.Set;

import static UI.browserManagement.getDriver;
import static testListeners.extentReportListener.logInfo;
import static testListeners.extentReportListener.testStepHandle;

public class cookies {

    /**
     * Deletes all cookies.
     */
    public static void deleteAllCookies(){
        try{
            getDriver().manage().deleteAllCookies();
            logInfo.pass("Deleted all cookies");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to delete all cookies"), e);
        }
    }

    /**
     * Deletes cookie matching `name`.
     * @param name
     */
    public static void deleteCookie(String name){
        try{
            Cookie cookie = getDriver().manage().getCookieNamed(name);
            getDriver().manage().deleteCookie(cookie);
            logInfo.pass("Deleted cookie: '" + name + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable delete cookie: '" + name + "'"), e);
        }
    }

    /**
     * Returns all cookies of the current page.
     * @return
     */
    public static Set<Cookie> getCookies() {
        Set<Cookie> cookies = null;
        try {
            cookies = getDriver().manage().getCookies();
            logInfo.pass("Saved cookies into list: '" + cookies + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to save cookies into list"), e);
        }
        return cookies;
    }

    /**
     * Returns information of cookie identified by `name`.
     * @param name
     * @return
     */
    public static Cookie getCookie(String name){
        Cookie cookie = null;
        try{
            cookie = getDriver().manage().getCookieNamed(name);
            logInfo.pass("Saved cookie into variable: '" + cookie + "'");
        } catch (AssertionError | Exception e){
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to save cookie into variable"), e);
        }
        return cookie;
    }

    /**
     * Adds cookie to your current session.
     * @param name
     * @param value
     * @param path
     * @param domain
     * @param expiry `eg: Fri, 5 Oct 2018 14:28:00 GMT`
     * @param isSecure
     * @param isHttpOnly
     */
    public static void addCookie(String name, String value, String path, String domain, Date expiry, boolean isSecure, boolean isHttpOnly) {
        try {
            Cookie cookie = new Cookie(name, value, path, domain, expiry, isSecure, isHttpOnly);
            getDriver().manage().addCookie(cookie);
            logInfo.pass("Added cookie to the current session: '" + cookie + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Unable to add cookie to the current session"), e);
        }
    }
}
