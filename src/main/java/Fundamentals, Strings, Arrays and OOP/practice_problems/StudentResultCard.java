class StudentCard {
    String name;
    int[] marks;

    public StudentCard(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public void generateCard() {
        double sum = 0;
        for (int m : marks) {
            sum += m;
        }
        double avg = sum / marks.length;

        char grade;
        if (avg >= 75) {
            grade = 'B';
        } else if (avg >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.printf("%s: Average %.1f, Grade %c\n", name.toUpperCase(), avg, grade);
    }
}

public class StudentResultCard {
    public static void main(String[] args) {
        StudentCard s1 = new StudentCard("Asha", new int[]{80, 90, 70});
        StudentCard s2 = new StudentCard("Ravi", new int[]{60, 55, 50});

        s1.generateCard();
        s2.generateCard();
    }
}