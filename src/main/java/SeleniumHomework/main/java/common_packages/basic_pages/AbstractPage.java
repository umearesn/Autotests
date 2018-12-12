package common_packages.basic_pages;

import common_packages.wait.StandartWaiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage<T> {

    protected WebDriver driver = null;
    protected String domainTemplate = "http[s]?://.*?(?::\\d+)?";
    protected StandartWaiter waiter = null;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        this.waiter = new StandartWaiter(driver);
        PageFactory.initElements(driver, this);
    }

    protected T open(String url){
        driver.get(System.getProperty("webdriver.base.url") + url);
        //driver.get("http://www.google.com/");
        return (T) this;
    }

    protected T open(String urlTemplate, String... parameters) {
        String url = "";

        for(int i = 0; i < parameters.length; i++) {
            url = urlTemplate.replace("%" + (i + 1), parameters[i]);
        }

        driver.get(url);
        return (T) this;
    }

    protected abstract T pageShouldBeOpened();

}
