import java.util.*;


// Reference: https://dev-note-97.tistory.com/265
class Solution {

    public int rotate(int[][] matrix, int[] queries) {
        int first_row = queries[0] - 1;
        int last_row = queries[2] - 1;
        int first_col = queries[1] - 1;
        int last_col = queries[3] - 1;


        int temp = matrix[first_row][first_col];
        int min = temp;
        for (int i = first_row; i < last_row; i++) {
            matrix[i][first_col] = matrix[i + 1][first_col];
            min = Math.min(min, matrix[i][first_col]);
        }

        for (int i = first_col; i < last_col; i++) {
            matrix[last_row][i] = matrix[last_row][i + 1];
            min = Math.min(min, matrix[last_row][i]);
        }

        for (int i = last_row; i > first_row; i--) {
            matrix[i][last_col] = matrix[i - 1][last_col];
            min = Math.min(min, matrix[i][last_col]);
        }

        for (int i = last_col; i > first_col; i--) {
            matrix[first_row][i] = matrix[first_row][i - 1];
            min = Math.min(min, matrix[first_row][i]);
        }
        matrix[first_row][first_col + 1] = temp;

//        printMatrix(matrix);

        return min;
    }

    public void printMatrix(int[][] matrix) {
        System.out.println("-------------------------------------");
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.printf("%3d", col);
            }
            System.out.println();
        }
        System.out.println("-------------------------------------");
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer;

        int[][] matrix = new int[rows][columns];

        for (int y = 0, value = 1; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                matrix[y][x] = value++;
            }
        }

        answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(matrix, queries[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(
                6,
                6,
                new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}
        )));

        System.out.println(Arrays.toString(solution.solution(
                3,
                3,
                new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}}
        )));

        System.out.println(Arrays.toString(solution.solution(
                100,
                97,
                new int[][]{{1,1,100,97}}
        )));

        System.out.println(Arrays.toString(solution.solution(
                6,
                6,
                new int[][]{{1, 1, 6, 6}}
        )));
    }
}