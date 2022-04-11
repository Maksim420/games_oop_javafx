package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        int[] diagonal = extractDiagonal(board);
        for (int i = 0; i < diagonal.length; i++) {
            if (diagonal[i] == 1 && (monoVertical(board, i) || monoHorizontal(board, i))) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    public static boolean monoHorizontal(int[][] board, int row) {
        boolean rsl = true;
        for (int column = 0; column < board[row].length; column++) {
            if (board[row][column] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static boolean monoVertical(int[][] board, int column) {
        boolean rsl = true;
        for (int row = 0; row < board.length; row++) {
            if (board[row][column] != 1) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

    public static int[] extractDiagonal(int[][] board) {
        int[] rsl = new int[board.length];
        for (int row = 0; row  < board.length; row++) {
            rsl[row] = board[row][row];
        }
        return rsl;
    }
}
