package BasketballTeamManagement.BasketballTeamManagement.controller;

import BasketballTeamManagement.BasketballTeamManagement.DTO.PlayerDTO;
import BasketballTeamManagement.BasketballTeamManagement.DTO.TeamDTO;
import BasketballTeamManagement.BasketballTeamManagement.entity.Player;
import BasketballTeamManagement.BasketballTeamManagement.entity.Team;
import BasketballTeamManagement.BasketballTeamManagement.service.PlayerService;
import BasketballTeamManagement.BasketballTeamManagement.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams(){
        List<Team> teams = teamService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Long id) {
        Team team = teamService.getTeamById(id);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamDTO teamDTO) {
        Team newTeam = teamService.createTeam(teamDTO);
        return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
    }

    @PostMapping("/players/{id}")
    public ResponseEntity<Player> createPlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
        Team team = teamService.addToTeam(id, playerDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/players/{id}")
                .buildAndExpand(team)
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody TeamDTO team) {
        Team updatedTeam = teamService.updateTeam(id, team);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}