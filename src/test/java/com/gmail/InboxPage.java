package com.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage extends WebdriverInitial {
    private final WebDriver driver;
    public InboxPage( final WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //кнопка выпадающего списка
    @FindBy (css  = "[class='G-asx T-I-J3 J-J5-Ji']:nth-child(2)")
    private WebElement arrowDown;
    // выбрать все
    @FindBy(css = "[selector='all']")
    private WebElement selectAll;
    // удалить все
   @FindBy(css = "[class='T-I J-J5-Ji nX T-I-ax7 T-I-Js-Gs mA']")
   private WebElement deleteAll;
    // сообщение о пустом ящике
    @FindBy(css = "#\\:28 > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
    private WebElement messageEmpty;
    public void setSelectAllCheckbox()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //ожидание пока кнопка выпадающего списка станет кликабельной
        wait.until(ExpectedConditions.elementToBeClickable(arrowDown));
        arrowDown.click();
        //ожидание пока кнопка "Выбрать все" станет кликабельной
        wait.until(ExpectedConditions.elementToBeClickable(selectAll));
        selectAll.click();
    }
    // нажать на кнопку "Удалить"
    public InboxPage clickDeleteAll()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
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
