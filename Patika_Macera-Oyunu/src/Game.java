import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);


    public void start() {
        System.out.println("Macera Oyununa Hoş Geldiniz !");
        System.out.println("Lütfen bir isim girin : ");
        //String playerName = scan.nextLine();
        String playerName = "Zeynel";

        Player player = new Player(playerName);

        System.out.println("\nBu karanlık ve sisli adaya hoşgeldin " + player.getName());
        System.out.println("\nMaceraya başlamak için bir karakter seç");
        player.selectChar();

        Location location = null;
        while (true) {
            System.out.println();
            player.printInfo();

            System.out.println();
            System.out.println("#######   Bölgeler   #######");
            System.out.println();

            System.out.println("1- Güvenli ev");
            System.out.println("2- Mağaza");
            System.out.println("0- Oyunu terket");
            System.out.println();
            System.out.print("Gitmek istediğin bölgeyi seç: ");

            int selectLoc = scan.nextInt();
            System.out.println();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    System.out.println("Burası bir bölge bile değil güvenli eve git ve tekrar düşün");
                    location = new SafeHouse(player);
                    break;
            }
            if (location == null) {
                System.out.println("KORKAK!");
                break;
            }
            if (!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }
        }


    }
}
