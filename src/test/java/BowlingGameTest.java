import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class BowlingGameTest {

    @Test
    public void given_no_spare_or_strike_when_get_score_then_will_equal_to_60() {
        assertThat(new BowlingGame("12345123451234512345").getScore(), is(60));
    }

    @Test
    public void given_heartbreak_when_get_score_then_will_equal_to_90() {
        assertThat(new BowlingGame("9-9-9-9-9-9-9-9-9-9-").getScore(), is(90));
    }

    @Test
    public void given_all_strike_when_get_score_then_will_equal_to_90() {
        assertThat(new BowlingGame("XXXXXXXXXXXX").getScore(), is(300));
    }

    @Test
    public void givenASpareEachRoundWhenGetScoreThenWillEqualTo150() {
        assertThat(new BowlingGame("5/5/5/5/5/5/5/5/5/5/5").getScore(), is(150));
    }

    @Test
    public void givenASpareAndAStrikedWhenGetScoreThenWillEqualTo90() {
        assertThat(new BowlingGame("5/5354515154X525152").getScore(), is(90));
    }

    @Test
    public void givenASpareWhenGetScoreThenWillEqualTo79() {
        assertThat(new BowlingGame("5253545/515432525152").getScore(), is(79));
    }

    @Test
    public void givenASpareAtTheEndWhenGetScoreThenWillEqualTo86() {
        assertThat(new BowlingGame("5353543651543252515/9").getScore(), is(86));
    }
    @Test
    public void givenAStrikeWhenGetScoreThenWillEqualTo78() {
        assertThat(new BowlingGame("5-5354X515432525152").getScore(), is(78));
    }

    @Test
    public void givenASpareAtTheEndWhenGetScoreThenWillEqualTo47() {
        assertThat(new BowlingGame("1212121212121212121/X").getScore(), is(47));
    }

    @Test
    public void givenStrikeAtTheEndWhenGetScoreThenWillEqualTo40() {
        assertThat(new BowlingGame("121212121212121212X12").getScore(), is(40));
    }

    @Test
    public void givenSpareAndStrikeWhenGetScoreThenWillEqualTo200() {
        assertThat(new BowlingGame("5/X5/X5/X5/X5/X5/").getScore(), is(200));
    }
}
