package com.app.service;

import com.app.model.Player;
import com.app.model.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
@AllArgsConstructor
public class GenerateTeam {
    private final ParserService parserService = new ParserService();
    private List<Player> players;

    public void addPlayers(List<Player> players){
        System.out.println(players);
        this.players = players;
    }

    public List<Team> generateTeams() throws IOException {
        List<Team> teams = shuffleTeams(new ArrayList<>(players));
        while (!teams.get(0).checkSmurfs(teams.get(1))) {
            teams = shuffleTeams(new ArrayList<>(players));
        }
        List<String> usedChampions = new ArrayList<>();
        for (Team team : teams) {
            shuffleRoles(team);
            shuffleChampions(team, usedChampions);
            team.setPlayers(team.sortPlayersByRole());
            team.printTeam();
        }
        return teams;
    }



    public List<Team> shuffleTeams(List<Player> players) {
        Random random = new Random();
        List<Team> teams = new ArrayList<>();
        teams.add(new Team());
        while (players.size() > 5) {
            Player player = players.get(random.nextInt(players.size()));
            teams.get(0).addPlayer(player);
            players.remove(player);
        }
        teams.add(new Team());
        teams.get(1).setPlayers(players);
        return teams;
    }

    public void shuffleRoles(Team team) {
        List<String> roles = new ArrayList<>(Arrays.asList("top", "jungle", "middle", "adc", "support"));
        Random random = new Random();
        for (Player player : team.getPlayers()) {
            String position = roles.get(random.nextInt(roles.size()));
            player.setRole(position);
            roles.remove(position);
        }
    }

    public void shuffleChampions(Team team, List<String> usedChampions) throws IOException {
        Random random = new Random();
        String champion;
        for (Player player : team.getPlayers()) {
            List<String> champions = parserService.getChampionsByRole(player.getRole());
            champions.removeAll(usedChampions);
            while(true){
                champion = champions.get(random.nextInt(champions.size() / 2));
                if(!usedChampions.contains(champion)){
                    usedChampions.add(champion);
                    break;
                }
            }
            player.setChampion(champion);
        }
    }
}
