public class Sword implements Weapon {
    @Override
    public int use() {
        System.out.println("Player swings the sword!");
        return 10; // Sword does 10 damage points
    }
}