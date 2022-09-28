
// Reference: https://hyojun.tistory.com/entry/Programmers-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-Java
public class TargetNumberWithNode {

    static class Node {
        private final int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public void addFirst(Node next) {
        }

        public void addLast(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getLastNode() {
            Node pointer = this.next;
            if (pointer == null)
                return this;
            while (true) {
                if (pointer.next == null)
                    return pointer;
                pointer = pointer.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder(value + "->");
            Node pointer = this.next;
            while (pointer != null){
                result.append(pointer.getValue()).append("->");
                pointer = pointer.getNext();
            }

            return result.toString().concat("NULL");
        }
    }

    public int dfs(int[] numbers, int target, int depth, int sum) {
        System.out.println("depth: " + depth);
        System.out.println("sum: " + sum);
        if (depth == numbers.length) {
            if (target == sum)
                return 1;
            else
                return 0;
        }
        return dfs(numbers, target, depth + 1, sum + numbers[depth])
                + dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }


    public int solution(int[] numbers, int target) {
        int answer = 0;

        Node node = null;

        node = new Node(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            node.getLastNode().addLast(new Node(numbers[i]));
        }

        System.out.println(node);


        return dfs(numbers, target, 0, 0);
    }

    public static void main(String[] args) {
        TargetNumberWithNode targetNumber = new TargetNumberWithNode();
        System.out.println(targetNumber.solution(
                new int[]{1, 1, 1, 1, 1},
                3
        ));

        System.out.println(targetNumber.solution(
                new int[]{4, 1, 2, 1},
                4
        ));
    }
}