import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DwarfTest {
    private Dwarf dwarf;
    private Knight target;
    private Barbarian attacker;

    @BeforeEach
    public void setUp() {
        dwarf = new Dwarf("Dwarf", 60, new Sword(), 30);
        target = new Knight("Knight", 80, new Sword(), 50);
        attacker = new Barbarian("Barbarian", 70, new Axe());
    }

    @Test
    public void testAttack() {
        dwarf.attack(target);
        assertEquals(40, target.getArmorPoints(), "Knight's armor points should be reduced by 20 after attack");
    }

    @Test
    public void testDefendNoArmor() {
        dwarf.defend(40);
        assertEquals(58, dwarf.getHealthPoints(), "Dwarf's health points should decrease by 40 after defense");
    }

    @Test
    public void testDefendWithArmor() {
        dwarf.defend(20);
        assertEquals(60, dwarf.getHealthPoints(), "Dwarf's health points should not decrease after defense with armor");
        assertEquals(14, dwarf.getArmorPoints(), "Dwarf's armor points should be reduced by 10 after defense with armor");
    }


    @Test
    public void testChangeWeapon() {
        dwarf.changeWeapon(new Axe());
        dwarf.attack(target);
        assertEquals(80, target.getHealthPoints(), "Knight's health points should decrease by 20 after attack with Axe");
    }

}
