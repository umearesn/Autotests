package task_3;

import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PositiveTestSuite {

    @Mock
    MockedMicroservice adder = mock(MockedMicroservice.class);

    @Test
    public void test_positive_studentAlreadyAdded(){
        Student tester = new Student("Tester", "DIHT", 2);
        when(adder.addStudent(tester)).thenReturn(new StudentState("1111", "Student already added", "already done"));
        StudentState expected = new StudentState("1111", "Student already added", "already done");
        StudentState actual = adder.addStudent(tester);
        assertThat(expected.getHashCode(), equalTo(actual.getHashCode()));
        assertThat(expected.getErrorText(), equalTo(actual.getErrorText()));
        assertThat(expected.getState(), equalTo(actual.getState()));
    }

    public void test_positive_studentSuccessfullyAdded(){
        Student tester = new Student("Tester", "DIHT", 2);
        when(adder.addStudent(tester)).thenReturn(new StudentState("1111", "Student successfully added!", "ok"));
        StudentState expected = new StudentState("1111", "Student successfully added!", "ok");
        StudentState actual = adder.addStudent(tester);
        assertThat(expected.getHashCode(), equalTo(actual.getHashCode()));
        assertThat(expected.getErrorText(), equalTo(actual.getErrorText()));
        assertThat(expected.getState(), equalTo(actual.getState()));
    }

}
