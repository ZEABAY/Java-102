import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int maxHealth;
    private int money;
    private String name;
    private String charName;
    private Inventory inventory;
    Scanner scan = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("--------------------------------------------------------------");
        for (GameChar gameChar : charList) {
            System.out.println(gameChar.getId() + "- Karakter: " + gameChar.getName() + "\t Hasar: " + gameChar.getDamage() + " \t Sağlık: " + gameChar.getHealth() + " \t Para: " + gameChar.getMoney());
        }
        System.out.println("--------------------------------------------------------------");

        System.out.print("Bir karakter seç: ");
        int selectChar = scan.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                System.out.println("Geçersiz karakter seçtin samuray ile savaşacaksın ..!");
                initPlayer(new Samurai());
                break;
        }
    }


    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMaxHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {

        System.out.println("Silah: " + this.getInventory().getWeapon().getName() +
                " \t Zırh: " + this.getInventory().getArmor().getName() +
                " \t Hasar: " + this.getTotalDamage() +
                " \t Block: " + this.getInventory().getArmor().getBlock() +
                " \t Sağlık: " + this.getHealth() +
                " \t Para: " + this.getMoney());

    }

    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean didWon() {
        return this.getInventory().hasFood() && this.getInventory().hasFireWood() && this.getInventory().hasWater();
    }

}
