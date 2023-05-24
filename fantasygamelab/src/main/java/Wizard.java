public class Wizard extends Player {
    private Spell spell;
    private Creature creature;

    public Wizard(String name, int healthPoints, Spell spell, Creature creature) {
        super(name, healthPoints);
        this.spell = spell;
        this.creature = creature;
    }

    @Override
    public void attack(Player target) {
        int damage = spell.cast();
        target.defend(damage);
    }

    @Override
    public void defend(int damage) {
        int defendedDamage = creature != null ? creature.defend(damage) : damage;
        setHealthPoints(Math.max(0, getHealthPoints() - defendedDamage));
    }


    public void changeSpell(Spell newSpell) {
        this.spell = newSpell;
    }

    public void changeCreature(Creature newCreature) {
        this.creature = newCreature;
    }

    public Spell getSpell() {
        return spell;
    }

    public Creature getCreature() {
        return creature;
    }
}
