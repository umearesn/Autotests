package task_2.Tests;

import org.junit.Test;
import task_2.Matrix;
import task_2.MatrixSort;
import task_2.Tools.MatrixInitializer;
import task_2.Tools.MatrixRowGetter;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class NegativeTestSuite {

    private MatrixSort sorter = new MatrixSort();
    private MatrixInitializer builder = new MatrixInitializer();
    private MatrixRowGetter parser = new MatrixRowGetter();

    @Test
    public void test_negative_nullInput(){
        Matrix actual = sorter.sortRowsInReverseOrder(null);
        assertThat(actual, equalTo(null));
    }

    @Test
    public void test_negative_stringInput(){
        Matrix input = new Matrix(0, 0);
        Matrix actual = sorter.sortRowsInReverseOrder(input);
        assertThat(actual.getHeight(), is(0));
        assertThat(actual.getWidth(), is(0));
    }

}
