package prestashop;

import static UI.browserManagement.*;
import static UI.element.*;
import static UI.wait.waitUntilPageContainsElement;
import static UI.window.maximizeBrowserWindow;
import static prestashop.login.*;

public class search {
    static public final String SEARCH_INP = "name=s";
    static public final String FIRST_ELEMENT_IMG = "xpath=(//div[@class='highlighted-informations no-variants hidden-sm-down'])[1]";
    static public final String FIRST_PRODUCT_A = "xpath=(//div[@id='js-product-list']//div//h2//a)[1]";
    static public final String NO_RESULTS_DIV = "xpath=//section[@id='content']//h4[text()='Sorry for the inconvenience.']";
}
