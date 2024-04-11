import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int rightAnswers;

    public static void main(String[] args) {
        boolean keepPlaying = true;
        Scanner scanner = new Scanner(System.in);

        String[] mathQuestions = {"Whats 50 + 12?","Whats 2 x 7?","Whats 43 - 4?","Whats 20 / 2?"};
        String[] mathAnswers = {"62","14","39","10"};

        System.out.println("Welcome to the TEST. We will need you to answer the questions provided.\nBut first, what is your name?");
        //gets the user's name and saves it for later
        String username = scanner.nextLine();
        System.out.println("Welcome " + username + " to the TEST. Please answer the questions provided.");

        //while loop so that if the user wants they can redo the quiz
        while (keepPlaying) {
            rightAnswers = 0;
            boolean yesOrNo = true;

            answerAllTheQuestions(mathQuestions, mathAnswers, scanner);
            System.out.println("You got " + rightAnswers + "/" + mathAnswers.length + " questions right " + "!");

            //Asks the user after they finish a section if they would like to quit
            while (yesOrNo) {
                System.out.println("Would you like to keep playing? [Y/N]");
                //stores the users input for later to see if they want to keep playing
                String input = scanner.nextLine().toUpperCase();
                //the user said no, and they will exit the program
                if (Objects.equals(input, "N")) {
                    keepPlaying = false;
                    yesOrNo = false;
                    System.out.println("Goodbye!");
                    //the user said yes, and they will continue playing the quiz
                } else if (Objects.equals(input, "Y")) {
                    System.out.println("Alright!");
                    yesOrNo = false;
                    //the user did not type Y or N specifically, and they will be asked to do so
                } else {
                    System.out.println("That is not a Y/N. Please type Y or N specifically.");
                }
            }

        }

    }

    private static void answerAllTheQuestions(String[] questions, String[] answers, Scanner scanner){
        //loops for the amount of questions there is
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            String input = scanner.nextLine();
            //checks if user input is the same as the answer
            if(Objects.equals(input.toUpperCase(), answers[i])){
                System.out.println("Correct!");
                rightAnswers++;
                //if the user did not type the correct answer, they got the question wrong
            } else{
                System.out.println("Wrong!");
            }
        }
    }
}

