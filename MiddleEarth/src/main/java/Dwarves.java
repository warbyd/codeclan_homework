import java.util.ArrayList;
import java.util.List;

public class Dwarves {

    private String name;
    private int strength;
    private int stealth;
    private List<Equipment> equipments;

    public Dwarves(String name) {
        this.name = name;
        this.strength = 9; // Dwarves are strong
        this.stealth = 3; // Low stealth for Dwarves
        this.equipments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getStealth() {
        return stealth;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void gainEquipment(Equipment equipment) {
        this.equipments.add(equipment);
    }

    public boolean repairEquipment(Equipment item) {
        if (this.equipments.contains(item) && item.getDurability() < 100) {
            item.repair();
            return true;
        }
        return false;
    }

}
