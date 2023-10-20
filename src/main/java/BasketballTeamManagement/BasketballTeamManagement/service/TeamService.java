package BasketballTeamManagement.BasketballTeamManagement.service;

import BasketballTeamManagement.BasketballTeamManagement.DTO.PlayerDTO;
import BasketballTeamManagement.BasketballTeamManagement.DTO.TeamDTO;
import BasketballTeamManagement.BasketballTeamManagement.entity.Player;
import BasketballTeamManagement.BasketballTeamManagement.entity.Team;
import BasketballTeamManagement.BasketballTeamManagement.exception.TeamNotFoundException;
import BasketballTeamManagement.BasketballTeamManagement.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerService playerService;


    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team getTeamById(Long id) {

        return teamRepository.findById(id).orElse(null);
    }

    public Team createTeam(TeamDTO teamDTO) {
        Team team = new Team();
        team.setName(teamDTO.getName());
        team.setSalaryCap(teamDTO.getSalaryCap());
        team.setDateCreated(teamDTO.getDateCreated());
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, TeamDTO teamDTO) {
        Team existingTeam = teamRepository.findById(id).orElse(null);
        if (existingTeam != null){
            existingTeam.setName(teamDTO.getName());
            return teamRepository.save(existingTeam);
        }
        return null;
    }

    public void deleteTeam(Long id) {

        teamRepository.deleteById(id);
    }

    public Team addToTeam(long id, PlayerDTO playerDTO){
        Team team = teamRepository.findById(id).orElseThrow(()-> new TeamNotFoundException("Team not found"));
        Player player = new Player();
        player.setTeam(team);
        player.setName(playerDTO.getName());
        player.setPosition(playerDTO.getPosition());
        player.setAge(playerDTO.getAge());
        player.setSalary(playerDTO.getSalary());
        player.setHeight(playerDTO.getHeight());
        playerService.addPlayerToTeam(player);

        team.getPlayers().add(player);
        return teamRepository.save(team);

    }
}