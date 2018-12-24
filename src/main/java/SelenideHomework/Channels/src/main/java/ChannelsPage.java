import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import commonFiles.pages.PageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import commonFiles.pageNavigation.Domain;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

@Domain("https://tv.mail.ru")
public class ChannelsPage extends PageObject<ChannelsPage> {

    private String buttonPathPattern = "//button[@data-type='";

    private String viewAttributePattern = "div[class*=";

    private String switchedTo = "";

    public ChannelsPage open(){
        return super.open();
    }

    @Step("Переключаемся на указанный вид.")
    public ChannelsPage switchToView(String viewType) {
        switchedTo = viewType;
        SelenideElement desiredButton  =
                $(By.xpath(buttonPathPattern.concat(viewType).concat("']")));
        desiredButton.click();
        WebDriverWait waiter = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        waiter.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector(viewAttributePattern.concat(switchedTo).concat("]"))));
        return this;
    }

    @Step("Проверяем, что переключение успешно.")
    public ChannelsPage checkThatViewIsCorrect() {
        assertTrue("Требуемый вид не открыт.",
                $(By.cssSelector(viewAttributePattern.concat(switchedTo).concat("]"))).exists());
        return this;
    }

}
