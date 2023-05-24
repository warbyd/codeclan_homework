import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClericTest {
    private Cleric cleric;
    private Knight target;
    private Barbarian attacker;

    @BeforeEach
    public void setUp() {
        cleric = new Cleric("Cleric", 60, new Potion());
        target = new Knight("Knight", 80, new Sword(), 50);
        attacker = new Barbarian("Barbarian", 70, new Axe());
    }

    @Test
    public void testHeal() {
        cleric.heal(target);
        assertEquals(95, target.getHealthPoints());
    }

    @Test
    public void testHealOverMaxHealth() {
        target.setHealthPoints(95);
        cleric.heal(target);
        assertEquals(100, target.getHealthPoints(), "Health points should not exceed 100");
    }

    @Test
    public void testDefend() {
        attacker.attack(cleric);
        assertEquals(50, cleric.getHealthPoints(), "Cleric's health should decrease by 10 after attack");
    }

    @Test
    public void testChangeHealingTool() {
        cleric.changeHealingTool(new SuperPotion());
        cleric.heal(target);
        assertEquals(100, target.getHealthPoints(), "Health points should be fully restored after using SuperPotion");
    }
}
