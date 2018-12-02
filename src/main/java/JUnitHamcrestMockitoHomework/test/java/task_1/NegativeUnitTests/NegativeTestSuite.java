package task_1.NegativeUnitTests;

import org.junit.Test;
import org.mockito.internal.matchers.Null;
import task_1.PrimeNumbers;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static task_1.PrimeNumbers.*;

public class NegativeTestSuite {

    private PrimeNumbers prime = new PrimeNumbers();

    @Test
    public void test_negative_below_zero(){
        Integer[] actual = prime.filterNumbers(-23);
        Integer[] expected = {};
        assertEquals("Массив содержит числа при отрицательных входных данных", expected, actual);
    }

    @Test
    public void test_negative_null(){
        Integer[] actual = prime.filterNumbers(null);
        Integer[] expected = null;
        assertEquals("Массив не null при воодных данных null", expected, actual);
    }

}