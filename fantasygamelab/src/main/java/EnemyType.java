public enum EnemyType {
    GOBLIN(30, new EnemySword()),
    ORC(50, new EnemyAxe()),
    SKELETON(40, new EnemyBow());

    private int healthPoints;
    private EnemyWeapon weapon;

    EnemyType(int healthPoints, EnemyWeapon weapon) {
        this.healthPoints = healthPoints;
        this.weapon = weapon;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public EnemyWeapon getWeapon() {
        return weapon;
    }
}
