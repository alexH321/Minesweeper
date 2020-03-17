import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many rows do you want?"); //amount of rows
        int rows = sc.nextInt();

        System.out.println("How many columns do you want?"); //amount of columns
        int columns = sc.nextInt();

        Board board = new Board(rows, columns);

        int maximum = (rows * columns) / 3;
        System.out.println("How many bombs do you want? The maximum is: " + maximum); //maximum 1/3 van het bord?
        int amountOfBombs = sc.nextInt(); //amount of bombs
        board.setAmountOfBombs(amountOfBombs);
        if (amountOfBombs < maximum) {
            board.addBombs(amountOfBombs);
        } else {
            System.out.println("There are too many bombs.");
            amountOfBombs = sc.nextInt();
        }

        board.calculateValues(); //calculate values
        board.printBoard(); //print the board

        // First click
        System.out.println("Which row do you want to check?");
        int xPos = sc.nextInt() - 1;
        System.out.println("Which column do you want to check?");
        int yPos = sc.nextInt() - 1;
        board.checkFirstClick(xPos, yPos);

        //Other clicks
        while (true) {
            System.out.println("Left or Right click?");
            String input = sc.next();
            System.out.println("Which row do you want to check?");
            xPos = sc.nextInt() - 1;
            System.out.println("Which column do you want to check?");
            yPos = sc.nextInt() - 1;
            if (input.equals("Left")){
                board.leftClick(xPos, yPos);
            }
            if (input.equals("Right")){
                board.rightClick(xPos, yPos);
            }
            if (board.victoryCheck() == true){
                System.out.println("You won!");
                break;
            }
        }
    }
}
