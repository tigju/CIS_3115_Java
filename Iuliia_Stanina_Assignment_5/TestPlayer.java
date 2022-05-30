import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestPlayer {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        try {
            File myObj = new File("players.txt");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            while (myReader.hasNextLine()) {
                
                data = myReader.nextLine();
                String[] str = data.split(",");

                String n = str[0].trim();
                String t = str[1].trim();
                String p = str[2].trim();
                double h = Double.parseDouble(str[3]);
                double w = Double.parseDouble(str[4]);
                double a = Double.parseDouble(str[5]);
                Person_Information perInf = new Person_Information(a, h, w);
                Club_Information clubInf = new Club_Information(t, p);
                Player player = new Player(n, perInf, clubInf);
                players.add(player);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        /* Assignment 4 */
        //int size = players.size();
        // int ageLess25 = 0;
        // int ageLess30GreaterEqual25 = 0;
        // int ageLess40GreaterEqual30 = 0;
        // int otherAge = 0;

        // int underWeightPlayers = 0;
        // int healthyPlayers = 0;
        // int overWeightPlayers = 0;
        // int obesePlayers = 0;

        // for (Player p : players) {
        //     double currAge = p.getPerson_Information().getAge();
        //     if (currAge < 25) 
        //         ageLess25++;
        //     else if(currAge >= 25 && currAge < 30)
        //         ageLess30GreaterEqual25++;
        //     else if(currAge >= 30 && currAge < 40)
        //         ageLess40GreaterEqual30++;
        //     else
        //         otherAge++;
        // }
        // for (Player pl : players) {
        //     String currBMIStatus = pl.getPerson_Information().getBMIStatus();
        //     if (currBMIStatus.equals("Underweight"))
        //         underWeightPlayers++;
        //     else if (currBMIStatus.equals("Healthy"))
        //         healthyPlayers++;
        //     else if (currBMIStatus.equals("Overweight"))
        //         overWeightPlayers++;
        //     else if (currBMIStatus.equals("Obese"))
        //         obesePlayers++;
        // }


        // System.out.println("Number of players: " + size + "\n");
        // System.out.println("Number of players <25: " + ageLess25 + "\n");
        // System.out.println("Number of players >=25 and <30: " + ageLess30GreaterEqual25 + "\n");
        // System.out.println("Number of players >=30 and <40: " + ageLess40GreaterEqual30 + "\n");
        // System.out.println("Number of players of other age: " + otherAge + "\n");

        // System.out.println("Number of players is underweight: " + underWeightPlayers + "\n");
        // System.out.println("Number of players is healthy: " + healthyPlayers + "\n");
        // System.out.println("Number of players is overweight: " + overWeightPlayers + "\n");
        // System.out.println("Number of players is obese: " + obesePlayers + "\n");


        /* Assignment 5 part */
        // 1. How many players are in each team among mlp players?
        HashMap<String, Integer> playersPerTeam = new HashMap<>();

        for (Player pl : players) {
            String teamName = pl.getClub_Information().getTeam();
            int count = playersPerTeam.getOrDefault(teamName, 0); // ensure count will be one of 0,1,2,3,...
            playersPerTeam.put(teamName, count + 1);
        }

        System.out.println("Players in each team \n");

        for (String key : playersPerTeam.keySet()){
            System.out.println(key + ": " +playersPerTeam.get(key));
        }

        // 2. Display the position distribution in each team
        HashMap<String, HashMap<String, Integer>> positionDistribution = new HashMap<>();
        HashMap<String, Integer> positionsPerTeam = new HashMap<>();

        for (Player pl : players) {

            String teamName = pl.getClub_Information().getTeam();
            String positionName = pl.getClub_Information().getPosition();
            if (positionDistribution.containsKey(teamName)) {
                int count = positionsPerTeam.getOrDefault(positionName, 0); // ensure count will be one of 0,1,2,3,...
                positionsPerTeam.put(positionName, count + 1);
                positionDistribution.put(teamName, positionsPerTeam);

            }
            else {
                positionDistribution.put(teamName, positionsPerTeam);
                positionsPerTeam = new HashMap<>();
            }
            
        }

        System.out.println("Position distribution in each team \n");

        for (String key : positionDistribution.keySet()) {
            System.out.println(key + ": ");
            System.out.println("----");
            HashMap<String, Integer> f = positionDistribution.get(key);
            for (String k : f.keySet()) {
                System.out.println(k + ": " + f.get(k) + " players");
            }
            System.out.println("============================");
        }

        // 3. How many players are in each position among mlp players?
        HashMap<String, Integer> playersPerPos = new HashMap<>();

        for (Player pl : players) {
            String posName = pl.getClub_Information().getPosition();
            int count = playersPerPos.getOrDefault(posName, 0); 
            playersPerPos.put(posName, count + 1);
        }

        System.out.println("Players in each position \n");

        for (String key : playersPerPos.keySet()){
            System.out.println(key + ": " + playersPerPos.get(key));
        }

        // 4. Display the team distribution in each position
        HashMap<String, HashMap<String, Integer>> posDis = new HashMap<>();
        HashMap<String, Integer> posPerTeam = new HashMap<>();

        for (Player pl : players) {

            String teamName = pl.getClub_Information().getTeam();
            String positionName = pl.getClub_Information().getPosition();
            if (posDis.containsKey(teamName)) {
                int count = posPerTeam.getOrDefault(positionName, 0); // ensure count will be one of 0,1,2,3,...
                posPerTeam.put(positionName, count + 1);
                posDis.put(teamName, posPerTeam);

            }
            else {
                posDis.put(teamName, posPerTeam);
                posPerTeam = new HashMap<>();
            }
        }

        for (String key : posPerTeam.keySet()){
            System.out.println(key);
            System.out.println("------");
            for (String k : posDis.keySet()) {
                HashMap<String, Integer> b = posDis.get(k);
                
                System.out.println(k +": "+ b.get(key) + " players");
            }
            System.out.println("======================");
        }

    }
}



