package UI;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.util.Set;

public class window extends browserManagement{

    public static void maximizeBrowserWindow(){
        driver.manage().window().maximize();
    }

    public static void getWindowSize(){
        Dimension size = driver.manage().window().getSize();
        System.out.println("The screen size is = " + size);
    }

    public static void setWindowSize(int width, int height){
        Dimension size = new Dimension (width, height);
        driver.manage().window().setSize(size);
    }

    public static void getWindowPosition(){
        Point position = driver.manage().window().getPosition();
        System.out.println("The window position is = " + position);
    }

    public static void setWindowPosition(int x, int y){
        Point position = new Point (x, y);
        driver.manage().window().setPosition(position);
    }

    public static String getWindowTitle(){
        String title = driver.getTitle();
        return title;
    }

    public static String getWindowHandle(){
        String handle = driver.getWindowHandle();
        return handle;
    }
    /*
    Algo le pasa
     */
    public static void selectWindow(String identifier){
        driver.switchTo().window(identifier);
    }

    public static void closeWindow(String identifier){
        selectWindow(identifier);
        driver.close();
    }

    /*
    Lists windows identifiers
     */
    public static void getWindowHandles(){
        Set<String> handles = driver.getWindowHandles();
        System.out.println("handles = " + handles);
    }
}
