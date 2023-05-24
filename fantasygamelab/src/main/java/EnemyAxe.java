public class EnemyAxe implements Weapon {
    private int damage;

    public EnemyAxe() {
        this.damage = 0; // Set the default damage
    }

    public EnemyAxe(int damage) {
        this.damage = damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int use() {
        return damage;
    }
}
