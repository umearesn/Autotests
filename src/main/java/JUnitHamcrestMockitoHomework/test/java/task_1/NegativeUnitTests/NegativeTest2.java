package task_1.NegativeUnitTests;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import static task_1.PrimeNumbers.filterNumbers;

public class NegativeTest2 {

    @Test
    public void test_positive2(){
        ArrayList<Integer> actual = new ArrayList<>();
        actual = filterNumbers(5);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(5);
        TestCase.assertEquals("Массив содержит все простые числа из диапазона", expected, actual);
    }

}
