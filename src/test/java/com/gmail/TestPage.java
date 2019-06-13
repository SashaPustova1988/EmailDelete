package com.gmail;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestPage extends WebdriverInitial {
    private String emailLogin = "testsasha0405@gmail.com";
    private String emailPassword = "Sasha1988";
    @Test
    public void testEmail() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin(emailLogin);
        loginPage.clickOnwardLoginButton();
        PasswordPage passPage = new PasswordPage(driver);
        passPage.setPassword(emailPassword);
        passPage.clickOnwardPassButton();
        InboxPage inboxPage = new InboxPage (driver);

        while(!inboxPage.isEmpty()){
        inboxPage.setSelectAllCheckbox();
        inboxPage.clickDeleteAll();
       }
    }
}
