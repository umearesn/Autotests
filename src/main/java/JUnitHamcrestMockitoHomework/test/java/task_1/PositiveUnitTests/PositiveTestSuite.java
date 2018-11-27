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
    public void test_positive1(){
        Integer[] actual = prime.filterNumbers(1);
        Integer[] expected = {};
        assertArrayEquals("Массив содержит лишние числа", expected, actual);
    }

    @Test
    public void test_positive2(){
        Integer[] actual = prime.filterNumbers(10);
        Integer[] expected = {2, 3, 5, 7};
        assertArrayEquals("Массивы не одинаковы", expected, actual);
    }

    @Test
    public void test_positive3(){
        Integer[] actual = prime.filterNumbers(2);
        Integer[] expected = {1, 2};
        assertNotEquals("Массив содержит лишние числа", expected, actual);
    }

    @Test
    public void test_positive4(){
        Integer[] actual = prime.filterNumbers(5);
        Integer[] expected = {2, 5};
        assertNotEquals("Массив содержит не все простые числа из диапазона", expected, actual);
    }
}