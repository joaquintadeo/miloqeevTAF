package prestashop;

import static UI.browserManagement.refreshPage;
import static UI.element.*;
import static UI.wait.waitUntilPageContainsElement;

public class checkout {
    static public final String CHECKOUT_URL = "http://localhost:8888/prestashop/cart?action=show";
    static public final String PROCEED_BTN = "xpath=//section[@id='main']//a[@class='btn btn-primary']";
    static public final String CONFIRM_ADDRESS_BTN = "name=confirm-addresses";
    static public final String CONFIRM_DELIVERY_BTN = "name=confirmDeliveryOption";
    static public final String PAY_BANK_OPT = "id=payment-option-2";
    static public final String AGREE_CHECKBOX = "id=conditions_to_approve[terms-and-conditions]";
    static public final String ORDER_BTN = "xpath=//div[@id='payment-confirmation']//button[@class='btn btn-primary center-block']";
    static public final String CONFIRMATION_TXT = "xpath=//section[@id='content-hook_order_confirmation']//i[@class='material-icons rtl-no-flip done']";
    static public final String GENDER_RADIO = "xpath=//input[@name='id_gender' and @value='1']";
    static public final String NAME_INP = "name=firstname";
    static public final String LASTNAME_INP = "name=lastname";
    static public final String EMAIL_INP = "name=email";
    static public final String AGREE_INP = "name=psgdpr";
    static public final String CONTINUE_BTN = "name=continue";
    static public final String ADDRESS_INP = "name=address1";
    static public final String CITY_INP = "name=city";
    static public final String STATE_LIST = "name=id_state";
    static public final String POSTAL_INP = "name=postcode";
}
