import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import commonFiles.pages.PageObject;
import commonFiles.pageNavigation.Domain;
import commonFiles.pageNavigation.PageToOpenURL;

@Domain("https://top.mail.ru")
@PageToOpenURL("/Rating/All/Today/Visitors")
public class PageWithPagination extends PageObject<PageWithPagination> {

    private int pageWentTo = 0;

    public PageWithPagination open() {
        return super.open();
    }

    @Step("Нажимаем на кнопку с требуемой страницей")
    public PageWithPagination goToPage(int desiredPage){
        this.pageWentTo = desiredPage;
        String path = "//a[@href='/Rating/All/Today/Visitors/".concat(Integer.toString(desiredPage).concat(".html']"));
        SelenideElement pageToGo = Selenide.$(By.xpath(path));
        pageToGo.click();
        return this;
    }

    @Step("Проверяем, что открылась нужная страница")
    public PageWithPagination checkThatProperPageOpened(){
        SelenideElement firstNotePresented = Selenide.$(By.xpath("//tr[@class='ReportTable-TRow']/descendant::td"));
        firstNotePresented.shouldHave(Condition.text(Integer.toString(30*(pageWentTo - 1)+1)));
        return this;
    }

}


