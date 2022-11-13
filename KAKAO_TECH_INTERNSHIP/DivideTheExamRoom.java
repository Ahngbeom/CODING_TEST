import java.util.*;

public class DivideTheExamRoom {

    public class BinaryTree {
        Node head;
        int size;

        public BinaryTree() {
            head = null;
            size = 0;
        }

        public void push(Node node) {
            if (size == 0) {
                head = node;
            } else {
                Node headNode = head;

                Queue<Node> queue = new LinkedList<>();
                queue.add(headNode);

                while (!queue.isEmpty()) {
                    Node temp = queue.poll();
                }
            }
            size++;
        }
    }

    public int solution(int k, int[] num, int[][] links) {
        int answer = 0;

        Map<Integer, Node> nodeMap = new TreeMap<>();

        for (int i = 0; i < num.length; i++) {
            Node node = new Node(num[i]);
            nodeMap.put(i, node);
        }

//        Arrays.sort(links, (o1, o2) -> {
//          if (o1[0] == o2[0])
//              return -Integer.compare(o1[1], o2[1]);
//          else
//              return -Integer.compare(o1[0], o2[0]);
//        });

//        System.out.println(Arrays.deepToString(links));

        for (int i = 0; i < links.length; i++) {
            if (links[i][0] != -1) {
                nodeMap.get(i).left = nodeMap.get(links[i][0]);
            }
            if (links[i][1] != -1) {
                nodeMap.get(i).right = nodeMap.get(links[i][1]);
            }
        }



        return answer;
    }

    public static void main(String[] args) {
        DivideTheExamRoom divideTheExamRoom = new DivideTheExamRoom();

        System.out.println(divideTheExamRoom.solution(
                3,
                new int[]{12, 30, 1, 8, 8, 6, 20, 7, 5, 10, 4, 1},
                new int[][]{ {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {8, 5}, {2, 10}, {3, 0}, {6, 1}, {11, -1}, {7, 4}, {-1, -1}, {-1, -1} }
        ));
    }
}
