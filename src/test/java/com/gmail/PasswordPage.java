package com.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PasswordPage extends WebdriverInitial{

    private final WebDriver driver;
    public PasswordPage( final WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".I0VJ4d > div:nth-child(1) > input:nth-child(1)")
    private WebElement password;
    @FindBy (xpath = "/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/span/span")
    private WebElement onwardPassButton;

    // указать пароль от почты
    public void setPassword(String pass)
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pass);
    }
    // нажать на кнопку "Далее" после пароля
    public InboxPage clickOnwardPassButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(onwardPassButton));
        onwardPassButton.click();
        return new InboxPage(driver);
    }
}
