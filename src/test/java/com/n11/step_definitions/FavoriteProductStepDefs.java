package com.n11.step_definitions;

import com.n11.pages.FavoritePage;
import com.n11.pages.HomePage;
import com.n11.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.n11.utilities.ConfigurationReader;
import com.n11.utilities.Driver;
import com.n11.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.awt.*;
import java.io.IOException;

public class FavoriteProductStepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    FavoritePage favoritePage = new FavoritePage();
    int numberOfFavoriteProductBeforeDeleteOperation;
    int numberOfFavoriteProductAfterDeleteOperation;

    @Given("the user go to n11 url")
    public void theUserGoToNUrl() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("verify the user is on the homepage")
    public void verifyTheUserIsOnTheHomepage() throws IOException, AWTException {
        Assert.assertEquals("n11.com - Hayat Sana Gelir", Driver.get().getTitle());
    }

    @When("the user login with valid credentials")
    public void theUserLoginWithValidCredentials() throws IOException, AWTException {
        homePage.girisYapButton.click();
        loginPage.login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
    }

    @Then("verify the user can login successfully")
    public void verifyTheUserCanLoginSuccessfully() throws IOException, AWTException {
        //menüLink user Başaralı giriş yaptıktan sonra oluşan bir element olduğu için True döndüğünde giriş başarılıdır
        Assert.assertTrue(Driver.get().getPageSource().contains("menuLink user"));
    }

    @When("the user search {string} keyword")
    public void theUserSearchKeyword(String productName) throws IOException, AWTException {
        homePage.search.sendKeys(productName);
        homePage.iconSearch.click();
    }

    @Then("verify {string} keyword is searched")
    public void verifyKeywordIsSearched(String productName) throws IOException, AWTException {
        Assert.assertTrue(BrowserUtils.waitForVisibility(homePage.searchedKeyword, 10).getText().contains(productName));
    }

    @When("the user go to {int}. page")
    public void theUserGoToPage(int pageNumber) throws IOException, AWTException {
        homePage.goToPageNumber(pageNumber);
    }

    @Then("verify the user is on the {int}. page")
    public void verifyTheUserIsOnThePage(int expectedPageNumber) throws IOException, AWTException {
        Assert.assertEquals(String.valueOf(expectedPageNumber), homePage.activePageNumber.getText());
    }

    @When("the user add {int}. product to favoritelist")
    public void theUserAddProductToFavoritelist(int productNumber) {
        homePage.addFavoriteList(productNumber).click();
    }

    @And("the user go to Favorilerim-Listelerim")
    public void theUserGoToFavorilerimListelerim() throws IOException, AWTException {
        homePage.selectFavoriListelerimFromHesabimMenu();
        favoritePage.favorilerimButton2.click();
    }

    @Then("verify the user is on the favoritelist")
    public void verifyTheUserIsOnTheFavoritelist() throws IOException, AWTException {
        Assert.assertEquals("Favorilerim", favoritePage.favorilerimHeader.getText());
    }

    @When("the user delete the product from the favoritelist")
    public void theUserDeleteTheProductFromTheFavoritelist() {
        numberOfFavoriteProductBeforeDeleteOperation = Driver.get().findElements(By.cssSelector("[class='deleteProFromFavorites']")).size();
        favoritePage.silButton.click();
        favoritePage.tamamButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("verify the product is delete")
    public void verifyTheProductIsDelete() throws IOException, AWTException {
        numberOfFavoriteProductAfterDeleteOperation = Driver.get().findElements(By.cssSelector("[class='deleteProFromFavorites']")).size();
        Assert.assertTrue(numberOfFavoriteProductBeforeDeleteOperation > numberOfFavoriteProductAfterDeleteOperation);
    }

    @When("the user click to Çıkış Yap button")
    public void theUserClickToButton() throws IOException, AWTException {
        homePage.selectCikisFromHesabimMenu();
    }

    @Then("verify the user log out successfully")
    public void verifyTheUserLogOutSuccessfully() throws IOException, AWTException {
        Assert.assertFalse(Driver.get().getPageSource().contains("menuLink user"));
    }
}