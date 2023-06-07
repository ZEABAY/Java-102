import javax.sound.midi.Soundbank;
import java.util.Random;

public abstract class BattleLoc extends Location {

    private Monster monster;
    private String award;
    private int maxMonster;


    public BattleLoc(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }


    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonsterNumber();
        System.out.println("Şu an buradasın : " + this.getName());
        System.out.println("Burada " + monsterNumber + " tane " + this.getMonster().getType() + " yaşıyor");

        System.out.print("(S)avaş veya (K)aç : ");
        String selectCase = scan.nextLine().toUpperCase();
        if (selectCase.equals("S")) {
            if (combat(monsterNumber)) {
                System.out.println(this.getName() + " Temizlendi");
                this.getPlayer().getInventory().addItem(this.getAward());
                return true;
            } else {
                return false;
            }
        } else if (selectCase.equals("K")) {
            System.out.println("KORKAK!");
        } else {
            System.out.println("Okuma yazma öğrendiğine emin misin ? eve git ve biraz alfabe çalış");
        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Düşündüğümden daha zayıf çıktın yazık ...");
            return false;
        }
        return true;
    }

    public boolean combat(int monsterNumber) {
        for (int i = 1; i <= monsterNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getMaxHealth());
            if (this.getMonster().getType().equals("Yılan")) {
                this.getMonster().setDamage(random.nextInt(3) + 4);
            }
            playerStats();
            monsterStats(i);
            boolean monsterFirstHit = Location.random.nextBoolean();
            if (this.getPlayer().getHealth() > 0 && monsterFirstHit) {
                System.out.println("\n" + this.getMonster().getType() + " Üstüne çullanıp ilk vuruşu yaptı");
                int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                if (monsterDamage < 0) {
                    monsterDamage = 0;
                }
                System.out.println("\n-----" + this.getMonster().getType() + " Vurdu!!-----");
                this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                afterHit();
            }
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.print("\n(V)ur veya (K)aç : ");
                String selectCase = scan.nextLine().toUpperCase();
                if (selectCase.equals("V")) {
                    System.out.println("\n-----Vurdun!!-----");
                    getMonster().setHealth(this.getMonster().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println(this.getMonster().getType() + " vurdu");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        System.out.println("\n-----" + this.getMonster().getType() + " Vurdu!!-----");
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();
                    }
                } else if (selectCase.equals("K")) {
                    System.out.println("Bir korkak gibi arkana bakmadan savaş alanından kaçtın !");
                    return true;
                } else {
                    return false;
                }
            }

            if (this.getMonster().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("\n####################");
                System.out.println(i + ". " + this.getMonster().getType() + " öldü!");
                if (this.getMonster().getType().equals("Yılan")) {
                    getReward();
                } else {
                    System.out.println("Ödülün : " + this.getMonster().getAward());
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                }
                System.out.println("Toplam paran : " + this.getPlayer().getMoney());
                System.out.println("####################");
            } else {
                return false;
            }

        }
        return true;
    }

    public void getReward() {
        int rand = random.nextInt(100) + 1;
        if (rand > 45) {
            if (rand > 75) {
                //Para
                rand = random.nextInt(100) + 1;
                if (rand > 50) {
                    System.out.println("1 Para buldun");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
                } else if (rand > 30) {
                    System.out.println("5 Para buldun");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
                } else {
                    System.out.println("10 Para buldun");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
                }
            } else if (rand > 60) {
                //Zırh
                rand = random.nextInt(100) + 1;
                if (rand > 50) {
                    System.out.println("Hafif zırh buldun");
                    if (this.getPlayer().getInventory().getArmor().getName().equals("Paçavra")) {
                        this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(1));
                        System.out.println("Hemen Giydin ...");
                    } else {
                        System.out.println("Ama buna ihtiyacın yok...");
                    }

                } else if (rand > 30) {
                    System.out.println("Orta zırh buldun");
                    if (this.getPlayer().getInventory().getArmor().getName().equals("Hafif") || this.getPlayer().getInventory().getArmor().getName().equals("Paçavra")) {
                        this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(2));
                        System.out.println("Hemen Giydin ...");
                    } else {
                        System.out.println("Ama buna ihtiyacın yok...");
                    }
                } else {
                    System.out.println("Ağır zırh buldun");
                    if (!(this.getPlayer().getInventory().getArmor().getName().equals("Ağır"))) {
                        this.getPlayer().getInventory().setArmor(Armor.getArmorObjById(3));
                        System.out.println("Hemen Giydin...");
                    } else {
                        System.out.println("Ama buna ihtiyacın yok...");
                    }
                }
            } else {
                //silah
                rand = random.nextInt(100) + 1;
                if (rand > 50) {
                    System.out.println("Tabanca buldun");
                    if (this.getPlayer().getInventory().getWeapon().getName().equals("Yumruk")) {
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(1));
                        System.out.println("Hemen Kuşandın...");
                    } else {
                        System.out.println("Ama buna ihtiyacın yok...");
                    }

                } else if (rand > 30) {
                    System.out.println("Kılıç buldun");
                    if (this.getPlayer().getInventory().getWeapon().getName().equals("Yumruk") || this.getPlayer().getInventory().getWeapon().getName().equals("Tabanca")) {
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(2));
                        System.out.println("Hemen Kuşandın...");
                    } else {
                        System.out.println("Ama buna ihtiyacın yok...");
                    }
                } else {
                    System.out.println("Tüfek buldun");
                    if (!(this.getPlayer().getInventory().getWeapon().getName().equals("Tüfek"))) {
                        this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjById(3));
                        System.out.println("Hemen Kuşandın...");
                    } else {
                        System.out.println("Ama buna ihtiyacın yok...");
                    }
                }
            }
        } else {
            System.out.println("Hiçbir şey bulamadın ..");
        }
    }

    public void afterHit() {
        System.out.println("\nCanın : " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getType() + " canı : " + this.getMonster().getHealth());
    }

    public void playerStats() {
        System.out.println("\nOyuncu değerleri");
        System.out.println("--------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Armor : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());
    }


    public void monsterStats(int i) {
        System.out.println("\n" + i + ". " + this.getMonster().getType() + " değerleri");
        System.out.println("--------------------");
        System.out.println("Sağlık : " + this.getMonster().getHealth());
        System.out.println("Hasar : " + this.getMonster().getDamage());
        System.out.println("Ödül : " + this.getMonster().getAward());
    }

    public int randomMonsterNumber() {
        Random rand = new Random();
        return rand.nextInt(this.getMaxMonster()) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
