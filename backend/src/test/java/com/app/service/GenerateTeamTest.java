package com.app.service;

import com.app.model.Player;
import com.app.model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GenerateTeamTest {
    @Mock
    GenerateTeam generateTeam;

    @BeforeEach
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkGenerateTeams() throws IOException {
        Team team = createTeam();
        generateTeam.generateTeams();
        verify(generateTeam, times(1)).generateTeams();
    }

    @Test
    public void checkShuffleChampions() throws IOException {
        List<String> usedChampions = new ArrayList<>();
        Team team = createTeam();
        generateTeam.shuffleChampions(team, usedChampions);
        verify(generateTeam, times(1)).shuffleChampions(team, usedChampions);
    }
    @Test
    public void checkShuffleTeams(){
        Team team = createTeam();
        generateTeam.shuffleTeams(team.getPlayers());
        verify(generateTeam, times(1)).shuffleTeams(team.getPlayers());
    }

    @Test
    public void checkShuffleRoles(){
        Team team = createTeam();
        generateTeam.shuffleRoles(team);
        verify(generateTeam, times(1)).shuffleRoles(team);
    }
    public Team createTeam(){
        Team team = new Team();
        List<Player> players = new ArrayList<>();
        players.add(new Player("Vacaru", true));
        players.add(new Player("Nicu", true));
        players.add(new Player("Capatina", false));
        players.add(new Player("Naclor", false));
        players.add(new Player("Tudor", false));
        players.add(new Player("Codrin", false));
        players.add(new Player("Trandaf", false));
        players.add(new Player("Nicoleta", true));
        players.add(new Player("Mosor", false));
        players.add(new Player("Alex", false));
        team.setPlayers(players);
        return team;
    }
}
