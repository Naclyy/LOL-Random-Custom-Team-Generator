package com.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Player {
    private String userName;
    private boolean smurf;
    private String role;
    private String champion;

    public Player(String userName, boolean smurf){
        this.userName = userName;
        this.smurf = smurf;
    }

    @Override
    public String toString() {
        return "Player{" +
                "userName='" + userName + '\'' +
                ", smurf=" + smurf +
                ", role='" + role + '\'' +
                ", champion='" + champion + '\'' +
                '}';
    }

}
