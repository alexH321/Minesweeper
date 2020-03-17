import java.util.Random;

public class Board {
    private int rows;
    private int columns;
    private Cell[][]board;
    private int amountOfBombs;

    public Board(int r, int c){
        r = rows;
        c = columns;
        Cell[][]board = new Cell[rows][columns];
    }

    public void fillBoard(){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                Cell cell = new Cell(i,j);
                board[i][j] = cell;
            }
        }
    }

    public void addBombs(int amountOfBombs){
        for (int i = 0; i < amountOfBombs; i++){
            Random rand = new Random();
            int posX = rand.nextInt(rows);
            int posY = rand.nextInt(columns);
            if (!board[posX][posY].isBomb()){
                board[posX][posY].setBomb(true);
            }
            else{
                i--;
            }
        }
    }

    public void calculateValues(){
        int counter = 0;
        for(int a = 0; a < rows; a++) {
            for(int b = 0; b < columns; b++){
                for (int i = a-1; i < a+2; i++){
                    for(int j = b-1; j < b+2; j++) {
                        if(i >= 0 && i < rows && j >= 0 && j < columns) {
                            if(board[a][b].isBomb()){
                                counter++;
                            }
                        }
                    }
                }
                board[a][b].setAmountAround(counter);
            }
        }
    }

    public void printBoard(){
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (!board[i][j].isVisible()) {
                    System.out.println("[" + " " + "]");
                }
                else{
                    if (board[i][j].isFlag()){
                        System.out.println("[F]");
                    }
                    if (board[i][j].isBomb() && !board[i][j].isFlag()){
                        System.out.println("[B]");
                    }
                    if (board[i][j].isBomb() && !board[i][j].isFlag()){
                        System.out.println("[" + board[i][j].getAmountAround() + "]");
                    }
                }
            }
        }
    }

    public void revealAround(int a, int b) {
        for (int i = a-1; i < a+2; i++) {
            for (int j = b-1; j < b+2; j++){
                if (board[i][j].getAmountAround() == 0){
                    if (!board[i][j].isVisible() && !board[i][j].isBomb() && !board[i][j].isFlag()){
                        board[i][j].setVisible(true);
                    }
                }
            }
        }

    }

    public void leftClick(int xPos, int yPos){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(xPos == i && yPos == j){
                    if(board[xPos][yPos].isBomb()){
                        System.out.println("Lost");
                        break;
                    }
                    else{
                        revealAround(xPos, yPos);
                    }
                }
            }
        }
    }

    public void checkFirstClick(int xPos, int yPos){
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if (xPos == i && yPos == j){
                    if (board[xPos][yPos].isBomb()){
                        board[xPos][yPos].setBomb(false);
                        if (!board[0][0].isBomb()){
                            board[0][0].setBomb(true);
                        }
                        else{
                            Random rand = new Random();
                            int posX = rand.nextInt(rows);
                            int posY = rand.nextInt(columns);
                            if (!board[posX][posY].isBomb()){
                                board[posX][posY].setBomb(true);
                            }
                        }
                        calculateValues();
                    }
                }
            }
        }
    }

    public void rightClick(int xPos, int yPos){
        if (board[xPos][yPos].isFlag()){
            board[xPos][yPos].setFlag(false);
        }
        else{
            board[xPos][yPos].setFlag(true);
        }
    }

    public void setAmountOfBombs(int amount){
        amountOfBombs = amount;
    }

    public boolean victoryCheck(){
        int counter = 0;
        int xPos = 0;
        int yPos = 0;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++) {
                if (xPos == i && yPos == j){
                    if (board[xPos][yPos].isBomb() && board[xPos][yPos].isFlag()){
                        counter++;
                    }
                    if (board[xPos][yPos].isFlag() && !board[xPos][yPos].isBomb()){
                        counter--;
                    }
                }
            }
        }
        if (counter == amountOfBombs){
            return true;
        }
        else{
            return false;
        }
    }

}

