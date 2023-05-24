public class EnemyBow implements EnemyWeapon {
    private int damage;

    public EnemyBow() {
        this.damage = 5; // Set the default damage
    }

    public EnemyBow(int damage) {
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

