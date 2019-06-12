package com.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage extends WebdriverInitial {
    private WebDriver driver;
    public InboxPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div/div/div[1]/div/div[1]/span")
    private WebElement selectAllCheckbox;
    @FindBy (css= ".nX > div:nth-child(1)")
    private WebElement deleteAll;
    @FindBy (xpath = "/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[6]/div/div[1]/div[1]/div[2]/div/div/div")
    private WebElement messageEmpty;
    public void setSelectAllCheckbox()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(selectAllCheckbox));
        if(!selectAllCheckbox.isSelected())
        {
            selectAllCheckbox.click();
        }
    }
    // нажать на кнопку "Удалить"
    public InboxPage clickDeleteAll()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(deleteAll));
        deleteAll.click();
        return this;
    }
    // проверка появления сообщения о пустом ящике
    public boolean isEmpty()
    {
        if(messageEmpty.isDisplayed())
        {
            return true;
        }
        else return false;
    }
}
