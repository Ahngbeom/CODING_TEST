import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        AtomicLong zeroAmount = new AtomicLong();
        AtomicLong oneAmount = new AtomicLong();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d ", arr[i][j]);
                if (arr[i][j] == 0)
                    zeroAmount.incrementAndGet();
                else
                    oneAmount.incrementAndGet();
            }
            System.out.println();
        }


        System.out.println(zeroAmount + ", " + oneAmount);

        // Zero
        int[] s = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                s[0] = i;
                s[1] = j;

                if (arr[i][j] == 0) {
                    if (arr[i][j] == arr[i][j + 1]) {
                        arr[i][j] = -1;
                        arr[i][j + 1] = -1;
                        s[1]++;
                    } else if (arr[i][j] == arr[i + 1][j]) {
                        arr[i][j] = -1;
                        arr[i + 1][j] = -1;
                        s[0]++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(
                new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}}
        )));
    }
}