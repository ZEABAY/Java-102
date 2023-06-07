import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
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
        GameChar[] charList = {new Samurai(), new Knight(), new Archer()};

        System.out.println("--------------------------------------------------------------");
        for (GameChar gameChar : charList) {
            System.out.println("Karakter: " + gameChar.getName() + "\t Hasar: " + gameChar.getDamage() + " \t Sağlık: " + gameChar.getHealth() + " \t Para: " + gameChar.getMoney());
        }
        System.out.println("--------------------------------------------------------------");

        System.out.print("Bir karakter seç: ");
        int selectChar = scan.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Knight());
                break;
            case 3:
                initPlayer(new Archer());
                break;
            default:
                System.out.println("Geçersiz karakter seçtin samuray ile savaşacaksın ..!");
                initPlayer(new Samurai());
                break;
        }

      /*

      System.out.println("Karakter: " + this.getCharName() +
                "\t Hasar: " + this.getDamage() +
                " \t Sağlık: " + this.getHealth() +
                " \t Para: " + this.getMoney());
      */

    }


    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {

        System.out.println("Silah: " + this.getInventory().getWeapon().getName() +
                "\t Hasar: " + this.getDamage() +
                " \t Sağlık: " + this.getHealth() +
                " \t Para: " + this.getMoney());

    }

    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
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
}
