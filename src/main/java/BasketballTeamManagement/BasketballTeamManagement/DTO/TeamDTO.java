package BasketballTeamManagement.BasketballTeamManagement.DTO;

import java.time.LocalDate;
import java.util.List;

public class TeamDTO {
    private String name;
    private double salaryCap;
    private List<PlayerDTO> players;
    private LocalDate dateCreated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalaryCap() {
        return salaryCap;
    }

    public void setSalaryCap(double salaryCap) {
        this.salaryCap = salaryCap;
    }

    public List<PlayerDTO> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerDTO> players) {
        this.players = players;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}