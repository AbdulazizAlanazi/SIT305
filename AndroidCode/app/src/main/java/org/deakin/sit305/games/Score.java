package org.deakin.sit305.games;

public class Score {

    private int totalScore = 0;
    private int targetScore = 0;

    public void setSelectionCount(int selectionCount) {

            targetScore = selectionCount * (selectionCount - 1);
    }

    public void updateScore() {
        totalScore = totalScore + targetScore;
        targetScore = 0;

    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getTargetScore() {
        return targetScore;
    }

 }
