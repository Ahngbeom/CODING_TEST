import java.util.*;

class Solution {

    static class QueueData {

        private final LinkedList<Integer> originBackUp;

        private LinkedList<Integer> queue;

//        private LinkedList<Integer> popQueue;

        private int totalSum;

        private int operationCnt;

        private Integer pop() throws RuntimeException {
            Integer popElem = this.queue.pop();
//            if (!popQueue.add(popElem))
//                throw new RuntimeException("Linked List add error");
            totalSum -= popElem;
//            operationCnt += 0.5;
            return popElem;
        }

        private void insert(Integer elem) {
            if (!this.queue.add(elem))
                throw new RuntimeException("Linked List add error");
            totalSum += elem;
//            operationCnt += 0.5;
        }

        public Boolean popAndInsert(QueueData insertTarget) {
            try {
                insertTarget.insert(this.pop());
                this.operationCnt += 1;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        public void restoreQueue() {
            this.queue = new LinkedList<>(originBackUp);
//            this.getPopQueue().clear();
            this.totalSum = 0;
            this.queue.forEach(value -> this.totalSum += value);
            this.operationCnt = 0;
        }

        public void print(String queueName) {
            System.out.print(queueName + "(SUM: " + totalSum + ", Operation: " + operationCnt + "): [ ");
            queue.forEach(value -> System.out.print(value + " "));
            System.out.println("]");
//            System.out.print("] ::: Pop: [ ");
//            popQueue.forEach(value -> System.out.print(value + " "));
//            System.out.println("]");
        }

        public QueueData(LinkedList<Integer> queue, int totalSum) {
            this.originBackUp = new LinkedList<>(queue);
            this.queue = queue;
//            this.popQueue = new LinkedList<>();
            this.totalSum = totalSum;
            this.operationCnt = 0;
        }

        public LinkedList<Integer> getQueue() {
            return queue;
        }

        public int getTotalSum() {
            return totalSum;
        }

        //        public LinkedList<Integer> getPopQueue() {
//            return popQueue;
//        }
//
        public int getOperationCnt() {
            return operationCnt;
        }

    }

    public void printQueues(QueueData queueData1, QueueData queueData2) {
        queueData1.print("Queue1");
        queueData2.print("Queue2");
        System.out.println("===================================================================");
    }

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
                Arrays.stream(queue1).sum()
        );

        QueueData queue2Data = new QueueData(
                new LinkedList<>(Arrays.asList(Arrays.stream(queue2).boxed().toArray(Integer[]::new))),
                Arrays.stream(queue2).sum()
        );

        int answer = makeTheSumOfTwoQueueEqualWithTheLeastOperation(queue1Data, queue2Data);

        return answer;
    }
}

public class Main {

    public static void main(String[] args) {

        Solution solutionClass = new Solution();

        System.out.println(solutionClass.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
        System.out.println(solutionClass.solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2}));
        System.out.println(solutionClass.solution(new int[]{1, 1}, new int[]{1, 5}));
    }

}
