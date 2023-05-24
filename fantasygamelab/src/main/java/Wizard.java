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

    public void defend(int damage) {
        if (creature != null) {
            creature.defend(damage);
        } else {
            int newHealth = this.getHealthPoints() - damage;
            this.setHealthPoints(newHealth > 0 ? newHealth : 0);
        }
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