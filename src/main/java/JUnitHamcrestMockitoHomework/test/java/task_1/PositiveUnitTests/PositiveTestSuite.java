package task_1.PositiveUnitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import task_1.NegativeUnitTests.NegativeTest1;
import task_1.NegativeUnitTests.NegativeTest2;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        PositiveTest1.class,
        PositiveTest2.class
})

public class PositiveTestSuite {
}