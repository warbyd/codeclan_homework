import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BarbarianTest {
    private Barbarian barbarian;
    private Knight target;
    private Weapon sword;
    private Weapon axe;

    @BeforeEach
    public void setUp() {
        sword = new Sword();
        axe = new Axe(); // Assuming Axe does 15 damage points
        barbarian = new Barbarian("Barb", 100, sword);  // assuming Barbarian starts with 100 health points
        target = new Knight("Knight", 80, sword, 50);  // assuming Knight starts with 80 health points and 50 armor points
    }

    @Test
    public void testAttack() {
        barbarian.attack(target);
        assertEquals(80, target.getHealthPoints(), "Health points should remain the same after attack");
        assertEquals(40, target.getArmorPoints(), "Armor points should be reduced by 10 after attack");
    }

    @Test
    public void testDefend() {
        barbarian.defend(30);
        assertEquals(70, barbarian.getHealthPoints(), "Health points should be reduced by 30 after defend");
    }

    @Test
    public void testChangeWeapon() {
        barbarian.changeWeapon(axe);
        barbarian.attack(target);
        assertEquals(30, target.getArmorPoints(), "Armor points should be reduced by 15 after attack");
        assertEquals(80, target.getHealthPoints(), "Health points should remain the same after attack");
    }


}

