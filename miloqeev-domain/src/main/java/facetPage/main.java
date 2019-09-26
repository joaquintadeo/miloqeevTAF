package facetPage;
import UI.functions;
import UI.utils;
import UI.browserManagement;
import com.aventstack.extentreports.ExtentTest;

public class main {
    private static int classname = utils.CLASSNAME;
    private static String facetLogo = facetLandingPage.facetLogo;
    private static String facetUrl = facetLandingPage.facetUrl;
    ExtentTest test;

    public main(ExtentTest test) {
        this.test = test;
    }

    public void Given_user_opens_a_browser(){
        test.createNode("Given_user_opens_a_browser");
        browserManagement.openBrowser("chrome");
        browserManagement.setBrowserImplicitWait(600);
        browserManagement.maximizeBrowserWindow();
    }

    public void When_user_navigates_to_facet_web_page(){
        test.createNode("When_user_navigates_to_facet_web_page");
        browserManagement.goTo(facetUrl);
    }

    public void Then_user_must_see_facet_logo(){
        test.createNode("Then_user_must_see_facet_logo");
        functions.PageShouldContainElement(classname, "trezo");
    }

    public void close_browser(){
        test.createNode("close_browser");
        browserManagement.closeBrowser();
    }
}
