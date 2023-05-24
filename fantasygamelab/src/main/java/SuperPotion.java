public class SuperPotion implements HealingTool {
    @Override
    public int use() {
        System.out.println("SuperPotion greatly heals player!");
        return 30; // SuperPotion heals 30 health points
    }
}

