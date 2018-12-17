import org.junit.Test;
import testUtilites.BasicChromeTest;

public class NameSecret_Test extends BasicChromeTest {

    @Test
    public void test_openPresentedName(){
        new NameSecret(driver)
                .open()
                .openPresentedNameWithA()
                .checkThatProperPageOpened();
    }

    @Test
    public void test_openNameFromExtraList(){
        new NameSecret(driver)
                .open()
                .openPageWithMoreNames()
                .openPresentedNameWithA()
                .checkThatProperPageOpened();
    }

    @Test
    public void test_openPageWithExtraNames(){
        String[] params = {"a", "b", "c"};
        new NameSecret(driver)
                .open("namesWithLetter", params)
                .openPresentedNameWithA()
                .checkThatProperPageOpened();
    }

}
