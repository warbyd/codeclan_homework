public class Barbarian extends Player {
    private Weapon weapon;

    public Barbarian(String name, int healthPoints, Weapon weapon) {
        super(name, healthPoints);
        this.weapon = weapon;
    }

    @Override
    public void attack(Player target) {
        int damage = weapon.use();
        target.defend(damage);
    }

    @Override
    public void defend(int damage) {
        // Barbarians might have high health but low defense, they just absorb damage
        int newHealth = this.getHealthPoints() - damage;
        this.setHealthPoints(newHealth > 0 ? newHealth : 0);
    }

    public void changeWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
    }
}