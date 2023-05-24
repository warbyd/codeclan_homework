import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private int healthPoints;
    private String name;
    private List<Integer> inventory;

    public Player(String name, int healthPoints) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.inventory = new ArrayList<Integer>();
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

    public abstract void defend(int damage);

    public void addToInventory(int item) {
        inventory.add(item);
    }
}
