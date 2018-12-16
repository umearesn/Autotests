package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class PageObject<T> {

    static {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://top.mail.ru/Rating/All/Today/Visitors/";
    }

    @Step("Открываем страницу.")
    public T open() {
        Selenide.open("https://top.mail.ru/Rating/All/Today/Visitors/");
        return (T) this;
    }



}
