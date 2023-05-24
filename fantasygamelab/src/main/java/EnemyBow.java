public class EnemyBow implements Weapon {
    private int damage;

    public EnemyBow() {
        this.damage = 0; // Set the default damage
    }

    public EnemyBow(int damage) {
        this.damage = damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int use() {
        return damage;
    }
}
