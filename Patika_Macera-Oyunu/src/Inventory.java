public class Inventory {
    private Weapon weapon;
    private Armor armor;

    private boolean food = false;
    private boolean fireWood = false;
    private boolean water = false;

    public Inventory() {
        this.weapon = new Weapon("Yumruk", -1, 0, 0);
        this.armor = new Armor("Paçavra", -1, 0, 0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean hasFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean hasFireWood() {
        return fireWood;
    }

    public void setFireWood(boolean fireWood) {
        this.fireWood = fireWood;
    }

    public boolean hasWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public void addItem(String item) {
        if (item.equals("food")) {
            setFood(true);
        } else if (item.equals("firewood")) {
            setFireWood(true);
        } else if (item.equals("water")) {
            setWater(true);
        }
    }


}
