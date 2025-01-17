package com.dam.acdat;

import com.google.gson.annotations.SerializedName;

public class RespuestaAPI {
    @SerializedName("teams")
    private Team[] teams;

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }
}
