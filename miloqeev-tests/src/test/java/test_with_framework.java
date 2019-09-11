import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_with_framework {

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
        functions.goTo(pageObjects.googleUrl);
        functions.inputText(utils.NAME, pageObjects.searchBarr, "facet");
        functions.waitUntilPageContainsElement(utils.XPATH, pageObjects.facetXpath);
    }
}
