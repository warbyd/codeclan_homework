public enum EnemyType {
    GOBLIN(30, new EnemySword()),
    ORC(50, new EnemyAxe()),
    SKELETON(40, new EnemyBow());

    private int healthPoints;
    private Weapon weapon;

    EnemyType(int healthPoints, Weapon weapon) {
        this.healthPoints = healthPoints;
        this.weapon = weapon;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}

