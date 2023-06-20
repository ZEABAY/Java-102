import java.util.Collections;
import java.util.List;

public abstract class Fixture {
    public static void generateFixture(List<Team> teams) {

        if (teams.size() % 2 != 0) teams.add(new Team("BAY", -1));

        System.out.println("\n#########################\n");

        for (Team team : teams) {
            System.out.println(team.getName());
        }

        System.out.println("\n#########################\n");


        int teamCount = teams.size();
        int weekCount = (teams.size() - 1) * 2;
        int weeklyMatchCount = teamCount / 2;


        for (int i = 0; i < weekCount; i++) {
            System.out.println("\n" + (i + 1) + ". Hafta Macları\n");

            for (int j = 0; j < weeklyMatchCount; j++) {


                System.out.println(teams.get(j).getName() + " - " + teams.get(teamCount - 1 - j).getName());

            }
            Collections.rotate(teams, 1);

            // #################### 1 ile 2 ve 3 ie 4 asla karşılaşmıyor düzeltilecek ####################

        }


    }
}