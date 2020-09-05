package prestashop;

import static UI.browserManagement.refreshPage;
import static UI.element.*;
import static UI.wait.waitUntilPageContainsElement;

public class cart {
    static public final String CART_URL = "http://localhost:8888/prestashop/cart?action=show";
    static public final String SEARCH_INP = "name=s";
    static public final String FIRST_ELEMENT_IMG = "xpath=(//div[@class='highlighted-informations no-variants hidden-sm-down'])[1]";
    static public final String QUICK_VIEW_A = "xpath=(//div[@class='highlighted-informations no-variants hidden-sm-down'])[1]//a";
    static public final String ADD_TO_CART_DIV = "xpath=//div[@class='modal fade quickview in']//button[@class='btn btn-primary add-to-cart']";
    static public final String PROD_ADDED_TXT = "xpath=//div[@id='blockcart-modal']//h4[text()='Product successfully added to your shopping cart']";
    static public final String FIRST_PRODUCT_A = "xpath=(//div[@id='js-product-list']//div//h2//a)[1]";
    static public final String ADD_TO_CART_BTN = "xpath=//form[@id='add-to-cart-or-refresh']//button[@class='btn btn-primary add-to-cart']";
    static public final String DELETE_BTN = "xpath=//section[@id='main']//i[@class='material-icons float-xs-left']";
    static public final String CONTINUE_SHOPPING_BTN = "xpath=//div[@class='cart-content-btn']//button[@class='btn btn-secondary']";
    static public final String FRAMED_POSTER = "The best is yet to come' Framed poster";
    static public final String MUG = "Mug The adventure begins";
    static public final String NO_ITEMS = "class=no-items";

    public static void addProductToCart(String product){
        clearElementText(SEARCH_INP);
        inputTextAndSubmit(SEARCH_INP, product);
        waitUntilPageContainsElement(FIRST_ELEMENT_IMG);
        mouseOver(FIRST_ELEMENT_IMG);
        clickElement(QUICK_VIEW_A);
        waitUntilPageContainsElement(ADD_TO_CART_DIV);
        clickElement(ADD_TO_CART_DIV);
        waitUntilPageContainsElement(PROD_ADDED_TXT, 10);
    }

    public static void emptyCart(){
        int count = getElementCount(DELETE_BTN);
        for (int i = 0; i < count; i++){
            clickElement(DELETE_BTN);
            refreshPage();
        }
        waitUntilPageContainsElement(NO_ITEMS);
    }
}
