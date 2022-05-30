public class Player {
    private String name;
    private Person_Information person_information;
    private Club_Information club_information;

    Player(String name, Person_Information person_information, Club_Information club_information){
        this.name = name;
        this.person_information = person_information;
        this.club_information = club_information;
    }

    String getName(){
        return this.name;
    }

    Person_Information getPerson_Information(){
        return this.person_information;
    }
    
    Club_Information getClub_Information(){
        return this.club_information;
    }

    String toStr() {
        return "Player Information: => Name: " + this.name + ", info: " + this.person_information + ", club: " + this.club_information
                + "\n";
    }

}