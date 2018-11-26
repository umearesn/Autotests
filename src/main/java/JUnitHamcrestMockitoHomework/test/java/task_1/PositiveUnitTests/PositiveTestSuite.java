package task_1.PositiveUnitTests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.io.InputStream;
import java.util.ArrayList;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

public class PositiveTestSuite {

    @Test
    public void test_positive1(){
        ArrayList<Integer> actual = new ArrayList<>();
        //actual = filterNumbers(1);
        ArrayList<Integer> expected = new ArrayList<>();
        assertEquals("Массив содержит лишние числа", expected, actual);
    }

    @Test
    public void test_positive2(){
        ArrayList<Integer> actual = new ArrayList<>();
        //actual = filterNumbers(10);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(3);
        expected.add(5);
        expected.add(7);
        assertEquals("Массивы не одинаковы", expected, actual);
    }

    @Test
    public void test_positive3(){
        ArrayList<Integer> actual = new ArrayList<>();
        //actual = filterNumbers(2);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        assertNotEquals("Массив содержит лишние числа", expected, actual);
    }

    @Test
    public void test_positive4(){
        ArrayList<Integer> actual = new ArrayList<>();
        //actual = filterNumbers(5);
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(5);
        assertNotEquals("Массив содержит не все простые числа из диапазона", expected, actual);
    }

}