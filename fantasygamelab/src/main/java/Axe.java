public class Axe implements Weapon {
    @Override
    public int use() {
        System.out.println("Player swings the axe!");
        return 20; //
    }
}