import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

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

        int size = players.size();
        int ageLess25 = 0;
        int ageLess30GreaterEqual25 = 0;
        int ageLess40GreaterEqual30 = 0;
        int otherAge = 0;

        int underWeightPlayers = 0;
        int healthyPlayers = 0;
        int overWeightPlayers = 0;
        int obesePlayers = 0;

        for (Player p : players) {
            double currAge = p.getPerson_Information().getAge();
            if (currAge < 25) 
                ageLess25++;
            else if(currAge >= 25 && currAge < 30)
                ageLess30GreaterEqual25++;
            else if(currAge >= 30 && currAge < 40)
                ageLess40GreaterEqual30++;
            else
                otherAge++;
        }
        for (Player pl : players) {
            String currBMIStatus = pl.getPerson_Information().getBMIStatus();
            if (currBMIStatus.equals("Underweight"))
                underWeightPlayers++;
            else if (currBMIStatus.equals("Healthy"))
                healthyPlayers++;
            else if (currBMIStatus.equals("Overweight"))
                overWeightPlayers++;
            else if (currBMIStatus.equals("Obese"))
                obesePlayers++;
        }


        System.out.println("Number of players: " + size + "\n");
        System.out.println("Number of players <25: " + ageLess25 + "\n");
        System.out.println("Number of players >=25 and <30: " + ageLess30GreaterEqual25 + "\n");
        System.out.println("Number of players >=30 and <40: " + ageLess40GreaterEqual30 + "\n");
        System.out.println("Number of players of other age: " + otherAge + "\n");

        System.out.println("Number of players is underweight: " + underWeightPlayers + "\n");
        System.out.println("Number of players is healthy: " + healthyPlayers + "\n");
        System.out.println("Number of players is overweight: " + overWeightPlayers + "\n");
        System.out.println("Number of players is obese: " + obesePlayers + "\n");
    }
}



