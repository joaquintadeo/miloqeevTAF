import facetPage.main;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class facet {

    @AfterMethod
    public void teardown(){
        main.close_browser();
    }
    @Test
    public void facetLogo(){
        main.Given_user_opens_a_browser();
        main.When_user_navigates_to_facet_web_page();
        main.Then_user_must_see_facet_logo();
    }
}
