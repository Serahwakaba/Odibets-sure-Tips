package com.example.odibetssuretips;


public class MyListData{
    private int time;
    private String matches;
    private int scores;
    private int tips;
    private double odds;

    public MyListData(int time, String matches, int scores, int tips, double odds) {
        this.time = time;
        this.matches = matches;
        this.scores = scores;
        this.tips = tips;
        this.odds = odds;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getMatches() {
        return matches;
    }

    public void setMatches(String matches) {
        this.matches = matches;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public int getTips() {
        return tips;
    }

    public void setTips(int tips) {
        this.tips = tips;
    }

    public double getOdds() {
        return odds;
    }

    public void setOdds(double odds) {
        this.odds = odds;
    }
}