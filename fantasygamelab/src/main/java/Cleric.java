public class Cleric extends Player {
    private HealingTool healingTool;

    public Cleric(String name, int healthPoints, HealingTool healingTool) {
        super(name, healthPoints);
        this.healingTool = healingTool;
    }

    @Override
    public void attack(Player target) {

    }

    @Override
    public void defend(int damage) {
        // Clerics might have a unique defense mechanism, perhaps healing themselves.
        int reducedDamage = damage / 2; // Clerics reduce the damage by 50%
        int newHealth = this.getHealthPoints() - reducedDamage;
        this.setHealthPoints(newHealth > 0 ? newHealth : 0);
    }

    public void heal(Player target) {
        int healingPoints = healingTool.use();
        int targetNewHealth = target.getHealthPoints() + healingPoints;
        // Ensure health points do not exceed the maximum limit
        target.setHealthPoints(targetNewHealth > 100 ? 100 : targetNewHealth);
    }

    public void changeHealingTool(HealingTool newHealingTool) {
        this.healingTool = newHealingTool;
    }
}
