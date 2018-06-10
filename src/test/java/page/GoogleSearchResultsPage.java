package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResultsPage extends GoogleBasePage {

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//div[@id='res']")
    private WebElement searchResultsContainer;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement secondSearchResultsPage;



    public GoogleSearchResultsPage(WebDriver webDriver) {
        super(webDriver);
        this.searchResults = searchResults;
        PageFactory.initElements(webDriver, this);
        waitUntilElementIsVisible(searchResultsContainer, 5);
    }

    public boolean isPageLoaded() {
        return searchResultsContainer.isDisplayed();
    }

    public List<String> getSearchResults() {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResultElement : searchResults) {
            ((JavascriptExecutor)webDriver)
                    .executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }

        return searchResultsList;
    }

    public GoogleSearchResults2Page clickOnSecondPage() {
        secondSearchResultsPage.click();
        return new GoogleSearchResults2Page(webDriver);
    }
}
