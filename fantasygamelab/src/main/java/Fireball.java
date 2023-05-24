public class Fireball implements Spell {
    @Override
    public int cast() {
        System.out.println("Fireball strikes the enemy!");
        return 25; // Fireball does 25 damage points
    }
}