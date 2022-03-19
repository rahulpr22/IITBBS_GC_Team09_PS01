package com.example.livescorecard;

public class footballData {
    private String date, team1, team2, goalStats, team1Goals, team2Goals, matchId;

    public footballData() {
    }

    public footballData(String date, String team1, String team2, String goalStats, String team1Goals, String team2Goals, String matchId) {
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.goalStats = goalStats;
        this.team1Goals = team1Goals;
        this.team2Goals = team2Goals;
        this.matchId = matchId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeam1() {
        return team1;
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

    public String getGoalStats() {
        return goalStats;
    }

    public void setGoalStats(String goalStats) {
        this.goalStats = goalStats;
    }

    public String getTeam1Goals() {
        return team1Goals;
    }

    public void setTeam1Goals(String team1Goals) {
        this.team1Goals = team1Goals;
    }

    public String getTeam2Goals() {
        return team2Goals;
    }

    public void setTeam2Goals(String team2Goals) {
        this.team2Goals = team2Goals;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }
}
