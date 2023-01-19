package com.app.controller;

import com.app.model.Player;
import com.app.model.Team;
import com.app.service.GenerateTeam;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class TeamController {

    private final GenerateTeam generateTeam;

    public TeamController(GenerateTeam generateTeam) {
        this.generateTeam = generateTeam;
    }

    @GetMapping("teams")
    public List<Team> generateTeam() throws IOException {
        return generateTeam.generateTeams();
    }

    @PostMapping("players")
    public void addPlayers(@RequestBody List<Player> players){
        generateTeam.addPlayers(players);
    }
}
