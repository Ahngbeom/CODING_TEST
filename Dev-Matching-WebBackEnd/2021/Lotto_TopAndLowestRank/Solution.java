import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        int rank = 7;
        int unknownNumAmount = 0;

        if (Arrays.stream(lottos).allMatch(value -> value == 0))
            return new int[]{1, 6};

        for (int lottoNum : lottos) {
            if (lottoNum == 0)
                unknownNumAmount++;
            else if (Arrays.stream(win_nums).anyMatch(value -> lottoNum == value))
                rank--;
        }
        if (rank == 7)
            rank--;
        return new int[]{rank - unknownNumAmount, rank};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(
                new int[]{44, 1, 0, 0, 31, 25},
                new int[]{31, 10, 45, 1, 6, 19}
        )));
    }

}