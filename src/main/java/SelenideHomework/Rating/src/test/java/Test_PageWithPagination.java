import org.junit.Test;

public class Test_PageWithPagination {

    @Test
    public void pagnationTest() {
        new PageWithPagination()
                .open()
                .goToPage(5)
                .checkThatProperPageOpened();
    }
}
