public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("---------- Mağazaya Hoşgeldin ----------");
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
                break;
            case 3:
                System.out.println("Yine gel ");
                return true;
        }

        return true;
    }

    public void printWeapons() {

        System.out.println("----- Silahlar -----");

        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getId() + " - " + weapon.getName() + " < " + weapon.getPrice() + " coin , +" + weapon.getDamage() + " hasar >");
        }

    }

    public void buyWeapon() {
        System.out.println("Hangisiyle savaşmak istersin?");

        int selectedWeaponID = scan.nextInt();
        while (selectedWeaponID < 1 || selectedWeaponID > Weapon.weapons().length) {
            System.out.println("Duyamadım!?");
            selectedWeaponID = scan.nextInt();
        }
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

    public void printArmors() {

        System.out.println("----- Zırhlar -----");

    }

}
