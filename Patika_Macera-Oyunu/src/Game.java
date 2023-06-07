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
            if (player.getInventory().hasFood() && player.getInventory().hasFireWood() && player.getInventory().hasWater()) {
                System.out.println("İhtiyacın olan her şeyi aldın , güvenli eve git ve son geceni rahat yatapında geçir yarın gidebilirsin.");
            }
            System.out.println();
            player.printInfo();

            System.out.println();
            System.out.println("#######   Bölgeler   #######");
            System.out.println();

            System.out.println("1- Güvenli ev");
            System.out.println("2- Mağaza");

            if (!player.getInventory().hasFood()) {
                System.out.println("3- Mağaraya dikkat et biraz tehlikeli olabilir");
            }
            if (!player.getInventory().hasFireWood()) {
                System.out.println("4- Ormana dikkat et teklikeli");
            }
            if (!player.getInventory().hasWater()) {
                System.out.println("5- Nehire gidecek kadar cesur musun ?");
            }
            System.out.println("6- Madene gidip güçlenmeyi deneyebilirsin ");
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
                case 3:
                    if (!player.getInventory().hasFood()) {
                        location = new Cave(player);
                    } else {
                        System.out.println("MAĞARADAN YEMEĞİ ZATEN ALDIN ŞANSINI ZORLAYIP ÖLMEK Mİ İSTİYORSUN ??\nSAÇMALAMAYA BAŞLADIN !! EVİNE GİDİP DİNLEN...\n");
                        location = new SafeHouse(player);
                    }
                    break;
                case 4:
                    if (!player.getInventory().hasFireWood()) {
                        location = new Forest(player);
                    } else {
                        System.out.println("ORMANDAN ODUNU ZATEN ALDIN ŞANSINI ZORLAYIP ÖLMEK Mİ İSTİYORSUN ??\nSAÇMALAMAYA BAŞLADIN !! EVİNE GİDİP DİNLEN...\n");
                        location = new SafeHouse(player);
                    }
                    break;
                case 5:
                    if (!player.getInventory().hasWater()) {
                        location = new River(player);
                    } else {
                        System.out.println("NEHİRDEN SUYU ZATEN ALDIN ŞANSINI ZORLAYIP ÖLMEK Mİ İSTİYORSUN ??\nSAÇMALAMAYA BAŞLADIN !! EVİNE GİDİP DİNLEN...\n");
                        location = new SafeHouse(player);
                    }
                    break;
                case 6:
                    int monsterCount = Location.random.nextInt(3) + 4;
                    System.out.println(monsterCount);
                    location = new Mine(player, monsterCount);

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
            if (player.didWon()) {
                System.out.println("TEBRİKLER!");
                break;
            } else if (!location.onLocation()) {
                System.out.println("GAME OVER!");
                break;
            }
        }


    }
}
