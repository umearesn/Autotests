import mainUtilites.basicPages.AbstractPage;
import mainUtilites.pageNavigation.PageURL;
import mainUtilites.pageNavigation.ParamURL;
import mainUtilites.pageNavigation.URL;
import mainUtilites.pageNavigation.Domain;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

@Domain("https://horo.mail.ru")
@PageURL("/namesecret")
@ParamURL( {
        @URL(patternName = "namesWithLetter", urlPattern = "/namesecret/%1")
} )
public class NameSecret extends AbstractPage<NameSecret> {

    @FindBy(xpath = "//span[contains(text(), 'Еще')]/ancestor::span/descendant::a[contains(text(), 'А')]")
    private WebElement showMoreLink;

    @FindBy(xpath = "//span[@class='link__text'][contains(text(), 'А')]")
    private WebElement anyNameWithAPresented;

    private String nameClicked = "";

    public NameSecret(WebDriver driver){
        super(driver);
    }

    public NameSecret open() {
        return super.open();
    }

    public NameSecret open(String name, String[] param) {
        String pattern  = null;
        URL[] urlList = this.getClass().getAnnotation(ParamURL.class).value();
        int i = 0;
        while(i < urlList.length && !name.equals(urlList[i].patternName())){
            i++;
        }
        pattern = urlList[i].urlPattern();
        return super.open(pattern, param);
    }

    public NameSecret openPageWithMoreNames(){
        showMoreLink.click();
        return this;
    }

    public NameSecret openPresentedNameWithA(){
        nameClicked = anyNameWithAPresented.getText();
        anyNameWithAPresented.click();
        return this;
    }

    public NameSecret checkThatProperPageOpened(){
        String path = "//h1[contains(text(), '".concat(nameClicked).concat("')]");
        assertTrue("Нужная ссылка не открылась",
                waiter.waitForCondition(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(path))));
        return this;
    }

}
