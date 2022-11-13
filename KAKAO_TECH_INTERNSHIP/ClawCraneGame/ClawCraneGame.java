import java.util.LinkedList;
import java.util.List;

public class ClawCraneGame {

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.printf("%-3d", matrix[i][j]);
            System.out.println();
        }
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        List<Integer> basket = new LinkedList<>();

        printMatrix(board);
        for (int move : moves) {
            System.out.println("move: " + move);
            int i = 0;
            while (i < board.length && board[i][move - 1] == 0)
                i++;

            if (i == board.length)
                continue;

            System.out.println("Claw: " + board[i][move - 1]);

            if (basket.size() > 0 && basket.get(basket.size() - 1).equals(board[i][move - 1])) {
                answer += 2;
                basket.remove(basket.size() - 1);
                System.out.println("@@@@@@@@@@ PANG! PANG! @@@@@@@@@@");
            } else {
                basket.add(board[i][move - 1]);
            }
            board[i][move - 1] = 0;

            printMatrix(board);
            System.out.println("Basket: " + basket);
        }

        return answer;
    }

    public static void main(String[] args) {
        ClawCraneGame clawCraneGame = new ClawCraneGame();

        System.out.println(clawCraneGame.solution(
                new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4})
        );

        System.out.println(clawCraneGame.solution(
                new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 1, 0, 0, 0}},
                new int[]{1, 2, 3, 4, 5})
        );
    }
}
