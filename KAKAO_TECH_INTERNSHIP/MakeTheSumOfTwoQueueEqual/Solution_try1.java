import java.util.*;

class Solution_try1 extends Solution {



    public Boolean popOnlyOneQueue(QueueData popQueue, QueueData insertQueue, Long twoQueueTotalSum) {
        while (popQueue.getQueue().size() > 0) {
            popQueue.popAndInsert(insertQueue);
            if (popQueue.getTotalSum() == twoQueueTotalSum / 2) {
                return true;
            }
        }
        popQueue.restoreQueue();
        insertQueue.restoreQueue();
        return false;
    }

    public Boolean insertFirstOneElementFromOtherQueue(QueueData popQueue, QueueData insertQueue, Long twoQueueTotalSum) {
        while (popQueue.getQueue().size() > 0) {
            popQueue.popAndInsert(insertQueue);
//            printQueues(popQueue, insertQueue);
            if (popQueue.getTotalSum() < (twoQueueTotalSum / 2)
                    && popQueue.getTotalSum() + insertQueue.getQueue().getFirst() == twoQueueTotalSum / 2) {
                insertQueue.popAndInsert(popQueue);
                return true;
            }
        }
        popQueue.restoreQueue();
        insertQueue.restoreQueue();
        return false;
    }

    public Boolean elementEqualsGoalTotalSum(QueueData popQueue, QueueData insertQueue, Long twoQueueTotalSum) {
        while (popQueue.getQueue().size() - 1 > 0) {
            popQueue.popAndInsert(insertQueue);
            if (insertQueue.getQueue().getLast() == twoQueueTotalSum / 2) {
                while (insertQueue.getQueue().size() > 1) {
                    insertQueue.popAndInsert(popQueue);
                }
                return true;
            }
        }
        popQueue.restoreQueue();
        insertQueue.restoreQueue();
        return false;
    }

    public Boolean forAllCases(QueueData popQueue, QueueData insertQueue, Long twoQueueTotalSum) {
        while (popQueue.getQueue().size() > 0) {
            popQueue.popAndInsert(insertQueue);
//            printQueues(popQueue, insertQueue);
            if (popQueue.getTotalSum() == (twoQueueTotalSum / 2))
                return true;
            else if (popQueue.getTotalSum() > (twoQueueTotalSum / 2)) {
                return forAllCases(insertQueue, popQueue, twoQueueTotalSum);
            }
        }
        popQueue.restoreQueue();
        insertQueue.restoreQueue();
        return false;
    }

    public int makeTheSumOfTwoQueueEqualWithTheLeastOperation(QueueData queue1, QueueData queue2) {
        Long twoQueueTotalSum = (long) (queue1.getTotalSum() + queue2.getTotalSum());

        List<Integer> operCounts = new ArrayList<>();

        if (popOnlyOneQueue(queue1, queue2, twoQueueTotalSum))
            operCounts.add(queue1.getOperationCnt() + queue2.getOperationCnt());
        if (popOnlyOneQueue(queue2, queue1, twoQueueTotalSum))
            operCounts.add(queue1.getOperationCnt() + queue2.getOperationCnt());

        if (insertFirstOneElementFromOtherQueue(queue1, queue2, twoQueueTotalSum))
            operCounts.add(queue1.getOperationCnt() + queue2.getOperationCnt());
        if (insertFirstOneElementFromOtherQueue(queue2, queue1, twoQueueTotalSum))
            operCounts.add(queue1.getOperationCnt() + queue2.getOperationCnt());

        if (elementEqualsGoalTotalSum(queue1, queue2, twoQueueTotalSum))
            operCounts.add(queue1.getOperationCnt() + queue2.getOperationCnt());
        if (elementEqualsGoalTotalSum(queue2, queue1, twoQueueTotalSum))
            operCounts.add(queue1.getOperationCnt() + queue2.getOperationCnt());

        if (forAllCases(queue1, queue2, twoQueueTotalSum))
            operCounts.add(queue1.getOperationCnt() + queue2.getOperationCnt());

        return operCounts.size() > 0 ? Collections.min(operCounts) : -1;
    }

    public int solution(int[] queue1, int[] queue2) {

        QueueData queue1Data = new QueueData(
                new LinkedList<>(Arrays.asList(Arrays.stream(queue1).boxed().toArray(Integer[]::new))),
                Long.valueOf(Arrays.stream(queue1).sum())
        );

        QueueData queue2Data = new QueueData(
                new LinkedList<>(Arrays.asList(Arrays.stream(queue2).boxed().toArray(Integer[]::new))),
                Long.valueOf(Arrays.stream(queue2).sum())
        );

        int answer = makeTheSumOfTwoQueueEqualWithTheLeastOperation(queue1Data, queue2Data);

        return answer;
    }

    public static void main(String[] args) {

        Solution_try1 solutionTry1Class = new Solution_try1();

        System.out.println(solutionTry1Class.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(solutionTry1Class.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(solutionTry1Class.solution(new int[]{1, 1}, new int[]{1, 5}));
    }
}
