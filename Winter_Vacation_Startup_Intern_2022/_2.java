import java.util.*;
import java.util.stream.Collectors;

public class _2 {

    public int solution(int n, int[] student, int[] point) {
        int answer = -1;

        Queue<Integer> genius = new LinkedList<>();
        Queue<Integer> stupid = new LinkedList<>();

        Map<Integer, Integer> studentPointMap = new HashMap<>();

        for (int i = n; i > 0; i--) {
            if (i <= n / 2)
                genius.add(i);
            else
                stupid.add(i);
        }

        for (int i = 0; i < student.length; i++) {
            studentPointMap.putIfAbsent(student[i], 0);
            studentPointMap.put(student[i], studentPointMap.get(student[i]) + point[i]);
            if (!genius.contains(student[i])) {
                stupid.add(genius.remove());
                genius.add(student[i]);
                stupid.remove(student[i]);
            }
            break;
        }


        System.out.println(studentPointMap);
        System.out.println(genius);
        System.out.println(stupid);

        return answer;
    }

    public static void main(String[] args) {
        _2 _2 = new _2();

        _2.solution(6, new int[]{6, 1, 4, 2, 5, 1, 3, 3, 1, 6, 5}, new int[]{3, 2, 5, 3, 4, 2, 4, 2, 3, 2, 2});
    }
}
