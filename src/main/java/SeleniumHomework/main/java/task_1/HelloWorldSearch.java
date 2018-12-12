package task_1;

import common_packages.basic_pages.AbstractPage;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class HelloWorldSearch extends AbstractPage<HelloWorldSearch> {

    private final String url = "/";

    public HelloWorldSearch(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//input[@name='q']")
    private WebElement inputField;

    @FindBy(xpath = "//span/ancestor::div[@class='sbl1']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement resultsField;

    public HelloWorldSearch pageShouldBeOpened(){
        String actual = driver.getCurrentUrl();
        assertThat(String.format("Должна быть открыта страница %s",
                System.getProperty("webriver.base.url") + url),
                Matchers.matchesPattern(domainTemplate + url));
        return this;
    }

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
                waiter.waitForCondition(ExpectedConditions.attributeContains(resultsField, "text", "Результатов примерно:")));
        return this;
    }

}
