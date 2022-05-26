package projectgrouplf.projectlf;

public class Base { // should it be static?

    public static boolean survival = false;
    private static int baseHealth;
    private static int baseMoney = 100; // should be 100
    private static int initialBaseMoney = baseMoney;

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
    public static void survivalOrNormalBaseHealt() {
        if (survival)
            setBaseHealth(1);
        else
            setBaseHealth(10);
    }
    public static void resetBaseMoney() {
        Base.baseMoney = initialBaseMoney;
    }

    
}
