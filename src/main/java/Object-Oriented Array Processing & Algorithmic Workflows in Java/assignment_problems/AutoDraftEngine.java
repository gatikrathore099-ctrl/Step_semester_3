import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Player {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    // Overloaded Rule 1: Established player rule (matches >= 10 qualifies automatically)
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overloaded Rule 2: Newer player rule (matches >= 5 AND not injured)
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        if (isDraftable(matchesPlayed)) {
            return true;
        }
        return matchesPlayed >= 5 && !injured;
    }
}

public class AutoDraftEngine {

    public static String draftAndRank(Player[] players) {
        List<Player> draftableList = new ArrayList<>();

        for (Player p : players) {
            if (Player.isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftableList.add(p);
            }
        }

        Player[] draftableArray = draftableList.toArray(new Player[0]);

        // Sort by batting average descending without using Comparable interface
        Arrays.sort(draftableArray, (p1, p2) -> Double.compare(p2.getBattingAverage(), p1.getBattingAverage()));

        StringBuilder rankedOutput = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            rankedOutput.append(i + 1)
                        .append(". ")
                        .append(draftableArray[i].getName());

            if (i < draftableArray.length - 1) {
                rankedOutput.append(" | ");
            }
        }

        return rankedOutput.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
