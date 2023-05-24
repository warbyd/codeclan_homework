public class Dwarf extends Player {
    private Weapon weapon;
    private int armorPoints;

    public Dwarf(String name, int healthPoints, Weapon weapon, int armorPoints) {
        super(name, healthPoints);
        this.weapon = weapon;
        this.armorPoints = armorPoints;
    }

    @Override
    public void attack(Player target) {
        int damage = weapon.use();
        target.defend(damage);
    }

    @Override
    public void defend(int damage) {
        int reducedDamage = (int) (damage * 0.8); // Assuming dwarves can reduce 20% damage
        if (armorPoints >= reducedDamage) {
            armorPoints -= reducedDamage;
        } else {
            int remainingDamage = reducedDamage - armorPoints;
            armorPoints = 0;
            int newHealth = this.getHealthPoints() - remainingDamage;
            this.setHealthPoints(newHealth > 0 ? newHealth : 0);
        }
    }

    public void changeWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
    }

    public int getArmorPoints() {
        return armorPoints;
    }
}
