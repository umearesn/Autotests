
import org.junit.Test;

public class Test_ChannelsPage {

    @Test
    public void test_changeView() {
        new ChannelsPage()
                .open()
                .switchToView("list")
                .checkThatViewIsCorrect();
    }
}
