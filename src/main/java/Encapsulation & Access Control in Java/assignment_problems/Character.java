public class Character {
    private final int maxHealth;
    private int currentHealth;

    public Character(int maxHealth) {
        this.maxHealth = Math.max(0, maxHealth); // Prevent negative max health
        this.currentHealth = this.maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) return;
        // Clamp health at a minimum of 0
        this.currentHealth = Math.max(0, this.currentHealth - amount);
    }

    public void heal(int amount) {
        if (amount <= 0) return;
        // Clamp health at a maximum of maxHealth
        this.currentHealth = Math.min(this.maxHealth, this.currentHealth + amount);
    }

    // Read-only getter for current health
    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        System.out.println("Initial health: " + c.getCurrentHealth());

        c.takeDamage(30);
        System.out.println("c.takeDamage(30) -> health = " + c.getCurrentHealth());

        c.heal(50);
        System.out.println("c.heal(50) -> health = " + c.getCurrentHealth() + " (capped)");

        c.takeDamage(150);
        System.out.println("c.takeDamage(150) -> health = " + c.getCurrentHealth() + " (floored)");
    }
}