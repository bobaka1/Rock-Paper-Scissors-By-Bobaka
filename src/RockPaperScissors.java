import java.util.Random;
import java.util.Scanner;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Write your name...");

        String playerName = sc.nextLine();

        System.out.printf("Hello, %s!%n", playerName);
        System.out.println("I'll be playing with you today.");
        System.out.println("When you decide you've had enough, just type [end].");
        System.out.println("Choose [r]ock, [p]aper or [s]cissors.");

        String playerChoice = sc.nextLine();

        if(playerChoice.equals("end") || playerChoice.equals("End")){
            System.out.println("Our game was rather short...");
            return;
        }

        int playerWinsCount = 0;
        int computerWinsCount = 0;


        while(!playerChoice.equals("end") && !playerChoice.equals("End")){

            String playerMove = switch (playerChoice) {
                case "r", "R", "rock", "Rock" -> "Rock";
                case "p", "P", "paper", "Paper" -> "Paper";
                case "s", "S", "scissors", "Scissors" -> "Scissors";
                default -> "Invalid";
            };

            while(playerMove.equals("Invalid")){
                System.out.println("That's not a legal move.");
                System.out.println("Try again, choose [r]ock, [p]aper or [s]cissors. ");
                playerChoice = sc.nextLine();
                playerMove = switch (playerChoice) {
                    case "r", "R", "rock", "Rock" -> "Rock";
                    case "p", "P", "paper", "Paper" -> "Paper";
                    case "s", "S", "scissors", "Scissors" -> "Scissors";
                    case "end", "End" -> "e";
                    default -> "Invalid";
                };
            }

            if(playerMove.equals("e")){
                break;
            }

            int computerNum = random.nextInt(3);
            String computerMove = switch (computerNum){
                case 0 -> "Rock";
                case 1 -> "Paper";
                case 2 -> "Scissors";
                default -> "";
            };


            boolean draw = computerMove.equals(playerMove);

            boolean playerWin =
                    playerMove.equals("Rock") && computerMove.equals("Scissors") ||
                            playerMove.equals("Paper") && computerMove.equals("Rock") ||
                            playerMove.equals("Scissors") && computerMove.equals("Paper");

            System.out.printf("I have chosen...%s%n", computerMove);

            if(draw){
                System.out.println("It's a draw!");
            }
            else if(playerWin){
                System.out.println("You win!");
                playerWinsCount++;
            }
            else{
                System.out.println("I win!");
                computerWinsCount++;
            }
            System.out.println("Type [end] or choose your next move...");
            playerChoice = sc.nextLine();
        }

        System.out.printf("I loved playing with you! 'Till next time.%n%n");
        System.out.printf("The final results are:%n%nComputer: %d%n%s: %d", computerWinsCount, playerName, playerWinsCount);

    }
}