package task_1.NegativeUnitTests;

import junit.framework.TestCase;
import org.junit.*;

import java.util.ArrayList;
import static task_1.PrimeNumbers.filterNumbers;

public class NegativeTest1 {

    @Test
    public void test_positive1(){
        ArrayList<Integer> actual = new ArrayList<>();
        actual = filterNumbers(2);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        TestCase.assertEquals("Массив не содержит лишних чисел", expected, actual);
    }

}
