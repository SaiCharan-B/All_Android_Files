package com.example.livecovidcasesapp;

public class Stats {
    private String date,active,recovery,deaths;

    public Stats(String date,String active,String recovery,String deaths)
    {

        this.date = date;
        this.active = active;
        this.recovery = recovery;
        this.deaths = deaths;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRecovery() {
        return recovery;
    }

    public void setRecovery(String recovery) {
        this.recovery = recovery;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }
}
