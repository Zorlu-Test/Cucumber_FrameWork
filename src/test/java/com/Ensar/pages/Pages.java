package com.Ensar.pages;

import com.Ensar.utilities.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pages {
    private DashBoard dashBoard;
    private ProductPage productPage;
    private SearchResult searchResult;
    public WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

    public DashBoard dashBoard() {
        if (dashBoard == null) {
            dashBoard = new DashBoard();
        }
        return dashBoard;
    }

    public ProductPage productPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public SearchResult searchResult() {
        if (searchResult == null) {
            searchResult = new SearchResult();
        }
        return searchResult;
    }


}
