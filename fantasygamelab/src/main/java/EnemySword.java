public class EnemySword implements Weapon {
    private int damage;

    public EnemySword() {
        this.damage = 5; // Set the default damage
    }

    public EnemySword(int damage) {
        this.damage = damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int use() {
        return damage;
    }
}
