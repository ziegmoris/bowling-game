import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {

    @Test
    public void given_no_spare_or_strike_when_get_score_then_will_equal_to_60() {
        assertThat(new BowlingGame("12345123451234512345").getScore(), is(60));
    }
}
