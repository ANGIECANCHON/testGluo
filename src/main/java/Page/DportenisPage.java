package Page;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


@DefaultUrl(" https://www.dportenis.mx/")

public class DportenisPage extends PageObject{

    private String messageError;

    @FindBy(xpath = ".//div[@class = 'subContLinksDerecha']")
    WebElementFacade registerOrLogin;

    @FindBy(xpath = "//input[@name=\"logonId\"]")
    WebElementFacade txtEmail;

    @FindBy(xpath = ".//input[@name=\"logonPassword\"]")
    WebElementFacade txtPassword;

    @FindBy(xpath = ".//div[@class=\"content_botones\"]")
    WebElementFacade btnEnter;

    @FindBy(xpath = ".//span[@class=\"myaccount_error\"]")
    WebElementFacade messageErrorLogin;

    @FindBy(xpath = ".//*[@class=\"departmentButton\"]/span[.=\"Ofertas\"]")
    WebElementFacade offers;

    @FindBy(xpath = ".//div[@class=\"image\"][1]")
    WebElementFacade product;

    @FindBy(xpath = ".//div[@id=\"productPageAdd2Cart\"]")
    WebElementFacade addTocart;

    @FindBy(xpath = ".//*[@id=\"ErrorMessageText\"]")
    WebElementFacade errorMessageSize;

    @FindBy(xpath = ".//*[@id=\"attrValue_1_5_-2017_25704\"]/tbody/tr/td[2]")
    WebElementFacade showSizes;

    @FindBy(xpath = ".//*[@id=\"dijit_MenuItem_1_text\"]")
    WebElementFacade size;

    @FindBy(xpath = ".//*[@id=\"shoppingCartFixed\"]")
    WebElementFacade shoppingCart;

    @FindBy(xpath = "//div[@class=\"close-button\"]/a[@class=\"remove_product_button\"]")
    WebElementFacade closeButton;

    public DportenisPage(WebDriver driver) {
        super(driver);
    }

    public void goToLogin(){
        registerOrLogin.click();
    }

    public void enterEmail(String email){
        txtEmail.waitUntilClickable().click();
        txtEmail.sendKeys(email);
    }

    public void enterPassword(String password){
        txtPassword.waitUntilClickable().click();
        txtPassword.sendKeys(password);
    }

    public void clicEnter(){
        btnEnter.waitUntilClickable().click();
    }

    public boolean showError(){
        String textError;
        textError = messageErrorLogin.getText();
        return textError.isEmpty() ? false:true;
    }

    public void selectProduct(){
        offers.waitUntilClickable().click();
        product.waitUntilClickable().getText();
        product.waitUntilClickable().click();
    }

    public boolean addTocartError(){
        addTocart.waitUntilClickable().click();
        messageError = errorMessageSize.waitUntilClickable().getText();
        return messageError.isEmpty() ? false:true;
    }

    public void addTocart(){
        showSizes.waitUntilClickable().click();
        size.waitUntilClickable().click();
        addTocart.waitUntilClickable().click();
    }

    public String verifyProduct(){
        shoppingCart.click();
        if(closeButton == null){
            return null;
        }
        closeButton.click();
        messageError = errorMessageSize.waitUntilClickable().getText();
        return messageError;
    }
}
