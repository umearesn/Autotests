package task_3;

import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NegativeTestSuite {

    @Mock
    MockedMicroservice adder = mock(MockedMicroservice.class);

    @Test
    public void test_negative_addingNullStudent(){
        when(adder.addStudent(null)).thenReturn(new StudentState("1111", "Student is null", "failed"));
        StudentState expected = new StudentState("1111", "Student is null", "failed");
        StudentState actual = adder.addStudent(null);
        assertThat(expected.getHashCode(), equalTo(actual.getHashCode()));
        assertThat(expected.getErrorText(), equalTo(actual.getErrorText()));
        assertThat(expected.getState(), equalTo(actual.getState()));
    }

    @Test
    public void test_negative_studentWithNullName(){
        Student tester = new Student(null, "DIHT", 2);
        when(adder.addStudent(tester)).thenReturn(new StudentState("1111", "Student's name is absent", "failed"));
        StudentState expected = new StudentState("1111", "Student's name is absent", "failed");
        StudentState actual = adder.addStudent(tester);
        assertThat(expected.getHashCode(), equalTo(actual.getHashCode()));
        assertThat(expected.getErrorText(), equalTo(actual.getErrorText()));
        assertThat(expected.getState(), equalTo(actual.getState()));
    }

}
