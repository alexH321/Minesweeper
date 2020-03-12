import java.util.Scanner;

public class Main {
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);

        System.out.println("How many rows do you want?"); //amount of rows
        int rows =  sc.nextInt();

        System.out.println("How many columns do you want?"); //amount of columns
        int columns = sc.nextInt();

        Board board = new Board(rows, columns);

        int maximum = (rows*columns)/5;
        System.out.println("How many bombs do you want? The maximum is: " + maximum); //maximum 1/5 van het bord?
        int amountOfBombs = sc.nextInt(); //amount of bombs
        board.setAmountOfBombs(amountOfBombs);
        if (amountOfBombs <= maximum){
            board.addBombs(amountOfBombs);
        }
        else{
            System.out.println("There are too many bombs.")
        }

        board.calculateValues(); //calculate values

        board.printBoard(); //print the board
        //TODO: first click

        //TODO: left or right click

    }
}
