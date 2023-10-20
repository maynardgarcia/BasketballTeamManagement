package BasketballTeamManagement.BasketballTeamManagement.service;

import BasketballTeamManagement.BasketballTeamManagement.DTO.PlayerDTO;
import BasketballTeamManagement.BasketballTeamManagement.entity.Player;
import BasketballTeamManagement.BasketballTeamManagement.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public Player createPlayer(Long id, PlayerDTO playerDTO) {
        Player player = new Player();
        player.setName(playerDTO.getName());
        player.setHeight(playerDTO.getHeight());
        player.setPosition(playerDTO.getPosition());
        player.setSalary(playerDTO.getSalary());
        player.setAge(playerDTO.getAge());
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, Player player) {
        Player existingPlayer = playerRepository.findById(id).orElse(null);
        if(existingPlayer != null){
            existingPlayer.setName(player.getName());
            existingPlayer.setTeam(player.getTeam());
            return playerRepository.save(existingPlayer);
        }
        return null;
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    public Player addPlayerToTeam(Player player) {
        return playerRepository.save(player);
    }
}