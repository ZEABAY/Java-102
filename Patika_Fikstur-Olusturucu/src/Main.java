import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Team> teamList = new ArrayList<>();

        teamList.add(new Team("Fenerbahçe", 1));
        teamList.add(new Team("Galatasaray", 2));
        teamList.add(new Team("Beşiktaş", 3));
        teamList.add(new Team("Bursa", 4));

        Fixture.generateFixture(teamList);
    }
}