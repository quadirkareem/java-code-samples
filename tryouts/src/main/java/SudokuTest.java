import java.util.Arrays;

import org.junit.Test;

public class SudokuTest {

    // n * (n+1)/2
    private final int SUM_9 = 45;
    private final int MAX_COLS = 9;
    private final int MAX_ROWS = 9;
    private final int SUB_GRID_ROWS = 3;
    private final int SUB_GRID_COLS = 3;
    private final int SUB_GRID_SIZE = 9;
    private final int SUM_COUNT = 27;

    @Test
    public void testColumn() {
        int[][] grid = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 } };
        System.out.println(Arrays.toString(getColumn(grid, 0)));
        System.out.println(Arrays.toString(getColumn(grid, 1)));
        System.out.println(Arrays.toString(getColumn(grid, 2)));
        System.out.println(Arrays.toString(getColumn(grid, 3)));
        System.out.println(Arrays.toString(getColumn(grid, 4)));
        System.out.println(Arrays.toString(getColumn(grid, 5)));
        System.out.println(Arrays.toString(getColumn(grid, 6)));
        System.out.println(Arrays.toString(getColumn(grid, 7)));
        System.out.println(Arrays.toString(getColumn(grid, 8)));
    }

    @Test
    public void testRow() {
        int[][] grid = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 } };
        System.out.println(Arrays.toString(getRow(grid, 0)));
        System.out.println(Arrays.toString(getRow(grid, 1)));
        System.out.println(Arrays.toString(getRow(grid, 2)));
        System.out.println(Arrays.toString(getRow(grid, 3)));
        System.out.println(Arrays.toString(getRow(grid, 4)));
        System.out.println(Arrays.toString(getRow(grid, 5)));
        System.out.println(Arrays.toString(getRow(grid, 6)));
        System.out.println(Arrays.toString(getRow(grid, 7)));
        System.out.println(Arrays.toString(getRow(grid, 8)));
    }

    @Test
    public void testSubGrid() {
        int[][] grid = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
            { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 } };

        System.out.println(Arrays.toString(getSubGrid(grid, 0, 0)));
        System.out.println(Arrays.toString(getSubGrid(grid, 0, 3)));
        System.out.println(Arrays.toString(getSubGrid(grid, 0, 6)));
        System.out.println(Arrays.toString(getSubGrid(grid, 3, 0)));
        System.out.println(Arrays.toString(getSubGrid(grid, 3, 3)));
        System.out.println(Arrays.toString(getSubGrid(grid, 3, 6)));
        System.out.println(Arrays.toString(getSubGrid(grid, 6, 0)));
        System.out.println(Arrays.toString(getSubGrid(grid, 6, 3)));
        System.out.println(Arrays.toString(getSubGrid(grid, 6, 6)));

    }

    @Test
    public void testAllSubGrids() {
        int[][] grid = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 }, { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
            { 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 5, 6, 7, 8, 9, 1, 2, 3, 4 }, { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
            { 3, 4, 5, 6, 7, 8, 9, 1, 2 }, { 6, 7, 8, 9, 1, 2, 3, 4, 5 }, { 9, 1, 2, 3, 4, 5, 6, 7, 8 } };
        System.out.println(areSubGridsSudoku(grid));
    }

    @Test
    public void testAllColumns() {
        int[][] grid = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 }, { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
            { 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 5, 6, 7, 8, 9, 1, 2, 3, 4 }, { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
            { 3, 4, 5, 6, 7, 8, 9, 1, 2 }, { 6, 7, 8, 9, 1, 2, 3, 4, 5 }, { 9, 1, 2, 3, 4, 5, 6, 7, 8 } };
        System.out.println(areColumnsSudoku(grid));
    }

    @Test
    public void testAllRows() {
        int[][] grid = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 }, { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
            { 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 5, 6, 7, 8, 9, 1, 2, 3, 4 }, { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
            { 3, 4, 5, 6, 7, 8, 9, 1, 2 }, { 6, 7, 8, 9, 1, 2, 3, 4, 5 }, { 9, 1, 2, 3, 4, 5, 6, 7, 8 } };
        System.out.println(areRowsSudoku(grid));
    }

    @Test
    public void testGrid() {
        int[][] grid = { { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 }, { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
            { 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 5, 6, 7, 8, 9, 1, 2, 3, 4 }, { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
            { 3, 4, 5, 6, 7, 8, 9, 1, 2 }, { 6, 7, 8, 9, 1, 2, 3, 4, 5 }, { 9, 1, 2, 3, 4, 5, 6, 7, 8 } };
        System.out.println(isSudokuGrid(grid));
    }

    public boolean isSudokuGrid(int[][] grid) {
        int[] sums = new int[SUM_COUNT];
        int k = 18;
        for (int i = 0; i < MAX_ROWS; i++) {
            if (i > 2 && 18 % i == 0) {
                k += 3;
            }
            for (int j = 0; j < MAX_COLS; j++) {
                if (isInValidElement(grid[i][j])) {
                    return false;
                }
                System.out.println("i=" + i + "; j=" + j + "; k=" + k + "; sumIndex=" + (k + j / 3));
                sums[i] += grid[i][j];
                sums[j + 9] += grid[i][j];
                sums[k + j / 3] += grid[i][j];
            }
        }

        for (int i = 0; i < SUM_COUNT; i++) {
            System.out.println("i=" + i + "; sum=" + sums[i]);
            if (sums[i] != SUM_9) {
                return false;
            }
        }

        return true;
    }

    private boolean isInValidElement(int i) {
        return (i < 1 && i > 9);
    }

    public boolean isSudokuGridV1(int[][] grid) {
        return areColumnsSudoku(grid) && areRowsSudoku(grid) && areSubGridsSudoku(grid);
    }

    private boolean areSubGridsSudoku(int[][] grid) {
        for (int i = 0; i < MAX_ROWS; i += SUB_GRID_ROWS) {
            for (int j = 0; j < MAX_COLS; j += SUB_GRID_COLS) {
                if (!isListSudoku(getSubGrid(grid, i, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean areRowsSudoku(int[][] grid) {
        for (int i = 0; i < MAX_ROWS; i++) {
            if (!isListSudoku(getRow(grid, i))) {
                return false;
            }
        }
        return true;
    }

    private boolean areColumnsSudoku(int[][] grid) {
        for (int i = 0; i < MAX_COLS; i++) {
            if (!isListSudoku(getColumn(grid, i))) {
                return false;
            }
        }
        return true;
    }

    private int[] getSubGrid(int[][] grid, int rowIndex, int colIndex) {
        int[] list = new int[SUB_GRID_SIZE];
        int k = 0;
        for (int i = rowIndex; i < (rowIndex + SUB_GRID_ROWS); i++) {
            for (int j = colIndex; j < (colIndex + SUB_GRID_COLS); j++) {
                list[k] = grid[i][j];
                k++;
            }
        }
        return list;
    }

    private int[] getColumn(int[][] grid, int index) {
        int[] list = new int[MAX_ROWS];
        for (int i = 0; i < MAX_ROWS; i++) {
            list[i] = grid[i][index];
        }
        return list;
    }

    private int[] getRow(int[][] grid, int index) {
        int[] list = new int[MAX_COLS];
        for (int i = 0; i < MAX_COLS; i++) {
            list[i] = grid[index][i];
        }
        return list;
    }

    private boolean isListSudoku(int[] list) {
        if (list.length != 9) {
            return false;
        }
        int sum = 0;
        for (int i : list) {
            if (i < 1 || i > 9) {
                return false;
            }
            sum += i;
        }
        if (sum == SUM_9) {
            return true;
        }
        return false;
    }

}
