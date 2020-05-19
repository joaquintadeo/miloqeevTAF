package UI;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.util.Set;

import static testListeners.extentReportListener.*;
import static UI.browserManagement.getDriver;

public class window {

    /**
     * Maximizes current browser window.
     */
    public static void maximizeBrowserWindow(){
        try {
            getDriver().manage().window().maximize();
            logInfo.pass("Maximized browser window");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not maximize browser window"), e);
        }
    }

    /**
     * Logs current browser window's size.
     */
    public static void getWindowSize(){
        try {
            Dimension size = getDriver().manage().window().getSize();
            System.out.println("The screen size is: " + size);
            logInfo.pass("Logged current browser window's size to console");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not get window's size"), e);
        }
    }

    /**
     * Sets current browser window's size to the given width and height.
     * @param width
     * @param height
     */
    public static void setWindowSize(int width, int height){
        try {
            Dimension size = new Dimension (width, height);
            getDriver().manage().window().setSize(size);
            logInfo.pass("Set browser window's size to '" + width + "x" + height + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not set window's size to desired value"), e);
        }
    }

    /**
     * Logs the current browser window's position.
     */
    public static void getWindowPosition(){
        try {
            Point position = getDriver().manage().window().getPosition();
            System.out.println("The window position is: " + position);
            logInfo.pass("Logged browser window's position to console");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not get browser window's position"), e);
        }
    }

    /**
     * Sets current browser window's size to the given points.
     * @param x
     * @param y
     */
    public static void setWindowPosition(int x, int y){
        try {
            Point position = new Point (x, y);
            getDriver().manage().window().setPosition(position);
            logInfo.pass("Set browser window's position to '" + x + "," + y + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not set window's position to desired value"), e);
        }
    }

    /**
     * Returns the current browser window's title.
     * @return `title`.
     */
    public static String getWindowTitle(){
        String title = null;
        try {
            title = getDriver().getTitle();
            logInfo.pass("Saved window's title='" + title + "' to variable");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save window's title to variable"), e);
        }
        return title;
    }

    /**
     * Returns current browser window's handle.
     * @return `handle`.
     */
    public static String getWindowHandle(){
        String handle = null;
        try {
            handle = getDriver().getWindowHandle();
            logInfo.pass("Saved window's handle='" + handle + "' to variable");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save window's handle to variable"), e);
        }
        return handle;
    }

    /**
     * Selects the browser's window by identifier.
     * @param identifier
     */
    public static void selectWindow(String identifier){
        try {
            getDriver().switchTo().window(identifier);
            logInfo.pass("Focus window selected by identifier='" + identifier + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not focus window selected by identifier='" + identifier + "'"), e);
        }
    }

    /**
     * Closes the current browser's window.
     * @param identifier
     */
    public static void closeWindow(String identifier){
        try {
            selectWindow(identifier);
            getDriver().close();
            logInfo.pass("Closed window selected by identifier='" + identifier + "'");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not close window selected by identifier='" + identifier + "'"), e);
        }
    }

    /**
     * Returns list of current browser's windows identifiers.
     * @return `handles`.
     */
    public static Set<String> getWindowHandles(){
        Set<String>  handles = null;
        try {
            handles = getDriver().getWindowHandles();
            logInfo.pass("Saved window's handle='" + handles + "' to list");
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", getDriver(), logInfo.fail("Could not save window's handle to list"), e);
        }
        return handles;
    }
}
