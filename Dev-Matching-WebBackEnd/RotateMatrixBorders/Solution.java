import java.util.*;

class Solution {

    public List<Integer> rotate(int[][] matrix, int[] queries) {

        List<Integer> numberOnBorder = new ArrayList<>();

        int temp = matrix[queries[0] - 1][queries[3] - 1];
        for (int x = queries[3] - 1; x >= queries[1]; x--) {
            matrix[queries[0] - 1][x] = matrix[queries[0] - 1][x - 1];
            numberOnBorder.add(matrix[queries[0] - 1][x]);
        }

        int temp2 = matrix[queries[2] - 1][queries[3] - 1];
        for (int y = queries[2] - 1; y > queries[0]; y--) {
            matrix[y][queries[3] - 1] = matrix[y - 1][queries[3] - 1];
            numberOnBorder.add(matrix[y][queries[3] - 1]);
        }
        matrix[queries[0]][queries[3] - 1] = temp;
        numberOnBorder.add(matrix[queries[0]][queries[3] - 1]);

        temp = matrix[queries[2] - 1][queries[0] - 1];
        for (int x = queries[1] - 1; x < queries[3] - 1; x++) {
            matrix[queries[2] - 1][x] = matrix[queries[2] - 1][x + 1];
            numberOnBorder.add(matrix[queries[2] - 1][x]);
        }
        matrix[queries[2] - 1][queries[3] - 1 - 1] = temp2;
        numberOnBorder.add(matrix[queries[2] - 1][queries[3] - 1 - 1]);

        for (int y = queries[0] - 1; y < queries[2] - 1; y++) {
            matrix[y][queries[1] - 1] = matrix[y + 1][queries[1] - 1];
            numberOnBorder.add(matrix[y][queries[1] - 1]);
        }
        matrix[queries[2] - 1 - 1][queries[1] - 1] = temp;
        numberOnBorder.add(matrix[queries[2] - 1 - 1][queries[1] - 1]);

        printMatrix(matrix);

        return numberOnBorder;
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

        int[][] matrix = new int[rows][columns];

        for (int y = 0, value = 1; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                matrix[y][x] = value++;
            }
        }

        LinkedList<Integer> afterRotationMinValue = new LinkedList<>();

        for (int[] query : queries) {
            afterRotationMinValue.add(Collections.min(rotate(matrix, query)));
        }

        return afterRotationMinValue.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

//        System.out.println(Arrays.toString(solution.solution(
//                6,
//                6,
//                new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}
//        )));

//        System.out.println(Arrays.toString(solution.solution(
//                3,
//                3,
//                new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}}
//        )));

        System.out.println(Arrays.toString(solution.solution(
                100,
                97,
                new int[][]{{1,1,100,97}}
        )));

//        System.out.println(Arrays.toString(solution.solution(
//                6,
//                6,
//                new int[][]{{1, 1, 6, 6}}
//        )));
    }
}