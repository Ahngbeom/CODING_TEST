import java.util.Arrays;

class Solution {
    public int[] solution(int n, int[] info) {
        int[] answer = {};

        int apeachScore = 0;

        for (int count = 0, score = 10; count < n; score--) {
            int hitCount = info[info.length - score - 1];

            if (hitCount > 0) {
                apeachScore += hitCount * score;
                count += hitCount;
            }
        }

        System.out.println("apeachScore: " + apeachScore);



        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(
                5,
                new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}
        )));
    }
}