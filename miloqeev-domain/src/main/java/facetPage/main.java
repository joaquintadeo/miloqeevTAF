package facetPage;
import UI.functions;
import UI.utils;
import UI.browserManagement;
import UI.wait;
import UI.window;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Dimension;

public class main {
    private static int classname = utils.CLASSNAME;
    private static int xpath = utils.XPATH;
    private static String facetLogo = facetLandingPage.facetLogo;
    private static String facetUrl = facetLandingPage.facetUrl;
    private static String siuGuarani = "(//a[@href='https://www.facet.unt.edu.ar/siu-guarani-acceso/'])[3]";
    ExtentTest test;

    public main(ExtentTest test) {
        this.test = test;
    }

    public void Given_user_opens_a_browser(){
        test.createNode("Given_user_opens_a_browser");
        browserManagement.openBrowser("chrome");
        browserManagement.setBrowserImplicitWait(600);
        window.maximizeBrowserWindow();
    }

    public void When_user_navigates_to_facet_web_page(){
        test.createNode("When_user_navigates_to_facet_web_page");
        browserManagement.goTo(facetUrl);
    }

    public void Then_user_must_see_facet_logo(){
        test.createNode("Then_user_must_see_facet_logo");
        functions.PageShouldContainElement(classname, facetLogo);
        wait.waitUntilPageContainsElement(xpath, siuGuarani,20);
        String handle = window.getWindowHandle();
        functions.clickElement(xpath, siuGuarani);
        wait.waitUntilPageContainsElement(classname, facetLogo, 10);
        window.selectWindow(handle);

    }

    public void close_browser(){
        test.createNode("close_browser");
        browserManagement.closeBrowser();
    }
}
