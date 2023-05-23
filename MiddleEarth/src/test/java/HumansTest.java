import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumansTest {

    private Humans human;
    private Equipment equipment;
    private Equipment damagedEquipment;

    @BeforeEach
    void setUp() {
        human = new Humans("Aragorn");
        equipment = new Equipment("Narsil", Material.STEEL);
        damagedEquipment = new Equipment("Anduril", Material.STEEL);
        damagedEquipment.damage(30); // This equipment is partially damaged
    }

    @Test
    void getName() {
        assertEquals("Aragorn", human.getName());
    }

    @Test
    void getStrength() {
        assertEquals(9, human.getStrength());
    }

    @Test
    void getStealth() {
        assertEquals(6, human.getStealth());
    }

    @Test
    void gainEquipment() {
        human.gainEquipment(equipment);
        assertTrue(human.getEquipments().contains(equipment));
    }

    @Test
    void repairEquipment() {
        // Trying to repair undamaged equipment
        human.gainEquipment(equipment);
        assertFalse(human.repairEquipment(equipment));  // This should be false because the equipment is not damaged

        // Trying to repair damaged equipment
        human.gainEquipment(damagedEquipment);
        assertTrue(human.repairEquipment(damagedEquipment));  // This should be true because the equipment was damaged

        // Check if the equipment is repaired
        assertEquals(100, damagedEquipment.getDurability());  // After repair, durability should be 100
    }
}

