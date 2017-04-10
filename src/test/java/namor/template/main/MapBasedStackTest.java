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
}
