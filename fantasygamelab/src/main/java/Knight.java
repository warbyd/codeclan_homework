public class Knight extends Player {
    private Weapon weapon;
    private int armorPoints;

    public Knight(String name, int healthPoints, Weapon weapon, int armorPoints) {
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
        // Knights have armor that absorb some damage first
        if (armorPoints > damage) {
            armorPoints -= damage;
        } else {
            int remainingDamage = damage - armorPoints;
            armorPoints = 0;
            int newHealth = this.getHealthPoints() - remainingDamage;
            this.setHealthPoints(newHealth > 0 ? newHealth : 0);
        }
    }

    public void changeWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        System.out.println(this.getName() + " has changed their weapon to " + newWeapon.getClass().getSimpleName() + "!");
    }

    public void setArmorPoints(int armorPoints) {
        this.armorPoints = armorPoints;
    }


    public int getArmorPoints() {
        return armorPoints;
    }



}