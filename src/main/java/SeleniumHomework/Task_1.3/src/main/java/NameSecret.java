import mainUtilites.basicPages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class NameSecret extends AbstractPage<NameSecret> {

    @FindBy(xpath = "//span[contains(text(), 'Еще')]/ancestor::span/descendant::a[contains(text(), 'А')]")
    private WebElement showMoreLink;

    @FindBy(xpath = "//span[@class='link__text'][contains(text(), 'А')]")
    private WebElement anyNameWithAFirstPresented;

    private String nameClicked = "";

    public NameSecret(WebDriver driver){
        super(driver);
    }

    public NameSecret open() {
        return super.open(url);
    }

    public NameSecret openPresentedName(){
        nameClicked = anyNameWithAFirstPresented.getText();
        anyNameWithAFirstPresented.click();
        return this;
    }

    public NameSecret checkThatProperPageOpened(){
        String path = "//h1[contains(text(), '".concat(nameClicked).concat("')]");
        assertTrue("Нужная ссылка не открылась",
                waiter.waitForCondition(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(path))));
        return this;
    }

    public NameSecret openPageWithMoreNames(){
        showMoreLink.click();
        return this;
    }

}
