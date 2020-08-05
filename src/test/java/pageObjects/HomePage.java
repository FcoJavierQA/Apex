package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class HomePage implements HelperActions{

    WebDriver driver;
    Actions actions;

    @FindBy(css="[value='View Details']")
    public List<WebElement> puppies;
    @FindBy(css="[value='Adopt Me!']")
    public WebElement adoptMeBtn;
    @FindBy(css="[value='Complete the Adoption']")
    public WebElement completeAdptn;
    @FindBy(id="order_name")
    public WebElement nameInput;
    @FindBy(id="order_address")
    public WebElement addressInput;
    @FindBy(id="order_email")
    public WebElement mailInput;
    @FindBy(id="order_pay_type")
    public WebElement paymentSelect;
    @FindBy(name="commit")
    public WebElement placeOrderBtn;
    @FindBy(id="notice")
    public WebElement msgSuccess;
    @FindBy(css="[value='Adopt Another Puppy']")
    public WebElement adoptOtherPuppy;
    @FindBy(css=".item_price")
    public List<WebElement> cartPrices;



    public HomePage(){
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver_83.0.4103.39.exe");
        this.driver = new ChromeDriver();
        this.actions = new Actions(this.driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public WebElement find(By locator) {
        waitElementToBeClickable(locator);
        return driver.findElement(locator);
    }

    @Override
    public void type(String inputText, WebElement element) {
        element.sendKeys(inputText);
    }



    @Override
    public void openPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        Assert.assertTrue(driver.getTitle().contains("Sally's Puppy Adoption Agency"));
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public void waitElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.pollingEvery(Duration.ofSeconds(3));

        WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
    }

    @Override
    public void click(WebElement element) {
        //clicks an element
    }

    @Override
    public void close() {
        driver.quit();
    }

    public void selectPuppy(int pos) {
        puppies.get(pos).click();
    }

    public void implicitWait(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void doubleClick(By locator) {
        actions.doubleClick(driver.findElement(locator)).perform();
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    public void addoptPuppy() {
        adoptMeBtn.click();
    }

    public void fillInfoForm(String userName, String address, String mail, String option ) {
        nameInput.sendKeys(userName);
        addressInput.sendKeys(address);
        mailInput.sendKeys(mail);
        Select dropdown = new Select(paymentSelect);
        dropdown.selectByValue(option);
    }

    public void placeOrder() {
        placeOrderBtn.click();
    }

    public void adoptionValidation() {
        Assert.assertTrue(msgSuccess.isDisplayed());
    }

    public void addAnotherPuppy() {
        adoptOtherPuppy.click();
    }

    public void chkCartCount(int count) {
        Assert.assertTrue(cartPrices.size() == count);
    }
}