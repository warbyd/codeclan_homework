class LightningStrike implements Spell {
    @Override
    public int cast() {
        System.out.println("Lightning strike hits the enemy!");
        return 25; // LightningStrike does 25 damage points
    }
}