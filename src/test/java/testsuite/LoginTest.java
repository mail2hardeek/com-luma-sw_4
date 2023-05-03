package testsuite;

import com.luma.sw4.pages.GearTest;
import com.luma.sw4.pages.HomePage;
import com.luma.sw4.pages.MenTest;
import com.luma.sw4.pages.WomenTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import testbase.BaseTest;

public class LoginTest extends BaseTest {
    HomePage homePage = new HomePage();
    GearTest gearPage = new GearTest();
    MenTest menPage = new MenTest();
    WomenTest womenPage = new WomenTest();

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        //1. userShouldAddProductSuccessFullyToShoppingCart()
        homePage.hoverOnGearMenu();                                                                          //* Mouse Hover on Gear Menu
        homePage.clickOnBags();                                                                              //* Click on Bags
        gearPage.clickOnOvernightDuffle();                                                                   //* Click on Product Name ‘Overnight Duffle’
        Assert.assertEquals(gearPage.getTextOvernightDuffle(), "Overnight Duffle", "Error"); //* Verify the text ‘Overnight Duffle’
        gearPage.changeQuantity();                                                                           //* Change Qty 3
        gearPage.clickOnAddToCartButton();                                                                   //* Click on ‘Add to Cart’ Button.
        Assert.assertEquals(gearPage.gettextaddedDuffle(), "You added Overnight Duffle to your shopping cart.", "Error");   //* Verify the text ‘You added Overnight Duffle to your shopping cart.’
        gearPage.clickOnShoppingCartLink();                                                                  //* Click on ‘shopping cart’ Link into message
        Assert.assertEquals(gearPage.gettextCronusYogaPant(), "Overnight Duffle", "Error");   //* Verify the product name ‘Overnight Duffle’
        Assert.assertEquals(gearPage.getTextQuantity3(), "3", "Error");                       //* Verify the Qty is ‘3’
        Assert.assertEquals(gearPage.getTextProductPrice(), "$135.00", "Error");              //* Verify the product price ‘$135.00’
        gearPage.changeQuantityTo5();                                                                         //* Change Qty to ‘5’
        gearPage.clickOnUpdateShoppingCartButton();                                                           //* Click on ‘Update Shopping Cart’ button
        Assert.assertEquals(gearPage.getTextProductPrice225(), "$225.00", "Error");           //* Verify the product price ‘$225.00’
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() {
        //1. userShouldAddProductSuccessFullyToShoppinCart()
        homePage.mouseHoverToMenMenu();                                                                      //* Mouse Hover on Men Menu
        homePage.mouseHoverToMenTops();                                                                      //* Mouse Hover on Bottoms
        homePage.clickOnPants();                                                                             //* Click on Pants
        menPage.hoverAndClickProduct();                                                                      //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        menPage.hoverAndClickProductColour();                                                                //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        menPage.hoverAndClickOnAddToCartButton();                                                            //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        Assert.assertEquals(menPage.getTextAddedPantToShoppingCart(), "You added Cronus Yoga Pant to your shopping cart.", "Error");   //* Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        menPage.clickOnShoppingCart();                                                                       //* Click on ‘shopping cart’ Link into message
        Assert.assertEquals(menPage.getTextShoppingCart(), "Shopping Cart", "Error");          //* Verify the text ‘Shopping Cart.’
        Assert.assertEquals(menPage.getTextCronusYogaPant(), "Cronus Yoga Pant", "Error");     //* Verify the product name ‘Cronus Yoga Pant’
        Assert.assertEquals(menPage.getTextSize32(), "32", "Error");                           //* Verify the product size ‘32’
        Assert.assertEquals(menPage.getTextBlack(), "Black", "Error");                         //* Verify the product colour ‘Black’
    }

    @Test
    public void verifyTheSortByProductNameFilter() {
        // verifyTheSortByProductNameFilter
        homePage.mouseHoverToWomenMenu();                                                                    // Mouse Hover on Women Menu
        homePage.mouseHoverToWomenTops();                                                                    //* Mouse Hover on Tops
        homePage.clickOnJackets();                                                                           //* Click on Jackets
        womenPage.selectSortByFilterProductName();                                                           //* Select Sort By filter “Product Name”
        womenPage.verifyProductSize();
        womenPage.verifyProductsNameAlphabeticalOrder();                                                     //* Verify the products name display in alphabetical order
    }

    @Test
    public void verifyTheSortByPriceFilter() {
        //verifyTheSortByPriceFilter
        homePage.mouseHoverToWomenMenu();                                                                    //* Mouse Hover on Women Menu
        homePage.mouseHoverToWomenTops();                                                                    //* Mouse Hover on Tops
        homePage.clickOnJackets();                                                                           //* Click on Jackets
        womenPage.selectSortByFilterPrice();                                                                 //* Select Sort By filter “Price”
        womenPage.verifyProductsPriceLowToHigh();                                                            //* Verify the products price display in Low to High
    }
}
