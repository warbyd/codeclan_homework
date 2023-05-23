import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WizardsTest {

    private Wizards wizard;
    private Equipment equipment, damagedEquipment;

    @BeforeEach
    void setUp() {
        wizard = new Wizards("Gandalf");
        equipment = new Equipment("Tharkun", Material.WOOD);
        damagedEquipment = new Equipment("Broken Tharkun", Material.WOOD);
        damagedEquipment.damage(45);
    }

    @Test
    void getName() {
        assertEquals("Gandalf", wizard.getName());
    }

    @Test
    void getStrength() {
        assertEquals(10, wizard.getStrength());
    }

    @Test
    void getStealth() {
        assertEquals(10, wizard.getStealth());
    }

    @Test
    void gainAndRepairEquipment() {
        wizard.gainEquipment(equipment);
        assertTrue(wizard.getEquipments().contains(equipment));

        assertFalse(wizard.repairEquipment(equipment));

        wizard.gainEquipment(damagedEquipment);
        assertTrue(wizard.repairEquipment(damagedEquipment));
    }
}
