class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = '-';
            }
        }
    }

    public boolean setCell(int row, int col, char mark) {
        if (row < 0 || row > 2 || col < 0 || col > 2 || cells[row][col] != '-') {
            return false;
        }
        cells[row][col] = mark;
        return true;
    }

    public char getCell(int row, int col) {
        return cells[row][col];
    }

    public char[][] getCells() {
        return cells;
    }

    public void display() {
        System.out.println("   0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
