public class Bow implements Weapon {
    @Override
    public int use() {
        System.out.println("Player shoots an arrow with the bow!");
        return 15; // Bow does 15 damage points
    }
}
