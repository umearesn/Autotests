import org.junit.Test;
import testUtilites.basicChromeTest;

public class ShowMoreButton_Test extends basicChromeTest {

    @Test
    public void test(){
        new ShowMoreButton(driver)
                .open()
                .getMore()
                .newResultsShoulBePresented();
    }

}
