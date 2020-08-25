package prestashop;

import static UI.browserManagement.*;
import static UI.element.*;
import static UI.wait.*;
import static UI.window.maximizeBrowserWindow;
import static prestashop.login.*;
import static prestashop.login.SIGN_IN_BTN;

public class cart {
    static public final String SEARCH_INP = "s";
    static public final String FIRST_ELEMENT_IMG = "(//div[@class='highlighted-informations no-variants hidden-sm-down'])[1]";
    static public final String QUICK_VIEW_A = "(//div[@class='highlighted-informations no-variants hidden-sm-down'])[1]//a";
    static public final String ADD_TO_CART_DIV = "//div[@id='quickview-modal-3-13']//button[@class='btn btn-primary add-to-cart']";
    static public final String PROD_ADDED_TXT = "//div[@id='blockcart-modal']//h4[text()='Product successfully added to your shopping cart']";
    static public final String FIRST_PRODUCT_A = "(//div[@id='js-product-list']//div//h2//a)[1]";
    static public final String ADD_TO_CART_BTN = "//form[@id='add-to-cart-or-refresh']//button[@class='btn btn-primary add-to-cart']";

    public static void userLogIn(){
        openBrowser("chrome");
        maximizeBrowserWindow();
        setBrowserImplicitWait(600);
        goTo(BASE_URL);
        clickElement("xpath", SIGN_IN_A);
        pageShouldContainElement("id", LOGIN_FORM);
        inputText("name", EMAIL_INP, "miloqeevtaf@framework.com");
        inputText("name", PASS_INP, "Automation123!");
        clickElement("id", SIGN_IN_BTN);
        waitUntilPageContainsElement("xpath", SIGN_OUT_A);
    }
}
