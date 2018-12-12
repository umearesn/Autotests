package task_1;

import common_packages.data.BrowsersData;
import common_packages.drivers.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelloWorldSearch_Test {

    private WebDriver driver = null;

    @Before
    public void init(){
        driver = WebDriverFactory.getWebDriverInstance(BrowsersData.Chrome);
    }

    @After
    public void killSession() {
        driver.close();
        driver.quit();
    }

    @Test
    public void test(){
        new HelloWorldSearch(driver)
                .open()
                //.pageShouldBeOpened()
                .setText("HelloWorld")
                .sendQuery()
                .resultsShoudBePresented();
    }

}
