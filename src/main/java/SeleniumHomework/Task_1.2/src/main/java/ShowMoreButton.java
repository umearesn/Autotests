import mainUtilites.basicPages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ShowMoreButton extends AbstractPage<ShowMoreButton> {

    @FindBy(xpath = "//button[@class='button js-pgng_more_link']")
    private WebElement showMoreBtn;

    @FindBy(xpath = "//a[@class='pypo-item__title link-holder']")
    private List<WebElement> before;

    private int amountOfNewsBefore = before.size();

    public ShowMoreButton(WebDriver driver) {
        super(driver);
    }

    public ShowMoreButton open(){
        return super.open(url);
    }

    public ShowMoreButton getMore() {
        showMoreBtn.click();
        return this;
    }

    public ShowMoreButton newResultsShoulBePresented() {
        assertTrue("Новые результаты не отобразились",
                waiter.waitForCondition(
                        ExpectedConditions.numberOfElementsToBeMoreThan
                                (By.xpath("//a[@class='pypo-item__title link-holder']"),
                                        amountOfNewsBefore)));
        return this;
    }
}
