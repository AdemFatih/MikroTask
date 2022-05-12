package com.n11.pages;

import com.n11.utilities.BrowserUtils;
import com.n11.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id='email']")
    public WebElement userName;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "(//div[@id='loginButton'])[1]")
    public WebElement loginButton;

    @FindBy(xpath = "//button[.='Evet']")
    public WebElement popUpButtonEvet;

    public void login(String userNameStr, String passwordStr) {
        BrowserUtils.waitForVisibility(popUpButtonEvet, 10).click();
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        loginButton.click();
    }
}