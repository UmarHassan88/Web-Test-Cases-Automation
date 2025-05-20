import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Functions {
WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void Select(WebElement elem){
        Select selectElem = new Select(elem);
        selectElem.selectByIndex(1);
    }
    public WebElement getId(String id){
        return driver.findElement(By.id(id));

    }

    public WebElement getName(String name){
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
        return elem;
    }

    public WebElement getClassname(String classname){
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.className(classname)));
        return elem;
    }

    public WebElement getXpath(String xpath){
        WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return elem;
    }
}
