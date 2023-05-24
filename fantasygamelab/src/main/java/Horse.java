public class Horse implements Creature {
    @Override
    public short defend(int damage) {
        System.out.println("Horse defends the wizard!");
        return 0;
    }

    @Override
    public int attack() {
        System.out.println("Horse kicks the enemy!");
        return 10; // Horse's attack does 10 damage points
    }

    @Override
    public void flee() {
        System.out.println("Horse helps the wizard escape!");
    }
}
