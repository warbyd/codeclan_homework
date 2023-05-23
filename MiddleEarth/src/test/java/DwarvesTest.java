import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DwarvesTest {

    private Dwarves dwarf;
    private Equipment equipment;
    private Equipment damagedEquipment;

    @BeforeEach
    void setUp() {
        dwarf = new Dwarves("Gimli");
        equipment = new Equipment("Axe", Material.IRON);
        damagedEquipment = new Equipment("Broken helmet", Material.IRON);
        damagedEquipment.damage(70); // This equipment is significantly damaged
    }

    @Test
    void getName() {
        assertEquals("Gimli", dwarf.getName());
    }

    @Test
    void getStrength() {
        assertEquals(9, dwarf.getStrength());
    }

    @Test
    void getStealth() {
        assertEquals(3, dwarf.getStealth());
    }

    @Test
    void gainEquipment() {
        dwarf.gainEquipment(equipment);
        assertTrue(dwarf.getEquipments().contains(equipment));
    }

    @Test
    void repairEquipment() {
        // Trying to repair undamaged equipment
        dwarf.gainEquipment(equipment);
        assertFalse(dwarf.repairEquipment(equipment));  // This should be false because the equipment is not damaged

        // Trying to repair damaged equipment
        dwarf.gainEquipment(damagedEquipment);
        assertTrue(dwarf.repairEquipment(damagedEquipment));  // This should be true because the equipment was damaged

        // Check if the equipment is repaired
        assertEquals(100, damagedEquipment.getDurability());  // After repair, durability should be 100
    }
}
