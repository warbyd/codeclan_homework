import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private int healthPoints;
    private String name;
    private List<Integer> inventory;

    public Player(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.inventory = new ArrayList<>();
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getInventory() {
        return inventory;
    }

    public abstract void attack(Player target);

    public void defend(int damage) {
        int newHealth = healthPoints - damage;
        healthPoints = Math.max(newHealth, 0);
    }

    public void addToInventory(int item) {
        inventory.add(item);
    }
}

