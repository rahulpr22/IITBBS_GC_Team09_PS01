package com.example.livescorecard;

public class badmintonData {
    private String date,team1,team2, player1, player2, set1Stats, set2Stats, set3Stats, gameStats, matchId;

    public badmintonData() {
    }

    public badmintonData(String date, String team1, String team2, String player1, String player2, String set1Stats, String set2Stats, String set3Stats, String gameStats, String matchId) {
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.player1 = player1;
        this.player2 = player2;
        this.set1Stats = set1Stats;
        this.set2Stats = set2Stats;
        this.set3Stats = set3Stats;
        this.gameStats = gameStats;
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

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getSet1Stats() {
        return set1Stats;
    }

    public void setSet1Stats(String set1Stats) {
        this.set1Stats = set1Stats;
    }

    public String getSet2Stats() {
        return set2Stats;
    }

    public void setSet2Stats(String set2Stats) {
        this.set2Stats = set2Stats;
    }

    public String getSet3Stats() {
        return set3Stats;
    }

    public void setSet3Stats(String set3Stats) {
        this.set3Stats = set3Stats;
    }

    public String getGameStats() {
        return gameStats;
    }

    public void setGameStats(String gameStats) {
        this.gameStats = gameStats;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }


}
