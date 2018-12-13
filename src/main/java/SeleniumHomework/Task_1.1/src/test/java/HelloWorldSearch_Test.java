import org.junit.Test;
import testUtilites.basicChromeTest;

public class HelloWorldSearch_Test extends basicChromeTest {

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
