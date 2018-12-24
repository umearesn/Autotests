import org.junit.Test;

public class Test_Answers {

    @Test
    public void test_openUserPage() {
        new Answers()
                .open()
                .openUserPage()
                .checkThatProperPageOpened();
    }

}
