package BasketballTeamManagement.BasketballTeamManagement.repository;

import BasketballTeamManagement.BasketballTeamManagement.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository <Team, Long> {
}
