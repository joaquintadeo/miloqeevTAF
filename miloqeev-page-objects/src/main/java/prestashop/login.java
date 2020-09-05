package prestashop;

import static UI.browserManagement.*;
import static UI.element.*;
import static UI.wait.waitUntilPageContainsElement;
import static UI.window.maximizeBrowserWindow;

public class login {
    static public final String BASE_URL = "http://localhost:8888/prestashop/";
    static public final String SIGN_IN_A = "xpath=//div[@id='_desktop_user_info']//a";
    static public final String LOGIN_FORM = "id=login-form";
    static public final String EMAIL_INP = "name=email";
    static public final String PASS_INP = "name=password";
    static public final String SIGN_IN_BTN = "id=submit-login";
    static public final String SIGN_OUT_A = "xpath=//div[@id='_desktop_user_info']//a[@class='logout hidden-sm-down']";
    static public final String AUTH_FAIL_TXT = "xpath=//li[@class='alert alert-danger' and text()='Authentication failed.']";

    public static void userLogIn(String user, String password){
        openBrowser("chrome");
        maximizeBrowserWindow();
        setBrowserImplicitWait(600);
        goTo(BASE_URL);
        clickElement(SIGN_IN_A);
        pageShouldContainElement(LOGIN_FORM);
        inputText(EMAIL_INP, user);
        inputText(PASS_INP, password);
        clickElement(SIGN_IN_BTN);
        waitUntilPageContainsElement(SIGN_OUT_A);
    }
}
