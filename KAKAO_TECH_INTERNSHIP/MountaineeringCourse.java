import java.util.*;

public class MountaineeringCourse {

    public class Course {
        int dest;
        int distance;

        public Course(int dest, int distance) {
            this.dest = dest;
            this.distance = distance;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};

        Map<Integer, List<Course>> courseMap = new TreeMap<>();

        for (int[] path: paths) {
            courseMap.putIfAbsent(path[0], new ArrayList<>());
            courseMap.get(path[0]).add(new Course(path[1], path[2]));
        }

        String path;





        return answer;
    }

    public static void main(String[] args) {
        MountaineeringCourse mountaineeringCourse = new MountaineeringCourse();

        System.out.println(Arrays.toString(mountaineeringCourse.solution(
                6,
                new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}},
                new int[]{1, 3},
                new int[]{5}
        )));
    }
}
