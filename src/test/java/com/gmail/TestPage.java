package com.gmail;

import org.junit.Test;

public class TestPage extends WebdriverInitial {
    private String emailLogin = "testsasha0405@gmail.com";
    private String emailPassword = "Sasha1988";
    @Test
    public void testEmail()
    {
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
