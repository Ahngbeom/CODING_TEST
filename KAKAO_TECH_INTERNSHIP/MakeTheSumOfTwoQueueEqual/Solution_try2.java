import java.util.Arrays;

public class Solution_try2 extends Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        Long q1TotalSum = (long) Arrays.stream(queue1).sum();
        Long q2TotalSum = (long) Arrays.stream(queue2).sum();
        Long totalSumTarget = (q1TotalSum + q2TotalSum) / 2;

        QueueData q1 = new QueueData(queue1, q1TotalSum);
        QueueData q2 = new QueueData(queue2, q2TotalSum);

//        printQueues(q1, q2);

        if (q1.getTotalSum() == q2.getTotalSum())
            return 0;
        if (q1.getQueue().stream().anyMatch(elements -> elements > totalSumTarget)
                || q2.getQueue().stream().anyMatch(elements -> elements > totalSumTarget))
            return -1;

        while (!q1.getTotalSum().equals(totalSumTarget) && !q2.getTotalSum().equals(totalSumTarget)) {
            if (q1.getTotalSum() < totalSumTarget)
                q2.popAndInsert(q1);
            else if (q2.getTotalSum() < totalSumTarget)
                q1.popAndInsert(q2);

//            printQueues(q1, q2);
        }

        if (q1.getTotalSum().equals(totalSumTarget) && q2.getTotalSum().equals(totalSumTarget))
            answer = q1.getOperationCnt() + q2.getOperationCnt();


        return answer;
    }

    public static void main(String[] args) {

        Solution_try2 solutionTry1Class = new Solution_try2();

        System.out.println(solutionTry1Class.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(solutionTry1Class.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(solutionTry1Class.solution(new int[]{1, 1}, new int[]{1, 5}));
    }
}
