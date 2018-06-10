package test;

import page.GoogleSearchResults2Page;
import page.GoogleSearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.GoogleStartSearchPage;


import java.util.List;

public class GoogleSearchTest extends GoogleBaseTest {


    @DataProvider
    public Object[][] searchTerm() {
        return new Object[][]{
                {"selenium"},
                {"SELENIUM"},
                {"Selenium"},
        };
    }

    @Test(dataProvider = "searchTerm")
    public void basicSearchTest(String searchTerm) {

        GoogleStartSearchPage googleStartSearchPage = new GoogleStartSearchPage (webDriver);

        GoogleSearchResultsPage googleSearchResultsPage =
                googleStartSearchPage.search(searchTerm);
        Assert.assertTrue(googleSearchResultsPage.isPageLoaded(),
                "Google Search results Page is not loaded.");

        List<String> searchResultsList = googleSearchResultsPage.getSearchResults();

        Assert.assertEquals(searchResultsList.size(), 10,
                "Count of search result items is wrong.");

        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "Search Term " + searchTerm + " was not found in: \n" + searchResult);

            GoogleSearchResults2Page googleSearchResults2Page =
                    googleSearchResultsPage.clickOnSecondPage();
            Assert.assertTrue(googleSearchResults2Page.isPageLoaded(),
                    "Google Search Results 2 Page is not loaded.");

            List<String> searchResultsList2 = GoogleSearchResults2Page.getSearchResults2();

            Assert.assertEquals(searchResultsList2.size(), 10,
                    "Count of search result items is wrong.");

            for (String searchResult2 : searchResultsList2) {
                Assert.assertTrue(searchResult2.toLowerCase().contains(searchTerm.toLowerCase()),
                        "Search Term " + searchTerm + " was not found in: \n" + searchResult2);


            }

        }
    }
}
