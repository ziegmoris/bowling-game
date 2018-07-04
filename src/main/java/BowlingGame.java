import java.util.*;

class BowlingGame {
    private Integer score = 0;
    private List<Frame> frames = new ArrayList<>();

    BowlingGame(String scoreCard) {
        convertScoreCardToFrames(scoreCard);
    }

    private void convertScoreCardToFrames(String scoreCard) {
        for (int i = 0; i < scoreCard.length(); i++){
            String ballThrow = String.valueOf(scoreCard.charAt(i));
            Frame frame = null;
            switch (ballThrow){
                case "X":
                    if(i+2<scoreCard.length()){
                        frame = getFrameForStrike(scoreCard, i, ballThrow);
                    }
                    break;
                default:
                    if(willContinue(scoreCard, i)){
                        frame = performSettingOfFrame(scoreCard, i, ballThrow);
                        i++;
                    }
            }
            if(frame!=null){
                frames.add(frame);
            }
        }
    }

    private boolean willContinue(String scoreCard, int i) {
        return frames.size()<10&&i+1<scoreCard.length();
    }

    private Frame performSettingOfFrame(String scoreCard, int i, String ballThrow) {
        Frame frame;
        if(String.valueOf(scoreCard.charAt(i+1)).equals("/")){
            frame = getFrameForSpareOrNormal(scoreCard, i, "-");
            setBonusThrow(frame, String.valueOf(scoreCard.charAt(i+2)), "-");
        }
        else{
            frame = getFrameForSpareOrNormal(scoreCard, i, ballThrow);
        }
        return frame;
    }

    private Frame getFrameForSpareOrNormal(String scoreCard, int i, String s) {
        Roll firstRoll;
        Roll secondRoll;
        Frame frame;
        firstRoll = generateRoll(s);
        secondRoll = generateRoll(String.valueOf(scoreCard.charAt(i + 1)));
        frame = new Frame(firstRoll, secondRoll);
        return frame;
    }

    private Frame getFrameForStrike(String scoreCard, int i, String ballThrow) {
        Frame frame;
        frame = new Frame(generateRoll(ballThrow), generateRoll("-"));
        setBonusThrow(frame, String.valueOf(scoreCard.charAt(i+1)), String.valueOf(scoreCard.charAt(i+2)));
        return frame;
    }

    private void setBonusThrow(Frame frame, String firstThrow, String secondThrow){
        frame.setNextFrame(new Frame(generateRoll(firstThrow), generateRoll(secondThrow)));
    }

    private Roll generateRoll(String ballThrow){
        Roll roll = new Roll();
        switch (ballThrow){
            case "X":
                roll.setSymbol("STRIKE");
                break;
            case "/":
                roll.setSymbol("SPARE");
                break;
            case "-":
                roll.setSymbol("GUTTER");
                break;
            default:
                roll.setSymbol(ballThrow);
        }
        roll.setValue();
        return roll;
    }

    Integer getScore() {
        frames.forEach(frame -> score += frame.getScore());
        return score;
    }
}
