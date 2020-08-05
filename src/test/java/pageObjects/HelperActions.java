package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface HelperActions {

        public WebElement find(By locator);
        public void click(WebElement element);
        public void type(String inputText, WebElement element);
        public void openPage(String url);
        public String getTitle();
        public void waitElementToBeClickable(By locator);
        public void close();

}
