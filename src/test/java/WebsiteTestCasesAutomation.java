import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.util.Random;

public class WebsiteTestCasesAutomation extends Functions{
    //Global Instances
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    Actions act = new Actions(driver);
    SoftAssert softassert = new SoftAssert();
    String email = "umarhassanzia88+test";
    Random rn = new Random();
    double rand = Math.floor(Math.random() * 50);
    String emailFormation = email + rand + "@gmail.com";
    String password = "Aqary@88";
    String firstname = "Umar";
    String incorrectEmail = "umar88@gmail.com";
    String incorrectPassword = "Aqary@64";


    @Test(priority = 1)
    //First Test Case: Includes 18 Steps
    public void registerUser(){
    driver.get("http://automationexercise.com");
    softassert.assertEquals(driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div/div[3]/div[1]/h1 ")).getText(), "AutomationExercise");
        WebElement signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")));
        signup.click();

        //Assertion for Signup
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2")).getText(), "New User Signup!");
        WebElement signupName = wait.until(ExpectedConditions.elementToBeClickable(By.name("name")));
        signupName.sendKeys("Umar");
        WebElement signupEmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")));


        signupEmail.sendKeys(emailFormation);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")));
        button.submit();
        String signupPagetext = "ENTER ACCOUNT INFORMATION";
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b")).getText(),signupPagetext);

        //Account Information Fields Input for Sign Up
        WebElement title = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
        title.click();
        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        pass.sendKeys(password);
        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(By.name("days")));
        Select(day);
        WebElement checkNewsletter = wait.until(ExpectedConditions.elementToBeClickable(By.name("newsletter")));
        checkNewsletter.click();
        WebElement checkSpecialOffers = wait.until(ExpectedConditions.elementToBeClickable(By.name("optin")));
        checkSpecialOffers.click();

        //Address Information
        WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.id("first_name")));
        firstName.sendKeys(firstname);
        WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(By.id("last_name")));
        lastName.sendKeys("Hassan");
        WebElement company = wait.until(ExpectedConditions.elementToBeClickable(By.id("company")));
        company.sendKeys("Template Company");
        WebElement address = wait.until(ExpectedConditions.elementToBeClickable(By.id("address1")));
        address.sendKeys("Al Rayfah Street Al Reem Island");
        WebElement countrySelect = wait.until(ExpectedConditions.elementToBeClickable(By.name("country")));
        Select(countrySelect);
        WebElement state = wait.until(ExpectedConditions.elementToBeClickable(By.id("state")));
        state.sendKeys("Al Reem Island");
        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(By.id("city")));
        city.sendKeys("Abu Dhabi");
        WebElement zipCode = wait.until(ExpectedConditions.elementToBeClickable(By.id("zipcode")));
        zipCode.sendKeys("20000");
        WebElement mobileNum = wait.until(ExpectedConditions.elementToBeClickable(By.name("mobile_number")));
        mobileNum.sendKeys("582213805");
        WebElement createAccount = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form > div > div > div > div > form > button")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", createAccount);
        createAccount.click();

        //Assertion to check if the Account is created
        String heading = "ACCOUNT CREATED!";
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2")).getText(), heading);
        WebElement continu = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Continue")));
        continu.click();

        //Assertion for checking if the user is logged in appropriately
        String userlogin = "Logged in as " + firstname;
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")).getText(),userlogin);

    }
    @Test(priority = 2)
    public void deleteAccount(){
        //Delete Account
        WebElement deleteAccount = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Delete Account")));
        deleteAccount.click();
        String deleteText = "ACCOUNT DELETED!";
        //Delete Account Assertion
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText(), deleteText);
        WebElement continueafterDelete = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Continue")));
        continueafterDelete.click();
    }
    @Test(priority = 3)
    public void loginUser(){
        driver.get("http://automationexercise.com");
        softassert.assertEquals(driver.findElement(By.xpath("/html/body/section[1]/div/div/div/div/div/div[3]/div[1]/h1 ")).getText(), "AutomationExercise");
        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")));
        login.click();
        WebElement loginElem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")));
        String loginText = "Login to your account";
        Assert.assertEquals(loginElem.getText(),loginText);
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")));
        email.sendKeys(emailFormation);
        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")));
        pass.sendKeys(password);
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")));
        submitButton.click();
        String incorrectemailpasstext = "Your email or password is incorrect!";
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).getText(), incorrectemailpasstext);


    }
    @Test(priority = 4)
    public void invokeregsiterLogin(){
        registerUser();
        loginUser();
        String loginAsserttext = "Logged in as" + firstname;
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")).getText(), loginAsserttext);
        WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Delete Account")));
        delete.click();
    }

@Test
    public void IncorrectCredentials(){
        driver.get("https://automationexercise.com/");
        WebElement category = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section[2]/div/div/div[1]/div/h2")));
        String assertCategory = "CATEGORY";
        Assert.assertEquals(category.getText(),assertCategory);

        WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")));
        login.click();
        WebElement loginElem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")));
        String loginText = "Login to your account";
        Assert.assertEquals(loginElem.getText(),loginText);
        WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")));
        email.sendKeys(incorrectEmail);
        WebElement pass = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")));
        pass.sendKeys(incorrectPassword);
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
        //Incorrect Credentails Assertion
        String incorrectemailpasstext = "Your email or password is incorrect!";
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).getText(), incorrectemailpasstext);

}
}
