package testUtilites;

import mainUtilites.data.BrowsersData;
import mainUtilites.drivers.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class BasicChromeTest {

    protected WebDriver driver = null;

    @Before
    public void init() {
        driver = WebDriverFactory.getWebDriverInstance(BrowsersData.Chrome);
    }

    @After
    public void killSession(){
        driver.close();
        driver.quit();
    }

}
