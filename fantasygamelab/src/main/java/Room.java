import java.util.ArrayList;
import java.util.List;

public class Room {
    private EncounterType encounterType;
    private List<Enemy> enemies;  // List to hold enemies
    private int treasure;

    public Room(EncounterType encounterType, int enemyCount, int treasure) {
        this.encounterType = encounterType;
        this.enemies = new ArrayList<>();
        this.treasure = treasure;

        for (int i = 0; i < enemyCount; i++) {
            this.enemies.add(new Enemy(EnemyType.GOBLIN));  // Add each enemy to the list
        }
    }

    public boolean isCompleted() {
        return enemies.isEmpty() && treasure == 0;
    }

    public EncounterType getEncounterType() {
        return encounterType;
    }

    public int getEnemyCount() {
        return enemies.size();  // Return the size of the list of enemies
    }

    public void defeatEnemy() {
        if (!enemies.isEmpty()) {
            enemies.remove(0);  // Remove an enemy from the list when defeated
        }
    }

    public List<Enemy> getEnemies() {
        return enemies;  // Return the list of enemies
    }

    public void collectTreasure(Player player) {
        if (treasure > 0) {
            player.addToInventory(treasure);
            treasure = 0;
        }
    }
}
