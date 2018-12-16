package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PageWithPagination extends PageObject<PageWithPagination> {

    private int pageWentTo = 0;

    public PageWithPagination open() {
        return super.open();
    }

    @Step("Нажимаем на кнопку с требуемой страницей")
    public PageWithPagination goToPage(int desiredPage){
        this.pageWentTo = desiredPage;
        String path = "//a[@href='/Rating/All/Today/Visitors/".concat(Integer.toString(desiredPage).concat(".html']"));
        SelenideElement pageToGo = $(By.xpath(path));
        pageToGo.click();
        return this;
    }

    @Step("Проверяем, что открылась нужная страница")
    public PageWithPagination checkThatProperPageOpened(){
        SelenideElement firstNotePresented = $(By.xpath("//td[@class='it-cbox it-right']"));
        firstNotePresented.shouldHave(text(Integer.toString(30*(pageWentTo - 1)+1)));
        return this;
    }

}


