package Step;

import Page.DportenisPage;
import org.fluentlenium.core.annotation.Page;

public class DportenisStep {
    @Page DportenisPage deportenispage;

    private boolean response;
    private String messageError;

    public void loginDeportenis(String email, String password){
        deportenispage.open();
        deportenispage.goToLogin();
        deportenispage.enterEmail(email);
        deportenispage.enterPassword(password);
        deportenispage.clicEnter();
    }

    public boolean messageErrorLogin(){
        response = deportenispage.showError();

        return response;
    }

    public void selectProductStep(){
        deportenispage.open();
        deportenispage.selectProduct();
    }

    public boolean messageErrorSize(){
        response = deportenispage.addTocartError();
        return response;
    }

    public void addToCart(){
        deportenispage.addTocart();

    }

    public String verifyProduct(){
        messageError = deportenispage.verifyProduct();

        return messageError;
    }
}
