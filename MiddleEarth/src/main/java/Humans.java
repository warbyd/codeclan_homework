import java.util.ArrayList;
import java.util.List;

public class Humans {

    private String name;
    private int stealth;
    private int strength;
    private List<Equipment> equipments;

    public Humans(String name) {
        this.name = name;
        this.stealth = 6;
        this.strength = 9;
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
