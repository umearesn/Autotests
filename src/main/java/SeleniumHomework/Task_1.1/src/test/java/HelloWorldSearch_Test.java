import org.junit.Test;
import testUtilites.BasicChromeTest;

public class HelloWorldSearch_Test extends BasicChromeTest {

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
