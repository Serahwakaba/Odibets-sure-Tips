package com.example.odibetssuretips;


import android.widget.TextView;

public class MyListData{
    private String time;
    //private String matches;
   // private int scores;
    private String prediction;
    private String odds;
    private  String home_team;
    private  String away_team;


    public  MyListData(){

}

    public MyListData(String time,String prediction, String odds, String home_team, String away_team) {
        this.time = time;
        //this.matches = matches;
        //scores = scores;
        this.prediction = prediction;
        this.odds = odds;
        this.home_team = home_team;
        this.away_team = away_team;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
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


//    public MyListData(String time,String prediction, String odds, String home_team, String away_team) {
//        this.time = time;
//        //this.matches = matches;
//        //scores = scores;
//        this.prediction = prediction;
//        this.odds = odds;
//        this.home_team = home_team;
//        this.away_team = away_team;
//    }
//
//    public MyListData(TextView time, TextView matchOne, TextView matchTwo, TextView tips, TextView odds) {
//    }
//
//    public MyListData() {
//
//        this.time = time;
//        //this.matches = matches;
//        //scores = scores;
//        this.prediction = prediction;
//        this.odds = odds;
//        this.home_team = home_team;
//        this.away_team = away_team;
//
//    }
//
//
//    public String getHome_team() {
//        return home_team;
//    }
//
//    public void setHome_team(String home_team) {
//        this.home_team = home_team;
//    }
//
//    public String getAway_team() {
//        return away_team;
//    }
//
//    public void setAway_team(String away_team) {
//        this.away_team = away_team;
//    }
//
//    public String getTime(String time) {
//        return this.time;
//    }
//
//    public void setTime(String time) {
//        this.time = time;
//    }
//
//    /*
//    public String getMatches() {
//        return matches;
//    }
//
//    public void setMatches(String matches) {
//        this.matches = matches;
//    }
//
//    public int getScores() {
//        return scores;
//    }
//
//    public void setScores(int scores) {
//        this.scores = scores;
//    }
//
//     */
//
//    public String getPrediction() {
//        return prediction;
//    }
//
//    public void setPrediction(String prediction) {
//        this.prediction = prediction;
//    }
//
//    public String getOdds() {
//        return odds;
//    }
//
//    public void setOdds(String odds) {
//        this.odds = odds;
//    }
}