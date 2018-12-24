package commonFiles.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import commonFiles.pageNavigation.PageToOpenURL;
import commonFiles.pageNavigation.Domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class PageObject<T> {

    static {
        Configuration.browser = "chrome";
    }

    protected String getUrlToOpen() {
        String adress = null;
        if(this.getClass().isAnnotationPresent(Domain.class)) {
            adress = this.getClass().getAnnotation(Domain.class).value();
        } else {
            adress = System.getProperty("webdriver.base.url");
        }
        if(this.getClass().isAnnotationPresent(PageToOpenURL.class)){
            adress = adress + this.getClass().getAnnotation(PageToOpenURL.class).value();
        }
        return adress;
    }

    protected String getParamURLToOpen(String urlTemplate, String... parameters) {
        String adress = null;
        try {
            if (this.getClass().isAnnotationPresent(Domain.class)) {
                adress = this.getClass().getAnnotation(Domain.class).value();
            } else {
                adress = System.getProperty("webdriver.base.url");
            }
            for (int i = 0; i < parameters.length; i++) {
                urlTemplate = urlTemplate.replace("%".concat(Integer.toString(i + 1)),
                        parameters[i]);
            }
            adress = adress + urlTemplate;
        } catch (Exception error){
            System.out.println("Domain or template is not given.");
        }
        return adress;
    }

    protected T open() {
        Selenide.open(getUrlToOpen());
        return (T) this;
    }

    protected T openParamUrl(String urlTemplate, String... parameters) {
        Selenide.open(getParamURLToOpen(urlTemplate, parameters));
        return (T) this;
    }

}
