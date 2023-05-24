public class Potion implements HealingTool {
    @Override
    public int use() {
        System.out.println("Potion heals player!");
        return 15; // Potion heals 15 health points
    }
}