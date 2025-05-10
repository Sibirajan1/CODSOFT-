import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class  QUIZ_APPLICATION_WITH_TIMER{
    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
    static int score = 0;
    static List<String> summary = new ArrayList<>();

    static class question {
        String question;
        String[] options;
        char answer;

        question(String que, String[] opt, char corr) {
            this.question = que;
            this.options = opt;
            this.answer = corr;
        }
    }

    public static void main(String[] args) {
        List<question> questions = Arrays.asList(
            new question("What is the capital of Indi)?", new String[]{"A) Delhi", "B) Mumbai", "C) Chennai", "D) Kolkata"}, 'A'),
            new question("2 + 2 = ?", new String[]{"A) 3", "B) 4", "C) 5", "D) 6"}, 'B'),
            new question("Which is a programming language?", new String[]{"A) HTML", "B) Java", "C) CSS", "D) SQL"}, 'B'),
            new question("Sun rises in the?", new String[]{"A) West", "B) North", "C) East", "D) South"}, 'C'),
            new question("Which one is an OOP language?", new String[]{"A) C", "B) Python", "C) HTML", "D) CSS"}, 'B')
        );

        System.out.println("\tWELCOME TO QUIZ");
        System.out.println("Note: You will get 10 seconds to answer each question.");

        for (question q : questions) {
            askQuestion(q);
        }

        System.out.println("\n--- Quiz Completed ---");
        System.out.println("Your Score: " + score + "/" + questions.size());
        System.out.println("Summary:");
        for (String ques : summary) {
            System.out.println(ques);
        }
    }

    public static void askQuestion(question q) {
        System.out.println("\n" + q.question);
        for (String opt : q.options) {
            System.out.println(opt);
        }

        long start = System.currentTimeMillis();
        String inp = "";

        System.out.print("Enter answer (A/B/C/D): ");
        while (System.currentTimeMillis() - start < 10000) { 
            try {
                if (sc.ready()) {
                    inp = sc.readLine().trim().toUpperCase();
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error in reading input.");
                summary.add(q.question + " - error occurred");
                return;
            }
        }

        if (inp.isEmpty()) {
            System.out.println("\n its Time's up!");
            summary.add(q.question + " - Incorrect (No answer)");
        } else if (inp.length() == 1 && "ABCD".contains(inp)) {
            char userAnswer = inp.charAt(0);
            if (userAnswer == q.answer) {
                System.out.println(" Correct answer!");
                score++;
                summary.add(q.question + " - Correct answer");
            } else {
                System.out.println(" Incorrect answer!");
                summary.add(q.question + " - Incorrect (Your answer: " + userAnswer + ") answer");
            }
        } else {
            System.out.println(" Invalid input.");
            summary.add(q.question + " - Incorrect (Invalid input) answer");
        }
    }
}
