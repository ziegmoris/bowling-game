import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BowlingGame {
    private Integer score = 0;
    private List<Frame> frames = new ArrayList<>();

    BowlingGame(String scoreCard) {
        convertScoreCardToFrames(scoreCard);
    }

    private void convertScoreCardToFrames(String scoreCard) {
        for (int i = 0; i < scoreCard.length(); i++) {
            String score = String.valueOf(scoreCard.charAt(i));
            if ("X".equals(score)) {
                frames.add(new Frame(Collections.singletonList(score)));
            } else {
                String nextScore = String.valueOf(scoreCard.charAt(i + 1));
                frames.add(new Frame(Arrays.asList(score, nextScore)));
                i++;
            }
        }

    }

    Integer getScore() {
        frames.forEach(frame -> score += frame.getScore());
        return score;
    }
}
