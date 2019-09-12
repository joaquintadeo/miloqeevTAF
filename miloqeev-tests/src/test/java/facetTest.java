import UI.functions;
import UI.utils;
import Google.basePage;
import facetTest.pageObjects;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class facetTest {
    private static int name = utils.NAME;
    private static int xpath = utils.XPATH;
    private static int classname = utils.CLASSNAME;
    private static String googleURl = basePage.googleUrl;
    private static String searchBarr = basePage.searchBarr;
    private static String facetXpath = pageObjects.facetXpath;
    private static String facetLink = pageObjects.facetLink;
    private static String facetLogo = pageObjects.facetLogo;

    @BeforeMethod
    public void setup(){
        functions.openBrowser();
    }

    @AfterMethod
    public void teardown(){
        functions.closeBrowser();
    }

    @Test
    public void searchFacet(){
        functions.goTo(googleURl);
        functions.inputText(name, searchBarr, "facet");
        functions.waitUntilPageContainsElement(xpath, facetXpath);
        functions.clickElement(xpath, facetLink);
        functions.waitUntilPageContainsElement(classname, facetLogo);
    }
}
