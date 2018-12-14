import org.junit.Test;
import testUtilites.BasicChromeTest;

public class ShowMoreButton_Test extends BasicChromeTest {

    @Test
    public void test(){
        new ShowMoreButton(driver)
                .open()
                .getMore()
                .newResultsShoulBePresented();
    }

}
