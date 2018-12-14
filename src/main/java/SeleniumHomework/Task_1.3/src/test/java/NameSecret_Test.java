import org.junit.Test;
import testUtilites.BasicChromeTest;

public class NameSecret_Test extends BasicChromeTest {

    @Test
    public void test_openPresentedName(){
        new NameSecret(driver)
                .open()
                .openPresentedName()
                .checkThatProperPageOpened();
    }

    @Test
    public void test_openNameFromExtraList(){
        new NameSecret(driver)
                .open()
                .openPageWithMoreNames()
                .openPresentedName()
                .checkThatProperPageOpened();
    }

}
