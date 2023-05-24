import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
    private Room fullRoom;
    private Wizard wizard;
    private Enemy enemy;

    @BeforeEach
    public void setUp() {
        fullRoom = new Room(3, 50);
        wizard = new Wizard("Wizard", 100, new Fireball(), new Dragon());
        enemy = new Enemy(EnemyType.GOBLIN);
    }

    @Test
    public void testFullRoom() {
        // Initial state
        assertFalse(fullRoom.isCompleted(), "Full room should be initially incomplete");

        // Defeating the enemies
        int remainingEnemies = fullRoom.getEnemyCount(); // Get the initial enemy count
        int totalDamage = 0; // Accumulate the total damage
        for (int i = 0; i < remainingEnemies; i++) {
            int damage = enemy.getType().getWeapon().use();
            enemy.attack(wizard);
            totalDamage += damage; // Accumulate the damage inflicted by each enemy
            fullRoom.defeatEnemy(); // Mark the enemy as defeated
        }

        // Checking final states
        assertFalse(fullRoom.isCompleted(), "Full room should be marked as completed");
        assertEquals(85, wizard.getHealthPoints(), "Wizard's health points should be reduced by enemy attacks");
        assertEquals(150, wizard.getSpell().cast(), "Wizard's spell should deal expected damage");
        assertEquals(150, wizard.getCreature().defend(totalDamage), "Wizard's creature should defend with expected result");
        assertEquals(1, wizard.getInventory().size(), "Wizard should have collected the treasure");
    }
}
