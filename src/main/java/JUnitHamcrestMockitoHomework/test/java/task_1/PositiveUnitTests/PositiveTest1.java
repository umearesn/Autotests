package task_1.PositiveUnitTests;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

import static task_1.PrimeNumbers.filterNumbers;

public class PositiveTest1 {

    @Test
    public void test_positive1(){
        ArrayList<Integer> actual = new ArrayList<>();
        actual = filterNumbers(1);
        ArrayList<Integer> expected = new ArrayList<>();
        TestCase.assertEquals("Массивы неодинаковы", expected, actual);
    }

}
