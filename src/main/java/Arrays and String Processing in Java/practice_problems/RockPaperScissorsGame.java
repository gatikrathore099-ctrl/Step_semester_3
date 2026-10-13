import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] moves = {"Rock", "Paper", "Scissors"};
        
        int n = 5; // Suggested 5 rounds
        String[][] history = new String[n][3]; // Round | Player Move | Computer Move | Result
        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Round " + (i + 1) + " — Enter your move (Rock, Paper, Scissors): ");
            String playerMove = scanner.next();
            String computerMove = moves[random.nextInt(moves.length)];

            String result = playRound(playerMove, computerMove);
            
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            history[i][0] = playerMove;
            history[i][1] = computerMove;
            history[i][2] = result;
            
            System.out.println("Computer chose: " + computerMove + " | Result: " + result);
        }
        scanner.close();

        System.out.println("\nFinal Summary (after " + n + " rounds)");
        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d | %s | %s | %s\n", (i + 1), history[i][0], history[i][1], history[i][2]);
        }

        double winPercentage = ((double) wins / n) * 100.0;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercentage);
    }
}