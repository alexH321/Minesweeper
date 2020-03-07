public class Cell {
    private boolean isBomb;
    private int row;
    private int column;
    private int totAmountBombs;
    private boolean flag;
    private boolean visible;
    private int amountAround;

    public Cell(int r, int c){
        r = row;
        c = column;
        visible = false;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getTotAmountBombs() {
        return totAmountBombs;
    }

    public void setTotAmountBombs(int totAmountBombs) {
        this.totAmountBombs = totAmountBombs;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getAmountAround() {
        return amountAround;
    }

    public void setAmountAround(int amountAround) {
        this.amountAround = amountAround;
    }

}
