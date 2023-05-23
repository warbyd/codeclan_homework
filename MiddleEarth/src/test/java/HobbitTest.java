import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HobbitTest {

    private Hobbit hobbit;
    private Hobbit.Equipment equipment;
    private Hobbit.Equipment damagedEquipment;

    @BeforeEach
    void setUp() {
        hobbit = new Hobbit("Frodo");
        equipment = new Hobbit.Equipment("One Ring",Material.GOLD);
        damagedEquipment = new Hobbit.Equipment("Damaged Cloak", Material.CLOTH);
        damagedEquipment.damage(50); // This equipment is partially damaged
    }

    @Test
    void getName() {
        assertEquals("Frodo", hobbit.getName());
    }

    @Test
    void getStrength() {
        assertEquals(4, hobbit.getStrength());
    }

    @Test
    void getStealth() {
        assertEquals(10, hobbit.getStealth());
    }

    @Test
    void gainEquipment() {
        hobbit.gainEquipment(equipment);
        assertTrue(hobbit.getEquipments().contains(equipment));
    }

    @Test
    void repairEquipment() {
        // Trying to repair undamaged equipment
        hobbit.gainEquipment(equipment);
        assertFalse(hobbit.repairEquipment(equipment));  // This should be false because the equipment is not damaged

        // Trying to repair damaged equipment
        hobbit.gainEquipment(damagedEquipment);
        assertTrue(hobbit.repairEquipment(damagedEquipment));  // This should be true because the equipment was damaged

        // Check if the equipment is repaired
        assertEquals(100, damagedEquipment.getDurability());  // After repair, durability should be 100
    }

    @Test
    void canCarryRing() {
        Hobbit.Equipment ring = new Hobbit.Equipment("Ring", Material.GOLD);

        Hobbit sam = new Hobbit("Sam");
        sam.gainEquipment(ring);
        assertFalse(sam.hasRing());

        hobbit.gainEquipment(ring);
        assertTrue(hobbit.hasRing());
    }

}
