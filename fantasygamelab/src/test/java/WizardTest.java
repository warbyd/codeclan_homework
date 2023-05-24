import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WizardTest {
    private Wizard wizard;
    private Dwarf target;
    private Horse horse;

    @BeforeEach
    public void setUp() {
        wizard = new Wizard("Wizard", 60, new Fireball(), new Dragon());
        target = new Dwarf("Dwarf", 60, new Axe(), 0);
        horse = new Horse();
    }

    @Test
    public void testAttack() {
        wizard.attack(target);
        assertEquals(40, target.getHealthPoints(), "Dwarf's health points should decrease by 20 after attack");
    }

    @Test
    public void testDefendWithDragonCreature() {
        wizard.changeCreature(new Dragon()); // change creature to Dragon
        wizard.defend(30);
        assertEquals(50, wizard.getHealthPoints(), "Wizard's health points should decrease by 10 when defending with a Dragon");
    }

    @Test
    public void testDefendWithHorseCreature() {
        wizard.changeCreature(horse);
        wizard.defend(30);
        assertEquals(40, wizard.getHealthPoints(), "Wizard's health points should decrease by 20 when defending with a Horse");
    }


    @Test
    public void testDefendWithoutCreature() {
        wizard.changeCreature(null); // Set the creature to null to simulate defending without a creature
        wizard.defend(30);
        assertEquals(30, wizard.getHealthPoints(), "Wizard's health points should decrease by 30 when defending without a creature");
    }


    @Test
    public void testChangeSpell() {
        wizard.changeSpell(new LightningStrike());
        assertTrue(wizard.getSpell() instanceof LightningStrike, "Wizard's spell should be changed to LightningStrike");
    }

    @Test
    public void testChangeCreature() {
        wizard.changeCreature(horse);
        assertTrue(wizard.getCreature() instanceof Horse, "Wizard's creature should be changed to Horse");
    }
}