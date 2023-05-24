public class EnemySword implements EnemyWeapon {
    private int damage;

    public EnemySword() {
        this.damage = 15; // Set the default damage
    }

    public EnemySword(int damage) {
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

