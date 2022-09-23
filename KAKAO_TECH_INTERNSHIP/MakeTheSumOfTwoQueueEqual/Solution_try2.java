public class Solution_try2 extends Solution {

    public int solution(int[] queue1, int[] queue2) {

        QueueData q1 = new QueueData(queue1);
        QueueData q2 = new QueueData(queue2);

        Long totalSumTarget = (q1.getTotalSum() + q2.getTotalSum()) / 2;
        long limit = (long) (q1.getQueue().size() + q2.getQueue().size()) * 2;

//        printQueues(q1, q2);

        if ((q1.getTotalSum() + q2.getTotalSum()) % 2 != 0)
            return -1;
        if (q1.getQueue().stream().anyMatch(elements -> elements > totalSumTarget)
                || q2.getQueue().stream().anyMatch(elements -> elements > totalSumTarget))
            return -1;

        while (!q1.getTotalSum().equals(totalSumTarget) && !q2.getTotalSum().equals(totalSumTarget)) {

            if (q1.getTotalSum() < totalSumTarget)
                q2.popAndInsert(q1);
            else if (q2.getTotalSum() < totalSumTarget)
                q1.popAndInsert(q2);

            if (q1.getOperationCnt() > limit || q2.getOperationCnt() > limit)
                return -1;

//            printQueues(q1, q2);
        }

        return q1.getOperationCnt() + q2.getOperationCnt();
    }

    public static void main(String[] args) {

        Solution_try2 solutionTry1Class = new Solution_try2();

        System.out.println(solutionTry1Class.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(solutionTry1Class.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(solutionTry1Class.solution(new int[]{1, 1}, new int[]{1, 5}));
//        System.out.println(solutionTry1Class.solution(new int[]{10, 30, 20}, new int[]{5, 10, 15}));
    }
}
