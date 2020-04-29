package Definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import Step.DportenisStep;
import org.junit.Assert;

public class DportenisDefinition {
    @Steps
    DportenisStep dportenisStep;
    private boolean response;
    private String messageError;

    @Given("^I login with the email (.*) and password (.*)$")
    public void login(String email, String password) {
        dportenisStep.loginDeportenis(email, password);
    }

    @Then("^The data is incorrect and show me an error message$")
    public void errorLogin() {
        response = dportenisStep.messageErrorLogin();
        Assert.assertTrue(response);
    }

    @Given("I choose one product to add to my cart without add the size")
    public void addToCartError() {
        dportenisStep.selectProductStep();
    }

    @Then("Do not add the producto and show me an error message that the size is missing")
    public void sizeError() {
        response = dportenisStep.messageErrorSize();
        Assert.assertTrue(response);
    }

    @Given("I choose one product to add to my cart with the size")
    public void addToCart() {
        dportenisStep.selectProductStep();
        dportenisStep.addToCart();
    }

    @Then("I see my prducts into the cart correctly")
    public void seeProducts() {
        messageError = dportenisStep.verifyProduct();
        Assert.assertNotNull(messageError);
    }
}
