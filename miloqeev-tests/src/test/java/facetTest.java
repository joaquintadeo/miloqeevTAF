import UI.functions;
import UI.utils;
import UI.browserManagement;
import facetPage.pageObjects;
import googlePage.googleLandingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class facetTest {
    private static int name = utils.NAME;
    private static int xpath = utils.XPATH;
    private static int classname = utils.CLASSNAME;
    private static String googleURl = googleLandingPage.Url;
    private static String searchBarr = googleLandingPage.searchBarr;
    private static String facetXpath = pageObjects.facetXpath;
    private static String facetLink = pageObjects.facetLink;
    private static String facetLogo = pageObjects.facetLogo;

    @BeforeMethod
    public void setup(){
        browserManagement.openBrowser("chrome");
        browserManagement.setBrowserImplicitWait(600);
        browserManagement.maximizeBrowserWindow();
    }

    @AfterMethod
    public void teardown(){
        browserManagement.closeBrowser();
    }

    @Test
    public void searchFacet(){
        browserManagement.goTo(googleURl);
        functions.inputText(name, searchBarr, "facet");
        functions.waitUntilPageContainsElement(xpath, facetXpath);
        functions.clickElement(xpath, facetLink);
        functions.waitUntilPageContainsElement(classname, facetLogo);
    }
}
