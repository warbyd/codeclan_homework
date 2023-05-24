public class Dragon implements Creature {
    @Override
    public short defend(int damage) {
        System.out.println("Dragon uses its scales to defend!");
        return (short) Math.max(damage - 20, 0); // Reduce the damage by 20, but don't go below 0
    }

    @Override
    public int attack() {
        System.out.println("Dragon breathes fire!");
        return 20; // Dragon's attack does 20 damage points
    }

    @Override
    public void flee() {

    }
}