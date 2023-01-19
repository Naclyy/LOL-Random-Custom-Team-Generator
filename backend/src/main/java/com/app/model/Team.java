package com.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class Team {
    private List<Player> players = new ArrayList<>();

    public int getNumberOfSmurfs(){
        int numberOfSmurfs = 0;
        for (Player player : players) {
            if(player.isSmurf())
                numberOfSmurfs++;
        }
        return numberOfSmurfs;
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public boolean checkSmurfs(Team versusTeam) {
        return Math.abs(getNumberOfSmurfs() - versusTeam.getNumberOfSmurfs()) <= 1;
    }

    public List<Player> sortPlayersByRole(){
        List<Player> sortedList = new ArrayList<>(Arrays.asList(new Player(), new Player(), new Player(), new Player(), new Player()));
        for(Player player: players){
            if(Objects.equals(player.getRole(), "top"))
                sortedList.set(0, player);
            if(Objects.equals(player.getRole(), "jungle"))
                sortedList.set(1, player);
            if(Objects.equals(player.getRole(), "middle"))
                sortedList.set(2, player);
            if(Objects.equals(player.getRole(), "adc"))
                sortedList.set(3, player);
            if(Objects.equals(player.getRole(), "support"))
                sortedList.set(4, player);
        }
        return sortedList;
    }

    public void printTeam(){
        System.out.println("\nThe Smurf Team is: ");
        for(Player player : players){
            System.out.println(player.getUserName() + " " + player.getRole() + " " + player.getChampion());
        }
    }


}
