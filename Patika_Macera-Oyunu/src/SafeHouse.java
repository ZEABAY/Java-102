public class SafeHouse extends NormalLoc {


    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }


    @Override
    public boolean onLocation() {
        System.out.println("---------- Güvenli evdesin ----------");
        System.out.println("İyileştin yaraların artık o kadar da kötü hissettirmiyor\n\n");
        this.getPlayer().setHealth(this.getPlayer().getMaxHealth());
        if (getPlayer().didWon()) {
            System.out.println("Artık rahatça uyuyabilirsin bu adadaki işin bitti yarın ilk gemi ile adadan ayrılıyorsun\n\n");
            return false;
        }
        return true;
    }


}
