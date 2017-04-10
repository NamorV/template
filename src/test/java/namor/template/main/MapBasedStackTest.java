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
}
