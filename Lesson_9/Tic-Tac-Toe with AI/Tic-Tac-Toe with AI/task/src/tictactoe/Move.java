package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Move {
    private List<Integer> score;
    private List<Integer> index;
    private int length;
    public Move() {
        this.index = new ArrayList<>();
        this.score = new ArrayList<>();
        this.length=0;
    }

    public void setScore(int score) {
        this.score.add(score);
        length++;
    }

    public int getLength() {
        return length;
    }

    public void setIndex(int index) {
        this.index.add(index);
    }

    public List<Integer> getScore() {
        return score;
    }

    public List<Integer> getIndex() {
        return index;
    }
}
