package com.n11.pages;

import com.n11.utilities.BrowserUtils;
import com.n11.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends BrowserUtils {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[class='btnSignIn']")
    public WebElement girisYapButton;

    @FindBy(css = "a[class='menuTitle']")
    public WebElement hesabımButton;

    @FindBy(id = "searchData")
    public WebElement search;

    @FindBy(xpath = "//div[@class='accNav']//a[contains(text(),'Favorilerim / Listelerim')]")
    public WebElement favorilerimListelerimButton;

    @FindBy(xpath = "//span[@class='icon iconSearch']")
    public WebElement iconSearch;

    @FindBy(xpath = "//div//h1")
    public WebElement searchedKeyword;

    @FindBy(xpath = "//a[@class='active ']")
    public WebElement activePageNumber;

    public void selectCikisFromHesabimMenu() {
        BrowserUtils.hover(Driver.get().findElement(By.xpath("//a[@title='Hesabım'][contains(text(),'Hesabım')]")));
        Driver.get().findElement(By.cssSelector("a[title='Çıkış Yap']")).click();
    }

    public void selectFavoriListelerimFromHesabimMenu() {
        hesabımButton.click();
        Driver.get().findElement(By.xpath("//div[@class='accNav']//a[contains(text(),'Favorilerim / Listelerim')]")).click();
    }

    public WebElement addFavoriteList(int productNumber) {
        return Driver.get().findElement(By.xpath("//li[@class='column '][" + productNumber + "]//span[@title='Favorilere ekle']"));
    }

    public void goToPageNumber(int pageNumber) {
        Driver.get().findElement(By.xpath("//a[.='" + pageNumber + "']")).click();
    }

    public void navigateTo(String tab) {
        String tabLocator = "[data-id='" + tab + "']";
        BrowserUtils.waitForClickablility((WebElement) By.cssSelector(tabLocator), 10);
        Driver.get().findElement(By.cssSelector(tabLocator)).click();
    }
}