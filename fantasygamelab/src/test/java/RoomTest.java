import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
    private Room fullRoom;
    private Knight knight;
    private Enemy enemy;

    @BeforeEach
    public void setUp() {
        fullRoom = new Room(EncounterType.FULL_ROOM, 3, 50);
        knight = new Knight("Knight", 100, new Sword(), 200); // Assuming knight starts with 100 health and 200 armor
        enemy = new Enemy(EnemyType.GOBLIN);
    }


    @Test
    public void testFullRoom() {
        // Initial state
        assertFalse(fullRoom.isCompleted(), "FullRoom should be initially incomplete");

        // Defeating the enemies
        int remainingEnemies = fullRoom.getEnemyCount(); // Get the initial enemy count
        for (int i = 0; i < remainingEnemies; i++) {
            enemy.attack(knight);
            fullRoom.defeatEnemy(); // Mark the enemy as defeated

            fullRoom.collectTreasure(knight);
        }

        // Checking final states
        assertTrue(fullRoom.isCompleted(), "FullRoom should be marked as completed");
        assertTrue(knight.getHealthPoints() <= 100, "Knight's health points should be reduced by enemy attacks");
        assertEquals(155, knight.getArmorPoints(), "Knight's armor points should be reduced by enemy attacks"); // Assumption
        assertEquals(1, knight.getInventory().size(), "Knight should have collected the treasure");
    }
}
