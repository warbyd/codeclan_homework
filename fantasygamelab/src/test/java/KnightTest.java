import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {
    private Knight knight;
    private Dwarf target;
    private Barbarian attacker;

    @BeforeEach
    public void setUp() {
        knight = new Knight("Knight", 80, new Sword(), 50);
        target = new Dwarf("Dwarf", 60, new Axe(), 0);
        attacker = new Barbarian("Barbarian", 70, new Axe());
    }

    @Test
    public void testAttack() {
        knight.attack(target);
        assertEquals(52, target.getHealthPoints());
    }

    @Test
    public void testDefendArmorIntact() {
        int initialHealth = knight.getHealthPoints();
        attacker.attack(knight);
        assertEquals(initialHealth, knight.getHealthPoints(), "Knight's health should remain the same after defense");
        assertEquals(30, knight.getArmorPoints(), "Knight's armor should decrease by 20 after defense");
    }

    @Test
    public void testDefendArmorBroken() {
        knight.setArmorPoints(10);
        attacker.attack(knight);
        assertEquals(70, knight.getHealthPoints(), "Knight's health should decrease by 10 after defense");
        assertEquals(0, knight.getArmorPoints(), "Knight's armor should be 0 after defense");
    }

    @Test
    public void testChangeWeapon() {
        knight.changeWeapon(new Axe());
        knight.attack(target);
        assertEquals(44, target.getHealthPoints(), "Dwarf's health should decrease by 12 after attack - reduced due to dwarf defense values modifier");
    }

    @Test
    public void testGetArmorPoints() {
        assertEquals(50, knight.getArmorPoints(), "Knight's initial armor points should be 50");
    }
}
