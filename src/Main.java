import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int rightAnswers;
    public static void main(String[] args) {
        boolean keepPlaying = true;
        Scanner scanner = new Scanner(System.in);

        //math question and answers
        ArrayList<String> mathQuestions = new ArrayList<>();
        mathQuestions.add("Whats 50 + 12?");
        mathQuestions.add("Whats 2 x 7?");
        mathQuestions.add("Whats 43 - 4?");
        mathQuestions.add("Whats 20 / 2?");

        ArrayList<String> mathAnswers = new ArrayList<>();
        mathAnswers.add("62");
        mathAnswers.add("14");
        mathAnswers.add("39");
        mathAnswers.add("10");

        //geography question and answers
        ArrayList<String> geoQuestions = new ArrayList<>();
        geoQuestions.add("What is the capital of France?");
        geoQuestions.add("What city has the largest population in New Zealand?");
        geoQuestions.add("What does UK stand for?");
        geoQuestions.add("What country has the biggest population?");

        ArrayList<String> geoAnswers = new ArrayList<>();
        geoAnswers.add("PARIS");
        geoAnswers.add("AUCKLAND");
        geoAnswers.add("UNITED KINGDOM");
        geoAnswers.add("CHINA");

        //english questions and answers
        ArrayList<String> engQuestions = new ArrayList<>();
        engQuestions.add("Who wrote Hamlet?");
        engQuestions.add("What word is used to identify people, places, or things?");
        engQuestions.add("How many letters are in the alphabet?");
        engQuestions.add("What figure of speech involves comparing things using the words 'like' or 'as'?");

        ArrayList<String> engAnswers = new ArrayList<>();
        engAnswers.add("SHAKESPEARE");
        engAnswers.add("NOUN");
        engAnswers.add("26");
        engAnswers.add("SIMILE");

        System.out.println("Welcome to the TEST. We will need you to answer the questions provided.\nBut first, what is your name?");
        //gets the user's name and saves it for later
        String username = scanner.nextLine();
        System.out.println("Welcome " + username + " to the TEST. Please answer the questions provided.");


        //while loop so that if the user wants they can redo the quiz
        while (keepPlaying) {
            rightAnswers = 0;
            boolean yesOrNo = true;
            boolean checkSubjectQuestions = true;

            System.out.println("What set of question would you like to do?\nMath[1]\nEnglish[2]\nGeography[3]?");

            //saves the input of the user in a string, this is done as if it was saved as an int it caused issues
            String whichQuestions = scanner.nextLine();
            //checks what section of questions the user would like to do
            while (checkSubjectQuestions) {
                switch (whichQuestions) {
                    case "1" -> {
                        //math questions
                        int answers = mathAnswers.size();
                        answerAllTheQuestions(mathQuestions, mathAnswers, scanner);
                        System.out.println("You got " + rightAnswers + "/" + answers + " questions right " + username + "!");
                        checkSubjectQuestions = false;
                    }
                    case "2" -> {
                        //english questions
                        int answers = engAnswers.size();
                        answerAllTheQuestions(engQuestions, engAnswers, scanner);
                        System.out.println("You got " + rightAnswers + "/" + answers + " questions right " + username + "!");
                        checkSubjectQuestions = false;
                    }
                    case "3" -> {
                        //geography questions
                        int answers = geoAnswers.size();
                        answerAllTheQuestions(geoQuestions, geoAnswers, scanner);
                        System.out.println("You got " + rightAnswers + "/" + answers + " questions right" + username + "!");
                        checkSubjectQuestions = false;
                    }
                    case null, default -> {
                        //this occurs if the user specifically did not enter 1,2, or 3
                        System.out.println("That is not a valid answer. Please type 1, 2, or 3.");
                        System.out.println("What set of question would you like to do?\nMath[1]\nEnglish[2]\nGeography[3]?");
                        whichQuestions = scanner.nextLine();
                    }
                }
            }

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

    private static void answerAllTheQuestions(ArrayList<String> questions, ArrayList<String> answers, Scanner scanner){
        //loops for the amount of questions there is
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i));
            String input = scanner.nextLine();
            //checks if user input is the same as the answer
            if(Objects.equals(input.toUpperCase(), answers.get(i))){
                System.out.println("Correct!");
                rightAnswers++;
                //if the user did not type the correct answer, they got the question wrong
            } else{
                System.out.println("Wrong!");
            }
        }
    }
}

