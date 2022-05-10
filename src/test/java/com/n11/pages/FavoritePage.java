package com.n11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FavoritePage extends BasePage{

    @FindBy(css = "li[class='wishGroupListItem favorites'] h4[class='listItemTitle']")
    public WebElement favorilerimButton2;


    @FindBy(xpath = "(//h2[normalize-space()='Favorilerim'])[1]")
    public WebElement favorilerimHeader;


    @FindBy(css = "[class='deleteProFromFavorites']")
    public WebElement silButton;


    @FindBy(css = "[class='btn btnBlack confirm']")
    public WebElement tamamButton;


    @FindBy(css = "[class='.column.wishListColumn']")
    public List<WebElement> favoriteProduct;

}
