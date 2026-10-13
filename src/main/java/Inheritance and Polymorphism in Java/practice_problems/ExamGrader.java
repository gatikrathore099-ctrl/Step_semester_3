import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double evaluate();
}

class MCQQuestion extends Question {
    public MCQQuestion(String text, String correct, String student, double points) {
        super(text, correct, student, points);
    }

    @Override
    public double evaluate() {
        if (studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
            return points;
        }
        return 0.0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String text, String correct, String student, double points) {
        super(text, correct, student, points);
    }

    @Override
    public double evaluate() {
        if (studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
            return points;
        }
        return 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String text, String correct, String student, double points) {
        super(text, correct, student, points);
    }

    @Override
    public double evaluate() {
        String[] correctKeywords = correctAnswer.split(",");
        Set<String> studentWords = new HashSet<>();
        for (String word : studentAnswer.split("\\W+")) {
            if (!word.isEmpty()) {
                studentWords.add(word.toLowerCase());
            }
        }

        int matchCount = 0;
        for (String kw : correctKeywords) {
            String trimmed = kw.trim().toLowerCase();
            if (studentAnswer.toLowerCase().contains(trimmed)) {
                matchCount++;
            }
        }

        if (matchCount >= 2) {
            return points * 0.75;
        } else if (matchCount == 1) {
            return points * 0.50;
        }
        return 0.0;
    }
}

public class ExamGrader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine();

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);
            
            // Parse quoted strings and points
            int firstQuote = line.indexOf('"', firstSpace);
            int secondQuote = line.indexOf('"', firstQuote + 1);
            String qText = line.substring(firstQuote + 1, secondQuote);

            int thirdQuote = line.indexOf('"', secondQuote + 1);
            int fourthQuote = line.indexOf('"', thirdQuote + 1);
            String correctAns = line.substring(thirdQuote + 1, fourthQuote);

            int fifthQuote = line.indexOf('"', fourthQuote + 1);
            int sixthQuote = line.indexOf('"', fifthQuote + 1);
            String studentAns = line.substring(fifthQuote + 1, sixthQuote);

            String remainder = line.substring(sixthQuote + 1).trim();
            double pts = Double.parseDouble(remainder);

            switch (type) {
                case "MCQ":
                    questions.add(new MCQQuestion(qText, correctAns, studentAns, pts));
                    break;
                case "TF":
                    questions.add(new TFQuestion(qText, correctAns, studentAns, pts));
                    break;
                case "ESSAY":
                    questions.add(new EssayQuestion(qText, correctAns, studentAns, pts));
                    break;
            }
        }
        scanner.close();

        double totalScore = 0;
        for (Question q : questions) {
            double score = q.evaluate();
            totalScore += score;
            String typeStr = "";
            if (q instanceof MCQQuestion) typeStr = "MCQ";
            else if (q instanceof TFQuestion) typeStr = "TF";
            else if (q instanceof EssayQuestion) typeStr = "ESSAY";

            System.out.printf("%s: %.2f\n", typeStr, score);
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
    }
}