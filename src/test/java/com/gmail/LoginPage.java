package com.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends WebdriverInitial {
    private final WebDriver driver;
    public LoginPage( final FirefoxDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "identifierId")
    private WebElement login;
    @FindBy (className = "CwaK9")
    private WebElement onwardLoginButton;

    //указать почту (логин)
    public void setLogin(String email)
    {
        login.sendKeys(email);
    }
    //нажать на кнопку "Далее" после логина
    public PasswordPage clickOnwardLoginButton()
    {
      onwardLoginButton.click();
        return new PasswordPage(driver);
    }

}
