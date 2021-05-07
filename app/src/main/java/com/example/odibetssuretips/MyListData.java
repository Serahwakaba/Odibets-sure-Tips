package com.example.odibetssuretips;


import android.widget.TextView;

public class MyListData{
    private int time;
    //private String matches;
   // private int scores;
    private int prediction;
    private double odds;
    private  String home_team;
    private  String away_team;

    public MyListData(int time,int prediction, double odds, String home_team, String away_team) {
        this.time = time;
        //this.matches = matches;
        //scores = scores;
        this.prediction = prediction;
        this.odds = odds;
        this.home_team = home_team;
        this.away_team = away_team;
    }

    public MyListData(TextView time, TextView matchOne, TextView matchTwo, TextView tips, TextView odds) {
    }


    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public void setAway_team(String away_team) {
        this.away_team = away_team;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    /*
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
    
     */

    public int getPrediction() {
        return prediction;
    }

    public void setPrediction(int prediction) {
        this.prediction = prediction;
    }

    public double getOdds() {
        return odds;
    }

    public void setOdds(double odds) {
        this.odds = odds;
    }
}