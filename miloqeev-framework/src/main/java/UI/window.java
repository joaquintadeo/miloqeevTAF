package UI;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.util.Set;

public class window extends browserManagement{

    /**
     * Maximizes current browser window.
     * @throws Throwable
     */
    public static void maximizeBrowserWindow() throws Throwable{
        try {
            driver.manage().window().maximize();
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Logs current browser window's size.
     * @throws Throwable
     */
    public static void getWindowSize() throws Throwable{
        try {
            Dimension size = driver.manage().window().getSize();
            System.out.println("The screen size is: " + size);
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Sets current browser window's size to the given width and height.
     * @param width
     * @param height
     * @throws Throwable
     */
    public static void setWindowSize(int width, int height) throws Throwable{
        try {
            Dimension size = new Dimension (width, height);
            driver.manage().window().setSize(size);
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Logs the current browser window's position.
     * @throws Throwable
     */
    public static void getWindowPosition() throws Throwable{
        try {
            Point position = driver.manage().window().getPosition();
            System.out.println("The window position is: " + position);
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Sets current browser window's size to the given points.
     * @param x
     * @param y
     * @throws Throwable
     */
    public static void setWindowPosition(int x, int y) throws Throwable{
        try {
            Point position = new Point (x, y);
            driver.manage().window().setPosition(position);
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Returns the current browser window's title.
     * @return
     * @throws Throwable
     */
    public static String getWindowTitle() throws Throwable{
        String title = null;
        try {
            title = driver.getTitle();
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
        return title;
    }

    /**
     * no se que lo que e
     * @return
     * @throws Throwable
     */
    public static String getWindowHandle() throws Throwable{
        String handle = null;
        try {
            handle = driver.getWindowHandle();
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
        return handle;
    }

    /**
     * Selects the browser's window by identifier.
     * @param identifier
     * @throws Throwable
     */
    //algo le pasa
    public static void selectWindow(String identifier) throws Throwable{
        try {
            driver.switchTo().window(identifier);
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Closes the current browser's window.
     * @param identifier
     * @throws Throwable
     */
    public static void closeWindow(String identifier) throws Throwable{
        try {
            selectWindow(identifier);
            driver.close();
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
    }

    /**
     * Returns list of current browser's windows identifiers.
     * @return
     * @throws Throwable
     */
    public static Set<String> getWindowHandles() throws Throwable{
        Set<String>  handles = null;
        try {
            handles = driver.getWindowHandles();
        } catch (AssertionError | Exception e) {
            testStepHandle("FAIL", driver, logInfo, e);
            logInfo.fail(e.getCause());
        }
        return handles;
    }
}
