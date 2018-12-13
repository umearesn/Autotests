import basic_pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertTrue;

public class HelloWorldSearch extends AbstractPage<HelloWorldSearch> {

    private final String url = "/";

    public HelloWorldSearch(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@name='q']")
    private WebElement inputField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement resultsField;

    public HelloWorldSearch open(){
        return super.open(url);
    }

    public HelloWorldSearch setText(String query){
        inputField.sendKeys(query);
        return this;
    }

    public HelloWorldSearch sendQuery(){
        submitButton.click();
        return this;
    }

    public HelloWorldSearch resultsShoudBePresented() {
        assertTrue("Результаты не отображаются на странице",
                waiter.waitForCondition(ExpectedConditions
                        .textToBePresentInElement(resultsField, "Результатов")));
        return this;
    }

    public HelloWorldSearch moreThanZeroResults(){
        assertTrue("Результатов 0", Integer
                .parseInt(resultsField.getText().substring(22, 23)) > 0);
        return this;
    }

}
