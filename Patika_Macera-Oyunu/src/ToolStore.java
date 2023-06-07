public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("---------- Mağazaya Hoşgeldin ----------");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış Yap");

            int selectCase = scan.nextInt();

            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Duyamadım!?");
                selectCase = scan.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Yine gel ");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapons() {

        System.out.println("----- Silahlar -----");

        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + " - " + weapon.getName() + " < " + weapon.getPrice() + " coin , +" + weapon.getDamage() + " hasar >");
        }
        System.out.println("0 - Bir üst menü\n");

    }

    public void buyWeapon() {
        System.out.println("Hangisiyle savaşmak istersin?");

        int selectedWeaponID = scan.nextInt();
        while (selectedWeaponID < 0 || selectedWeaponID > Weapon.weapons().length) {
            System.out.println("Duyamadım!?");
            selectedWeaponID = scan.nextInt();
        }

        if (selectedWeaponID != 0) {

            Weapon selectedWeapon = Weapon.getWeaponObjById(selectedWeaponID);

            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Senin buna para yetmez hahahhahaa");
                } else {
                    System.out.println("Al bakalım " + selectedWeapon.getName() + " burda");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);

                    System.out.println("--- Kalan paran " + this.getPlayer().getMoney() + " coin");
                    System.out.print("--- Artık " + this.getPlayer().getInventory().getWeapon().getName() + " yerine ");
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.print(this.getPlayer().getInventory().getWeapon().getName() + " Kullanacaksın");

                }
            }
        }
    }

    public void printArmors() {

        System.out.println("----- Zırhlar -----");

        for (Armor armor : Armor.armors()) {
            System.out.println(armor.getId() + " - " + armor.getName() + " < " + armor.getPrice() + " coin , +" + armor.getBlock() + " block >");
        }
        System.out.println("0 - Bir üst menü\n");
    }


    public void buyArmor() {
        System.out.println("hani zırhı istersin?");

        int selectedArmorID = scan.nextInt();
        while (selectedArmorID < 0 || selectedArmorID > Armor.armors().length) {
            System.out.println("Duyamadım!?");
            selectedArmorID = scan.nextInt();
        }

        if (selectedArmorID != 0) {

            Armor selectedArmor = Armor.getArmorObjById(selectedArmorID);

            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Senin buna para yetmez hahahhahaa");
                } else {
                    System.out.println("Al bakalım " + selectedArmor.getName() + " zırhın burda");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);

                    System.out.println("--- Kalan paran " + this.getPlayer().getMoney() + " coin");
                    System.out.print("--- Artık " + this.getPlayer().getInventory().getArmor().getName() + " yerine ");
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.print(this.getPlayer().getInventory().getArmor().getName() + " zırh kullanacaksın");

                }
            }
        }
    }

}
