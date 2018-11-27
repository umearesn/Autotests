package task_1.NegativeUnitTests;

import org.junit.Test;
import task_1.PrimeNumbers;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static task_1.PrimeNumbers.*;

public class NegativeTestSuite {

    private PrimeNumbers prime = new PrimeNumbers();

    @Test
    public void test_negative1(){
        Integer[] actual = prime.filterNumbers(-23);
        Integer[] expected = {};
        assertEquals("Массив содержит числа при отрицательных входных данных", expected, actual);
    }

    @Test
    public void test_negative2(){
        Integer[] actual = prime.filterNumbers(-100);
        Integer[] expected = {};
        assertEquals("Массив содержит числа при отрицательных входных данных", expected, actual);
    }

}