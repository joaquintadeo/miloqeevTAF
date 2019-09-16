package facetPage;
import UI.functions;
import UI.utils;
import UI.browserManagement;

public class main {
    private static int classname = utils.CLASSNAME;
    private static String facetLogo = facetLandingPage.facetLogo;
    private static String facetUrl = facetLandingPage.facetUrl;

    public static void Given_user_opens_a_browser(){
        browserManagement.openBrowser("chrome");
        browserManagement.setBrowserImplicitWait(600);
        browserManagement.maximizeBrowserWindow();
    }

    public static void When_user_navigates_to_facet_web_page(){
        browserManagement.goTo(facetUrl);
    }

    public static void Then_user_must_see_facet_logo(){
        functions.waitUntilPageContainsElement(classname, facetLogo);
    }

    public static void close_browser(){
        browserManagement.closeBrowser();
    }
}
