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
    public void leftClick(int xPos, int yPos){
        // to do: implement that the first click doesn't explode a bomb
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(xPos == i && yPos == j){
                    if(board[xPos][yPos].isBomb()){
                        System.out.println("Lost");
                        break;
                    }
                }
            }
        }
    }
}
