package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleStartSearchPage extends GoogleBasePage {

    @FindBy (xpath = "//img [@id='hplogo']")
    private  WebElement logo;

    @FindBy(xpath = "//input[@id='lst-ib']")
    private WebElement searchField;

    public GoogleStartSearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public GoogleSearchResultsPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return new GoogleSearchResultsPage(webDriver);
    }
}

