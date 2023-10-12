import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Game game = Game.getInstance();


        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter your choice (rock, paper, or scissors), or 'exit' to quit.");

        while (true) {

            System.out.print("Your choice: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("exit")) {
                break;
            }


            game.setComputerStrategy();

            String computerChoice = game.getComputerStrategy().makeChoice();
            if (!computerChoice.equals(userInput)) {
                if ((computerChoice.equals("paper") && userInput.equals("rock")) ||
                        (computerChoice.equals("scissors") && userInput.equals("paper")) ||
                        (computerChoice.equals("rock") && userInput.equals("scissors"))) {
                    game.setComputerScore(1);
                } else {
                    game.setUserScore(1);
                }
            }


            game.playRound();


            int userScore = game.getUserScore();
            int computerScore = game.getComputerScore();
            System.out.println("User: " + userScore + " | Computer: " + computerScore);
        }


        System.out.println("Final Scores:");
        int userScore = game.getUserScore();
        int computerScore = game.getComputerScore();
        System.out.println("User: " + userScore + " | Computer: " + computerScore);


        scanner.close();
    }
}