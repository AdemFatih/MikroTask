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

public class FavoriteProductStepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    FavoritePage favoritePage = new FavoritePage();
    int listOfFavoriteProduct;


    @Given("the user go to n11 url")
    public void theUserGoToNUrl() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("verify the user is on the homepage")
    public void verifyTheUserIsOnTheHomepage() {
        Assert.assertEquals("n11.com - Hayat Sana Gelir", Driver.get().getTitle());

    }

    @When("the user login with valid credentials")
    public void theUserLoginWithValidCredentials()  {
        homePage.girisYapButton.click();
        loginPage.login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));

    }

    @Then("verify the user can login successfully")
    public void verifyTheUserCanLoginSuccessfully() {
        //menüLink user Başaralı giriş yaptıktan sonra oluşan bir element olduğu için True döndüğünde giriş başarılıdır
        Assert.assertTrue(Driver.get().getPageSource().contains("menuLink user"));
    }

    @When("the user search {string} keyword")
    public void theUserSearchKeyword(String productName) {
        homePage.search.sendKeys(productName);
    }

    @Then("verify {string} keyword is searched")
    public void verifyKeywordIsSearched(String productName) {

        Assert.assertEquals(productName,BrowserUtils.waitForVisibility(homePage.searchedKeyword,10).getText());

    }

    @When("the user go to {int}. page")
    public void theUserGoToPage(int pageNumber) {
        homePage.goToPageNumber(pageNumber);

    }

    @Then("verify the user is on the {int}. page")
    public void verifyTheUserIsOnThePage(int expectedPageNumber) {
        Assert.assertEquals(String.valueOf(expectedPageNumber), homePage.activePageNumber.getText());

    }

    @When("the user add {int}. product to favoritelist")
    public void theUserAddProductToFavoritelist(int productNumber) {
        homePage.addFavoriteList(productNumber).click();

    }


    @And("the user go to {string}")
    public void theUserGoTo(String optionName) {
        BrowserUtils.hover(homePage.hesabımButton);
        homePage.dropdownHesabım(optionName);
        favoritePage.favorilerimButton2.click();
    }


    @Then("verify the user is on the favoritelist")
    public void verifyTheUserIsOnTheFavoritelist() {
        Assert.assertEquals("Favorilerim", favoritePage.favorilerimHeader.getText());

    }

    @When("the user delete the product from the favoritelist")
    public void theUserDeleteTheProductFromTheFavoritelist() {
        listOfFavoriteProduct = favoritePage.favoriteProduct.size();
        favoritePage.silButton.click();
        favoritePage.tamamButton.click();
    }

    @Then("verify the product is delete")
    public void verifyTheProductIsDelete() {
        Assert.assertEquals(listOfFavoriteProduct, favoritePage.favoriteProduct.size() + 1);

    }

    @When("the user click to {string} button")
    public void theUserClickToButton(String optionName) {
        BrowserUtils.hover(homePage.hesabımButton);
        homePage.dropdownHesabım(optionName);
    }

    @Then("verify the user log out successfully")
    public void verifyTheUserLogOutSuccessfully() {
        Assert.assertFalse(Driver.get().getPageSource().contains("menuLink user"));


    }


}