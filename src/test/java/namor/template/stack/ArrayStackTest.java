package namor.template.stack;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ArrayStackTest {

    private ArrayStack arrayStack;
    private final IllegalAccessError exception = new IllegalAccessError();

    @Before
    public void setUp() throws Exception {
        arrayStack = new ArrayStack();
    }

    @Test
    public void ShouldReturnTrueWhenStackIsEmpty() {
        final boolean actual = arrayStack.isEmpty();

        assertThat(actual).isTrue();
    }

    @Test
    public void WhenPushValueIntoStackExpectStackIsEmptyFalse() {
        arrayStack.push(4);

        assertThat(arrayStack.isEmpty()).isFalse();
    }

    @Test
    public void WhenPushValueIntoStackExpectStackSizeIncrements() {
        final int expected = 3;
        final int actual;

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        actual = arrayStack.stackSize();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void PushedValueIsInTheStack()
    {
        final int expected = 4;
        final int actual;

        arrayStack.push(4);
        actual = arrayStack.peak();
        assertThat(actual).isEqualTo(expected);
    }

    @Test (expected=RuntimeException.class)
    public void ShouldThrowExceptionWhenPeakValueFromEmptyStack() {
        arrayStack.peak();
    }

    @Test
    public void ShouldReturnValueWhenPopFromStack()
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
    public void WhenPopValueExpectStackSizeDecreased()
    {
        final int expected = 2;
        final int actual;

        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.pop();
        actual =  arrayStack.stackSize();

        assertThat(actual).isEqualTo(expected);
    }

    @Test (expected=RuntimeException.class)
    public void ShouldThrowExceptionWhenPopFromEmptyStack() throws RuntimeException {
        arrayStack.pop();
    }

    @Test
    public void ResizeStackWhenLastCellOfArrayIsFilled() {
        final int firstSize = 2;
        final int actual;
        ArrayStack myStack = new ArrayStack(firstSize);

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        actual = myStack.stackSize();
        assertThat(actual).isGreaterThan(firstSize);
    }

}
