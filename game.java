import java.util.Random;
import java.util.Scanner;
import java.lang.String;
public class game{

    //Function to generate the computer choice
    public static String generateComputerChoice( Random  random){

        int wordNumber;
        //Choosing a random number using the inbuilt function
        wordNumber = random.nextInt( 3 ) + 1;
        String computerChoice = "";

        //Getting computer choice on the random number
        if( wordNumber == 1 ){
            computerChoice = "rock";
        }else if( wordNumber == 2 ){
            computerChoice = "paper";
        }else if( wordNumber == 3 ){
            computerChoice = "scissors";
        }

        System.out.println( "\nThe Computer already made it's choice" );
        return computerChoice;

    }

    //Function to show the list of available options
    public static void showMenu(){

        System.out.println( "Options to choose from :\n1.Rock\n2.Paper\n3.Scissors" );

    }

    //function to get the user choice
    public static String getUserChoice( Scanner scanner ){
        System.out.println( "Options to choose from :\n1.Rock\n2.Paper\n3.Scissors" );
        int userWordChoice = 0;
        System.out.print( "\nPlease make yours : " );
        userWordChoice = scanner.nextInt();


        String userChoice = "";

        //Getting computer choice on the random number
        if( userWordChoice == 1 ){
            userChoice = "rock";
        }else if( userWordChoice == 2 ){
            userChoice = "paper";
        }else if( userWordChoice == 3 ){
            userChoice = "scissors";
        }
        // Check if the user entered a valid choice
        if (!userChoice.equals("rock") && !userChoice.equals("paper") && !userChoice.equals("scissor")) {
            System.out.println("Invalid choice. Please choose from rock, paper, or scissors.");
        }
        return userChoice;

    }

    //Function to get the user
    public static String chooseWinner(String computerChoice, String userChoice ){

        String winner = "No Winner";
        String customMessage = "Both choose same";
        String finalMessage = "";

        String rockCustomMessage = "The rock smashes the scissor";
        String scissorsCustomMessage = "Scissors cuts paper";
        String paperCustomMessage = "Paper wraps rock";

        //Winner Logic for the game start
        System.out.println("Computer choice: " + computerChoice + "\nuser choice: " + userChoice);
        if( computerChoice.equals( "rock" ) && userChoice.equalsIgnoreCase( "scissors" ) ){
            winner = "Computer";
            customMessage = rockCustomMessage;

        }else if( userChoice.equalsIgnoreCase( "rock" ) && computerChoice.equals( "scissors" ) ){
            winner = "User";
            customMessage = rockCustomMessage;
        }

        if( computerChoice.equals( "scissors" ) && userChoice.equalsIgnoreCase( "paper" ) ){
            winner = "Computer";
            customMessage = scissorsCustomMessage;
        }
        else if( userChoice.equalsIgnoreCase( "scissors" ) && computerChoice.equals( "paper" ) ){
            winner = "User";
            customMessage = scissorsCustomMessage;
        }

        if( computerChoice.equals( "paper" ) && userChoice.equalsIgnoreCase( "rock" ) ){
            winner = "Computer";
            customMessage = scissorsCustomMessage;
        }else if( userChoice.equalsIgnoreCase( "paper" ) && computerChoice.equals( "rock" ) ){
            winner = "User";
            customMessage = paperCustomMessage;
        }


        finalMessage = winner + " won ( " + customMessage + " )";
        return finalMessage;

    }
    public static void main( String [] args ){

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String computerChoice;
        String userChoice;
        String winner;

        computerChoice = generateComputerChoice( random );
        userChoice = getUserChoice( scanner );

        winner = chooseWinner(computerChoice, userChoice);

        System.out.println( winner );
    }

}