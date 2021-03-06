package com.example.livescorecard;

import java.io.Serializable;

public class cricketData implements Serializable {
    private String date,team1,team2, team1Score, team2Score, striker1, striker2, bowler, striker1Runs, striker2Runs, bowlerStats,matchId;
    private Long team1OversPlayed;
    private Long team2OversPlayed;

    public cricketData() {
    }

    public cricketData(String date, String team1, String team2, String team1Score, String team2Score, String striker1, String striker2, String bowler, String striker1Runs, String striker2Runs, String bowlerStats, Long team1OversPlayed, Long team2OversPlayed,String matchId) {
        this.team1 = team1;
        this.date= date;
        this.team2 = team2;
        this.team1Score = team1Score;
        this.team2Score = team2Score;
        this.striker1 = striker1;
        this.striker2 = striker2;
        this.bowler = bowler;
        this.striker1Runs = striker1Runs;
        this.striker2Runs = striker2Runs;
        this.bowlerStats = bowlerStats;
        this.team1OversPlayed = team1OversPlayed;
        this.team2OversPlayed = team2OversPlayed;
        this.matchId=matchId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getTeam1() {
        return team1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(String team1Score) {
        this.team1Score = team1Score;
    }

    public String getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(String team2Score) {
        this.team2Score = team2Score;
    }

    public String getStriker1() {
        return striker1;
    }

    public void setStriker1(String striker1) {
        this.striker1 = striker1;
    }

    public String getStriker2() {
        return striker2;
    }

    public void setStriker2(String striker2) {
        this.striker2 = striker2;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public String getStriker1Runs() {
        return striker1Runs;
    }

    public void setStriker1Runs(String striker1Runs) {
        this.striker1Runs = striker1Runs;
    }

    public String getStriker2Runs() {
        return striker2Runs;
    }

    public void setStriker2Runs(String striker2Runs) {
        this.striker2Runs = striker2Runs;
    }

    public String getBowlerStats() {
        return bowlerStats;
    }

    public void setBowlerStats(String bowlerStats) {
        this.bowlerStats = bowlerStats;
    }

    public Long getTeam1OversPlayed() {
        return team1OversPlayed;
    }

    public void setTeam1OversPlayed(Long team1OversPlayed) {
        this.team1OversPlayed = team1OversPlayed;
    }

    public Long getTeam2OversPlayed() {
        return team2OversPlayed;
    }

    public void setTeam2OversPlayed(Long team2OversPlayed) {
        this.team2OversPlayed = team2OversPlayed;
    }
}
