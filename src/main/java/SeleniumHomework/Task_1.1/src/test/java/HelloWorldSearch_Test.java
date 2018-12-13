import data.BrowsersData;
import drivers.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

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
                .setText("Hello World")
                .sendQuery()
                .resultsShoudBePresented()
                .moreThanZeroResults();
   }
}
