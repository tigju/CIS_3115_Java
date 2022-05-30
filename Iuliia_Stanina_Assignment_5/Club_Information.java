public class Club_Information {
    private String team = "";
    private String position = "";

    Club_Information(String team, String position){
        this.team = team;
        this.position = position;
    }

    String getTeam(){
        return this.team;
    }
    
    String getPosition() {
        return this.position;
    }

    void setTeam(String team) {
        this.team = team;
    }

    void setPosition(String position) {
        this.position = position;
    }

    String toStr() {
        return "Club Information => Team: " + this.team + ", " + "Position: " + this.position + "\n";
    }
}
