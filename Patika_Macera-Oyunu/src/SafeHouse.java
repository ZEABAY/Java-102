public class SafeHouse extends NormalLoc {


    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }


    @Override
    public boolean onLocation() {
        System.out.println("---------- Güvenli evdesin ----------");
        System.out.println("İyileştin yaraların artık o kadar da kötü hissettirmiyor");


        return true;
    }


}
