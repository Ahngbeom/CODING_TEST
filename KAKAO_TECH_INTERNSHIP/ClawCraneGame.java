import java.util.Stack;

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

        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    if (basket.isEmpty())
                        basket.push(board[i][move - 1]);
                    else {
                        if (board[i][move - 1] == basket.peek()) {
                            answer += 2;
                            basket.pop();
                        } else {
                            basket.push(board[i][move - 1]);
                        }
                    }
                    board[i][move - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ClawCraneGame clawCraneGame = new ClawCraneGame();

        System.out.println(clawCraneGame.solution(
                new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4})
        );

//        System.out.println(clawCraneGame.solution(
//                new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 1, 0, 0, 0}},
//                new int[]{1, 2, 3, 4, 5})
//        );
    }
}
