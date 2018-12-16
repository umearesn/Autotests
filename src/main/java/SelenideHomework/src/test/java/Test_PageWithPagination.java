import org.junit.Test;
import pages.PageWithPagination;

public class Test_PageWithPagination {

    @Test
    public void pagnationTest() {
        new PageWithPagination()
                .open()
                .goToPage(5)
                .checkThatProperPageOpened();
    }
}
