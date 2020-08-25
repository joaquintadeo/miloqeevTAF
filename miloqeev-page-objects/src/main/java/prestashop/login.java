package prestashop;

public class login {
    static public final String BASE_URL = "http://localhost:8888/prestashop/";
    static public final String SIGN_IN_A = "xpath=//div[@id='_desktop_user_info']//a";
    static public final String LOGIN_FORM = "id=login-form";
    static public final String EMAIL_INP = "name=email";
    static public final String PASS_INP = "name=password";
    static public final String SIGN_IN_BTN = "id=submit-login";
    static public final String SIGN_OUT_A = "xpath=//div[@id='_desktop_user_info']//a[@class='logout hidden-sm-down']";
    static public final String AUTH_FAIL_TXT = "xpath=//li[@class='alert alert-danger' and text()='Authentication failed.']";
}
