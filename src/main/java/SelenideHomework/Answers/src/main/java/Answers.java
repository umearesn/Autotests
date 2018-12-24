import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import commonFiles.pageNavigation.Domain;
import commonFiles.pageNavigation.PageToOpenURL;
import commonFiles.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Domain("https://otvet.mail.ru")
@PageToOpenURL("/open")
public class Answers extends PageObject<Answers> {

    private SelenideElement userPic =
            $(By.xpath("//a[@class='q--li--ava small-avatar']"));

    private String userName = userPic.attr("title");

    public Answers open() {
        return super.open();
    }

    public Answers openUserPage() {
        System.out.println(userName);
        userPic.click();
        WebDriverWait waiter = new WebDriverWait(WebDriverRunner.getWebDriver(), 5);
        waiter.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//div[@class='DL4bZWiRx7Zp12UGET81j_0']")));
        return this;
    }

    public Answers checkThatProperPageOpened() {
        assertEquals("Открыта неверная страница.",
                $(By.xpath("//div[@class='DL4bZWiRx7Zp12UGET81j_0']")).getText(), userName);
        return this;
    }

}
