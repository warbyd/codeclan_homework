public class Dragon implements Creature {
    @Override
    public short defend(int damage) {
        System.out.println("Dragon uses its scales to defend!");
        return 0;
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