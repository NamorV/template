package namor.template.stack;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

// TODO: 20.03.17 [GUSb] A test class to check everything works, should be deleted with first finished task
public class ArrayStackTest {

    private ArrayStack arrayStack;
    private final IllegalAccessError exception = new IllegalAccessError();


    @Before
    public void setUp() throws Exception {
        arrayStack = new ArrayStack();
    }

    @Test
    public void Should_ReturnTrue_When_StackIsEmpty() {
        final boolean actual = arrayStack.IsEmpty();

        assertThat(actual).isTrue();
    }

    @Test
    public void When_PushValueIntoStack_Expect_StackIsEmptyFalse() {
        arrayStack.push(4);

        assertThat(arrayStack.IsEmpty()).isFalse();
    }

    @Test
    public void When_PushValueIntoStack_Expect_StackSizeIncrements() {
        final int expected = 3;
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        final int actual = arrayStack.stackSize();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void PushedValueIsInTheStack()
    {
        final int expected = 4;
        arrayStack.push(4);
        final int actual = arrayStack.peak();

        assertThat(actual).isEqualTo(expected);
    }

    @Test (expected=IllegalAccessError.class)
    public void Should_ThrowException_When_PeakValueFromEmptyStack() throws IllegalAccessError {
        arrayStack.peak();
    }

    @Test
    public void Should_ReturnValue_WhenPopFromStack()
    {
        final int expected = 3;
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        final int actual = arrayStack.pop();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void When_PopValue_Expect_StackSizeDecreased()
    {
        final int expected = 2;
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.pop();
        final int actual = arrayStack.stackSize();

        assertThat(actual).isEqualTo(expected);
    }

    @Test (expected=IllegalAccessError.class)
    public void Should_ThrowException_When_PopFromEmptyStack() throws IllegalAccessError
    {
        arrayStack.pop();
    }

    @Test
    public void Should_IncreaseCapability_When_PushToMachData()
    {
        final int expected = 20;
        for ( int i = 1; i < 11; i++)
            arrayStack.push(i);

        final int firstSize = arrayStack.stackSize();

        for ( int i = 1; i < 11; i++)
            arrayStack.push(i);

        assertThat(firstSize*2).isEqualTo(expected);
    }

}
