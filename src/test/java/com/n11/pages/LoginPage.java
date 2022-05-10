package com.n11.pages;

import com.n11.utilities.BrowserUtils;
import com.n11.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;


public class LoginPage  {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);}


    @FindBy(xpath="//*[@id='email']")
    public WebElement userName;

    @FindBy(xpath="//*[@id='password']")
    public WebElement password;

    @FindBy(xpath="(//div[@id='loginButton'])[1]")
    public WebElement loginButton;


    @FindBy(xpath="//button[.='Evet']")
    public WebElement popUpButtonEvet;




    public void login(String userNameStr, String passwordStr) {
        Actions actions= new Actions(Driver.get());
        BrowserUtils.waitForVisibility(popUpButtonEvet,10).click();
        userName.sendKeys(userNameStr);
        BrowserUtils.waitFor(4);
        password.sendKeys(passwordStr);
        BrowserUtils.waitFor(40);


    }


}