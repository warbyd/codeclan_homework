public class EnemyAxe implements EnemyWeapon {
    private int damage;

    public EnemyAxe() {
        this.damage = 25; // Set the default damage
    }

    public EnemyAxe(int damage) {
        this.damage = damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public int use() {
        return damage;
    }
}
