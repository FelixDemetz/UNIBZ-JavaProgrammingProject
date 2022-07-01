package projectgrouplf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Base {

    public static boolean survival = false;
    private static int baseHealth;
    private static int baseMoney = 100; // should be 100
    private static int initialBaseMoney = baseMoney;
    /** it is written in the Base class so that every other class can use the variable it easely */
    public static String scoreBoardRelativePath = "src/main/resources/Scoreboard.txt";

    public Base() {
    }

    // Getters
    public static int getBaseHealth() {
        return baseHealth;
    }
    public static int getBaseMoney() {
        return baseMoney;
    }
    public static String getBaseGameMode() {
        String returnString = "error";
        if (Base.survival)
            returnString = "Survival";
        else if (!Base.survival)
            returnString = "Normal";
        return returnString;
    }
    // Setters
    public static void setBaseHealth(int newBaseHealth) {
        Base.baseHealth = newBaseHealth;
    }
    public static void setBaseMoney(int newBaseMoney) {
        Base.baseMoney = newBaseMoney;
    }
    public static void survivalOrNormalBaseHealt() {
        if (Base.survival)
            setBaseHealth(1);
        else
            setBaseHealth(10);
    }
    public static void resetBaseMoney() {
        Base.baseMoney = initialBaseMoney;
    }

    /** Scanns the file containing the current Score Board (it is written in the Base class so that every other class can use the met it easely) */
    public static String readUserScoreBoard() {
        String s = "readUserScoreBoardFailed";
        try (BufferedReader br = new BufferedReader(new FileReader(scoreBoardRelativePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
        
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            s = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    
}
