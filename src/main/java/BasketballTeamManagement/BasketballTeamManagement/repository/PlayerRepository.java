package BasketballTeamManagement.BasketballTeamManagement.repository;

import BasketballTeamManagement.BasketballTeamManagement.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository <Player, Long> {
}
