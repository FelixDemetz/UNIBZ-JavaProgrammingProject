package projectgrouplf.projectlf;

public class Base { // should it be static?

    public static boolean survival = false;
    private static int baseHealth;
    private static int baseMoney = 999999; // should be 100

    public Base() {
    }

    // Getters
    public static int getBaseHealth() {
        return baseHealth;
    }
    public static int getBaseMoney() {
        return baseMoney;
    }
    // Setters
    public static void setBaseHealth(int newBaseHealth) {
        Base.baseHealth = newBaseHealth;
    }
    public static void setBaseMoney(int newBaseMoney) {
        Base.baseMoney = newBaseMoney;
    }
    public static void setSurvival(boolean a) {
        Base.survival = a;
    }
    public static void survivalOrNormalBaseHealt() {
        if (survival)
            setBaseHealth(1);
        else
            setBaseHealth(10);
    }

    
}
