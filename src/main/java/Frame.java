class Frame {
    private Roll firstRoll;
    private Roll secondRoll;
    private Frame nextFrame = null;

    Frame(Roll firstRoll, Roll secondRoll){
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    Integer getScore() {
        if(this.nextFrame!=null){
            return this.nextFrame.firstRoll.getValue()+this.nextFrame.secondRoll.getValue() + firstRoll.getValue() + secondRoll.getValue();
        }
        else{
            return firstRoll.getValue() + secondRoll.getValue();
        }

    }

    void setNextFrame(Frame nextFrame){
        this.nextFrame = nextFrame;
    }
}
