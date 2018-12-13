package mainUtilites.basicPages;

import mainUtilites.wait.StandartWaiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage<T> {

    protected WebDriver driver = null;
    protected StandartWaiter waiter = null;
    protected final String url = "/";

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        this.waiter = new StandartWaiter(driver);
        PageFactory.initElements(driver, this);
    }

    protected T open(String url){
        driver.get(System.getProperty("webdriver.base.url") + url);
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

}
