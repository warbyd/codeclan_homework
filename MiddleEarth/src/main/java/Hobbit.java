import java.util.ArrayList;
import java.util.List;

public class Hobbit {
    private String name;
    private boolean hasRing;
    private int strength;
    private int stealth;
    private List<Equipment> equipments;

    public Hobbit(String name) {
        this.name = name;
        this.hasRing = false;
        this.strength = 4; // Hobbits are not particularly strong
        this.stealth = 10; // Hobbits are quite stealthy
        this.equipments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean hasRing() {
        return hasRing;
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
        if (equipment.getName().equals("Ring") && name.equals("Frodo")) {
            this.hasRing = true;
            System.out.println(name + " obtained the Ring!");
        } else {
            this.equipments.add(equipment);
        }
    }

    public boolean repairEquipment(Equipment equipment) {
        if (equipments.contains(equipment) && equipment.getDurability() < 100) {
            equipment.repair();
            return true;
        }
        return false;
    }

    public static class Equipment {
        private String name;
        private Material material;
        private int durability;

        public Equipment(String name, Material material) {
            this.name = name;
            this.material = material;
            this.durability = 100;
        }

        public String getName() {
            return name;
        }

        public Material getMaterial() {
            return material;
        }

        public int getDurability() {
            return durability;
        }

        public void repair() {
            this.durability = 100;
        }

        public void damage(int damageAmount) {
            this.durability -= damageAmount;
            if (this.durability < 0) this.durability = 0;
        }
    }
}
