import java.util.Arrays;

public class Solution_try2 extends Solution {

    public int solution(int[] queue1, int[] queue2) {

        Long q1TotalSum = (long) Arrays.stream(queue1).sum();
        Long q2TotalSum = (long) Arrays.stream(queue2).sum();
        Long totalSumTarget = (q1TotalSum + q2TotalSum) / 2;


        QueueData q1 = new QueueData(queue1, q1TotalSum);
        QueueData q2 = new QueueData(queue2, q2TotalSum);
        long limit = (long) q1.getQueue().size() * q2.getQueue().size();

//        printQueues(q1, q2);

        if ((q1.getTotalSum() + q2.getTotalSum()) % 2 != 0)
            return -1;
        if (q1.getQueue().stream().anyMatch(elements -> elements > totalSumTarget)
                || q2.getQueue().stream().anyMatch(elements -> elements > totalSumTarget))
            return -1;

        for (int i = 0; i < limit; i++) {
            if (q1.getTotalSum().equals(totalSumTarget) && q2.getTotalSum().equals(totalSumTarget)) {
                return q1.getOperationCnt() + q2.getOperationCnt();
            }
            else if (q1.getTotalSum() < totalSumTarget)
                q2.popAndInsert(q1);
            else if (q2.getTotalSum() < totalSumTarget)
                q1.popAndInsert(q2);

//            printQueues(q1, q2);
        }

        return -1;
    }

    public static void main(String[] args) {

        Solution_try2 solutionTry1Class = new Solution_try2();

        System.out.println(solutionTry1Class.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(solutionTry1Class.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(solutionTry1Class.solution(new int[]{1, 1}, new int[]{1, 5}));
        System.out.println(solutionTry1Class.solution(new int[]{10, 30, 20}, new int[]{5, 10, 15}));
    }
}
