public class Enemy {
    private EnemyType type;
    private int healthPoints;

    public Enemy(EnemyType type) {
        this.type = type;
        this.healthPoints = type.getHealthPoints();
    }

    public void attack(Player target) {
        int damage = type.getWeapon().use();
        target.defend(damage);
    }


    public void defend(int damage) {
        int newHealth = healthPoints - damage;
        healthPoints = Math.max(newHealth, 0);
    }

    public boolean isDefeated() {
        return healthPoints == 0;
    }

    public EnemyWeapon getWeapon() {
        return type.getWeapon();
    }
}
