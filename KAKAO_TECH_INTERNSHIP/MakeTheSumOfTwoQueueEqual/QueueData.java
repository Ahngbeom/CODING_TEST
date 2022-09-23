import java.util.Arrays;
import java.util.LinkedList;

public class QueueData {
    private final LinkedList<Integer> originBackUp;

    private LinkedList<Integer> queue;

    private Long totalSum;

    private int operationCnt;

    private Integer pop() throws RuntimeException {
        Integer popElem = this.queue.pop();
        totalSum -= popElem;
        return popElem;
    }

    private void insert(Integer elem) {
        if (!this.queue.add(elem))
            throw new RuntimeException("Linked List add error");
        totalSum += elem;
    }

    public void popAndInsert(QueueData insertTarget) {
        try {
            insertTarget.insert(this.pop());
            this.operationCnt += 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void restoreQueue() {
        this.queue = new LinkedList<>(originBackUp);
        this.totalSum = 0L;
        this.queue.forEach(value -> this.totalSum += value);
        this.operationCnt = 0;
    }

    public void print(String queueName) {
        System.out.print(queueName + "(SUM: " + totalSum + ", Operation: " + operationCnt + "): [ ");
        queue.forEach(value -> System.out.print(value + " "));
        System.out.println("]");
    }

    public QueueData(LinkedList<Integer> queue, Long totalSum) {
        this.originBackUp = new LinkedList<>(queue);
        this.queue = queue;
        this.totalSum = totalSum;
        this.operationCnt = 0;
    }

    public QueueData(int[] queue) {
        LinkedList<Integer> integerQueue = new LinkedList<>(Arrays.asList(Arrays.stream(queue).boxed().toArray(Integer[]::new)));
        this.originBackUp = new LinkedList<>(integerQueue);
        this.queue = integerQueue;
        this.totalSum = 0L;
        integerQueue.forEach(elements -> this.totalSum += (long) elements);
        this.operationCnt = 0;
    }

    public LinkedList<Integer> getQueue() {
        return queue;
    }

    public Long getTotalSum() {
        return totalSum;
    }

    public int getOperationCnt() {
        return operationCnt;
    }
}
