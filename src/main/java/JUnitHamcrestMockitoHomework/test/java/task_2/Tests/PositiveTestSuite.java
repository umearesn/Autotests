package task_2.Tests;

import org.junit.Test;
import task_2.Matrix;
import task_2.MatrixSort;
import task_2.Tools.MatrixInitializer;
import task_2.Tools.MatrixRowGetter;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class PositiveTestSuite {

    private MatrixSort sorter = new MatrixSort();
    private MatrixInitializer builder = new MatrixInitializer();
    private MatrixRowGetter parser = new MatrixRowGetter();

    @Test
    public void test_positive_oneElementTable() {
        Integer[] inputValues = {5};
        Matrix input = builder.givenValuesMatrixInit(1, 1, inputValues);
        Matrix actual = sorter.sortRowsInReverseOrder(input);
        assertThat(actual.getHeight(), is(1));
        assertThat(actual.getWidth(), is(1));
        assertThat(actual.getElemAtPos(0, 0), is(5));
    }

    @Test
    public void test_positive_sameSumTable() {
        Integer[] inputValues = {1, 2, 3, 4, 2, 3, 4, 5, 4, 3, 2, 1};
        Matrix input =  builder.givenValuesMatrixInit(3, 4, inputValues);
        Matrix actual = sorter.sortRowsInReverseOrder(input);
        assertThat(actual.getHeight(), is(3));
        assertThat(actual.getWidth(), is(4));
        assertThat(parser.getRowAsArray(0, actual), is(new Integer[]{2, 3, 4, 5}));
        assertThat(parser.getRowAsArray(1, actual), is(new Integer[]{1, 2, 3, 4}));
        assertThat(parser.getRowAsArray(2, actual), is(new Integer[]{4, 3, 2, 1}));
    }


}
