package namor.template.main;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MapBasedStackTest {

    private MapBasedStack mapBasedStack;

    @Before
    public void setUp() throws Exception {
        mapBasedStack = new MapBasedStack();
    }

    @Test
    public void whenStackIsEmptyExpectsTrue() {
        final boolean actual;

        actual = mapBasedStack.isEmpty();

        assertThat(actual).isTrue();
    }

    @Test
    public void whenElementPushedToStackIsEmptyExpectsFalse() {
        final boolean actual;

        mapBasedStack.push(1);
        actual = mapBasedStack.isEmpty();

        assertThat(actual).isFalse();
    }

    @Test
    public void peakReturnLastPushedValue() {
        final int expected = 2;
        final int actual;

        mapBasedStack.push(1);
        mapBasedStack.push(2);
        actual = mapBasedStack.peak();

        assertThat(actual).isEqualTo(expected);
    }

    @Test (expected = EmptyStackException.class)
    public void whenPeakFromEmptyStackThrowException() {
        mapBasedStack.peak();
    }

    @Test
    public void whenPushValueStackSizeIncreased() {
        final int expected = 2;
        final int actual;

        mapBasedStack.push(1);
        mapBasedStack.push(2);
        actual = mapBasedStack.size();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void whenPopValueStackSizeDecreased() {
        final int expected = 2;
        final int actual;

        mapBasedStack.push(1);
        mapBasedStack.push(2);
        mapBasedStack.push(3);
        mapBasedStack.pop();
        actual = mapBasedStack.size();
        
        assertThat(actual).isEqualTo(expected);
    }
}
