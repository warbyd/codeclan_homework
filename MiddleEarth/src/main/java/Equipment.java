public class Equipment {

    private String name;
    private int durability;
    private Material material;

    private boolean isRing;
    private boolean isDestroyed;

    public Equipment(String name, Material material) {
        this.name = name;
        this.material = material;
        this.isRing = false;
        this.durability = 100;
        this.isDestroyed = false;
    }


    public String getName() {
        return name;
    }

    public int getDurability() {
        return durability;
    }

    public Material getMaterial() {
        return material;
    }

    public void damage(int damageAmount) {
        boolean isRingInMountDoom = false;
        if (!isRingInMountDoom && !isRing()) {
            this.durability -= damageAmount;
            if (this.durability < 0) {
                this.durability = 0;
            }
        }
    }

    public void repair() {
        boolean isRingInMountDoom = false;
        if (!isRingInMountDoom) {
            this.durability = 100; // after repairing, the equipment returns to perfect condition
        }
    }

    public boolean isRing() {
        return isRing;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void throwIntoMountDoom() {
        if (isRing) {
            System.out.println("The Ring has been thrown into the fires of Mount Doom and destroyed!");
            isDestroyed = true;
        } else {
            System.out.println(name + " cannot be thrown into Mount Doom.");
        }
    }

    public void setRing() {
        this.isRing = true;
    }
}