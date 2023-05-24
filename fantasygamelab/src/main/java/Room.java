import java.util.ArrayList;
import java.util.List;

public class Room {
    private int enemyCount;
    private int treasure;

    public Room(int enemyCount, int treasure) {
        this.enemyCount = enemyCount;
        this.treasure = treasure;
    }

    public boolean isCompleted() {
        return enemyCount == 0 && treasure == 0;
    }

    public int getEnemyCount() {
        return enemyCount;
    }

    public void defeatEnemy() {
        if (enemyCount > 0) {
            enemyCount--;
        }
    }

    public void collectTreasure(Player player) {
        if (treasure > 0) {
            player.addToInventory(treasure);
            treasure = 0;
        }
    }
}
