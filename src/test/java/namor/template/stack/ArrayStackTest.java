package namor.template.stack;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ArrayStackTest {

    private ArrayStack<Integer> arrayStack;

    @Before
    public void setUp() throws Exception {
        arrayStack = new ArrayStack<>();
    }

    @Test
    public void shouldReturnTrueWhenStackIsEmpty() {
        final boolean actual = arrayStack.isEmpty();

        assertThat(actual).isTrue();
    }

    @Test
    public void whenPushValueIntoStackExpectStackIsEmptyFalse() {
        arrayStack.push(4);

        assertThat(arrayStack.isEmpty()).isFalse();
    }

    @Test
    public void whenPushValueIntoStackExpectStackSizeIncrements() {
        final int expected = 3;
        final int actual;

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        actual = arrayStack.size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void pushedValueIsInTheStack()
    {
        final int expected = 4;
        final int actual;

        arrayStack.push(4);
        actual = arrayStack.peak();
        assertThat(actual).isEqualTo(expected);
    }

    @Test (expected=EmptyStackException.class)
    public void shouldThrowExceptionWhenPeakValueFromEmptyStack() {
        arrayStack.peak();
    }

    @Test
    public void shouldReturnValueWhenPopFromStack()
    {
        final int expected = 3;
        final int actual;

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        actual = arrayStack.pop();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenPopValueExpectStackSizeDecreased()
    {
        final int expected = 2;
        final int actual;

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.pop();
        actual =  arrayStack.size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test (expected=EmptyStackException.class)
    public void shouldThrowExceptionWhenPopFromEmptyStack() {
        arrayStack.pop();
    }

    @Test
    public void resizeStackWhenLastCellOfArrayIsFilled() {
        final int firstSize = 2;
        final int actual;
        ArrayStack myStack = new ArrayStack(firstSize);

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        actual = myStack.size();
        assertThat(actual).isGreaterThan(firstSize);
    }
}
