package task_1.PositiveUnitTests;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

import static task_1.PrimeNumbers.filterNumbers;

public class PositiveTest2 {

    @Test
    public void test_positive2(){
        ArrayList<Integer> actual = new ArrayList<>();
        actual = filterNumbers(10);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);
        expected.add(5);
        expected.add(7);
        TestCase.assertEquals("Массивы не одинаковы", expected, actual);
    }

}
