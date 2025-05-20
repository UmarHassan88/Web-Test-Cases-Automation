import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Random;

public class locateFunctions {
    WebDriver driver;

    @FindBy(name = "name")
    WebElement name;

    @FindBy(name = "email")
    WebElement email;

    public locateFunctions(WebDriver driver) {
        this.driver = driver;
    }

    public void initialize(WebDriver driver){

         PageFactory.initElements(driver, this);
    }

    public void signUp(String passname, String sendemail){
        name.sendKeys(passname);
        email.sendKeys(sendemail);
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
    WebElement products;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
    WebElement allproductsAssert;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a")
    WebElement viewProd;

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b")
    WebElement availabilityAssert;

    public void clickProducts(){
        products.click();
        Assert.assertEquals(allproductsAssert.getText(),"ALL PRODUCTS");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        viewProd.click();
        Assert.assertTrue(availabilityAssert.isDisplayed());
        //Assertion for Name, Price and Quantity
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/label")).getText(), "Quantity:");

    }

    @FindBy(xpath = "/html/body/footer/div[1]/div/div/div[2]/div/form/input[2]")
    WebElement subscription;

    @FindBy(id = "subscribe")
    WebElement subscribeButton;

    public void verifySubscription() throws InterruptedException {
        //Scrolling Down the Bottom of the Page
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")).getText(), "SUBSCRIPTION");
        //Random Email generation each time
        Random random = new Random();
        int ran = random.nextInt(50);
        String email = "umarhassanzia88+" + "test" +ran + "@gmail.com";
        subscription.sendKeys(email);
        subscribeButton.click();
    }
}

