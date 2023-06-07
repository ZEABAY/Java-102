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


    }
}
