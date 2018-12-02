package task_1.PositiveUnitTests;

import org.junit.Before;
import org.junit.Test;
import task_1.PrimeNumbers;

import java.util.ArrayList;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import static task_1.PrimeNumbers.*;

public class PositiveTestSuite {

    private PrimeNumbers prime = new PrimeNumbers();

    @Test
    public void test_positive_above_zero(){
        Integer[] actual = prime.filterNumbers(10);
        Integer[] expected = {2, 3, 5, 7};
        assertArrayEquals("Массивы не равны", expected, actual);
    }

    @Test
    public void test_positive_zero(){
        Integer[] actual = prime.filterNumbers(0);
        Integer[] expected = {};
        assertNotEquals("Массив содержит лишние числа", expected, actual);
    }

}