package Runner;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pageObjects.HomePage;

public class StepsDefinition{

    HomePage webApp;

    public StepsDefinition() {
        this.webApp = new HomePage();
    }

    @After("@TestMain")
    public void testEnd(){
        webApp.close();
    }

    @Given("The user is able to open the page {string}")
    public void navigate(String url) {
        webApp.openPage(url);
    }

    @When("Select puppy {int} by clicking View Details button")
    public void selectPuppy(int number) {

        webApp.selectPuppy(number);

    }

    @Then("^The user click on Adopt Me! button$")
    public void adoptionPuppy() {

        webApp.addoptPuppy();

    }

    @Then("^User clicks on Complete the Adoption button$")
    public void  clickAdoption() {

        webApp.waitElementToBeClickable(By.cssSelector("[value='Complete the Adoption']"));
        webApp.completeAdptn.click();

    }

    @Then("^The user fill adoption form$")
    public void fillAdptnForm() {

        webApp.fillInfoForm("UserNumber1", "San Francisco", "user@mail.com", "Credit card");

    }

    @Then("^The user clicks Place Order button$")
    public void makeOrder() {

        webApp.placeOrder();

    }

    @Then("^Validate the message of success is displayed$")
    public void msgValidation() {

        webApp.adoptionValidation();

    }

    @Then("^User clicks on add another puppy button$")
    public void adoptAnotherPuppy() {

        webApp.addAnotherPuppy();

    }

    @Then("Validate that all {int} puppies have been added to the cart")
    public void validateCartCount(int count) {

            webApp.chkCartCount(count);

    }



}