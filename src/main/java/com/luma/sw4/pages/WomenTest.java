package com.luma.sw4.pages;

import com.luma.sw4.utility.Utilities;
import org.openqa.selenium.By;

public class WomenTest extends Utilities {
    By filterProduct = By.id("sorter");
    By productSize = By.xpath("//img[starts-with(@class,'product-image-photo')]");
    By finalPrice = By.cssSelector("span[data-price-type='finalPrice']");
    By elementListDisplay = By.cssSelector(".products .product-item-info .product-item-name");

    public void selectSortByFilterProductName() {
        selectByValueFromDropDown(filterProduct, "name");
    }

    public void selectSortByFilterPrice() {
        selectByValueFromDropDown(filterProduct, "price");
    }

    public void verifyProductSize() {
        verifyProductSize(productSize);
    }

    public void verifyProductsNameAlphabeticalOrder() {
        elementFilter(elementListDisplay);
    }

    public void verifyProductsPriceLowToHigh() {
        verifyFinalPrice(finalPrice);
    }
}
