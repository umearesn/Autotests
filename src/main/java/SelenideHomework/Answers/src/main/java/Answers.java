import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import commonFiles.pageNavigation.Domain;
import commonFiles.pageNavigation.PageToOpenURL;
import commonFiles.pages.PageObject;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

@Domain("https://otvet.mail.ru")
@PageToOpenURL("/open")
public class Answers extends PageObject<Answers> {

    private SelenideElement userPic =
            $(By.xpath("//div[@class='pageQuestions']/descendant::a"));

    private String userName = userPic.attr("title");

    private String pathToFieldWithName = "//div[contains(text(), '".concat(userName).concat("')]");

    public Answers open() {
        return super.open();
    }

    @Step("Открываем страницу юзера.")
    public Answers openUserPage() {
        userPic.click();
        WebDriverWait waiter = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        waiter.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(pathToFieldWithName)));
        return this;
    }

    @Step("Проверяем, что открылась требуемая страница.")
    public Answers checkThatProperPageOpened() {
        assertTrue("Открыта неверная страница.",
                $(By.xpath(pathToFieldWithName)).exists());
        return this;
    }

}
