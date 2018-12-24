import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import commonFiles.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import commonFiles.pageNavigation.Domain;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

@Domain("https://tv.mail.ru")
public class ChannelsPage extends PageObject<ChannelsPage> {

    private SelenideElement buttonToList =
            $(By.xpath("//button[@data-type='list']"));

    private SelenideElement buttonToGrid =
            $(By.xpath("//button[@data-type='grid']"));

    private String buttonPathPattern = "//button[@data-type='";

    private String switchedTo = "";

    public ChannelsPage open(){
        return super.open();
    }

    public ChannelsPage switchToView(String viewType) {
        switchedTo = viewType;
        SelenideElement desiredButton  =
                $(By.xpath(buttonPathPattern.concat(viewType).concat("']")));
        desiredButton.click();
        WebDriverWait waiter = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        waiter.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='p-channels p-channels_".concat(switchedTo).concat("']"))));
        return this;
    }

    public ChannelsPage checkThatViewIsCorrect() {
        assertTrue("Требуемый вид не открыт.",
                $(By.xpath("//div[@class='p-channels p-channels_".concat(switchedTo).concat("']"))).exists());
        return this;
    }

}
