import java.util.List;

class Frame {
    private List<String> rolls;

    Frame(List<String> rolls) {
        this.rolls = rolls;
    }

    Integer getScore() {
        return rolls.stream().mapToInt(Integer::parseInt).sum();
    }
}
