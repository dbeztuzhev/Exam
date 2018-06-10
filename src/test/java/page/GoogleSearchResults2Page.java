package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResults2Page extends GoogleSearchResultsPage {

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private static List<WebElement> searchResults2;

    @FindBy(xpath = "//div[@id='res']")
    private WebElement searchResultsContainer2;


    public GoogleSearchResults2Page(WebDriver webDriver) {
        super(webDriver);
        this.searchResults2 = searchResults2;
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsVisible(searchResultsContainer2, 5);
    }

    public static List<String> getSearchResults2() {
        List<String> searchResultsList2 = new ArrayList();
        for (WebElement searchResultElement : searchResults2) {
            ((JavascriptExecutor) webDriver)
                    .executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList2.add(searchResultText);
        }

        return searchResultsList2;
    }
}