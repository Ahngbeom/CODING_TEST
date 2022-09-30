import java.util.HashMap;
import java.util.Map;


// Reference: https://mathbang.net/46, https://mathbang.net/443, https://jwmath.tistory.com/415, https://m.blog.naver.com/oohyeat05/222137716947
public class Parallel {

    public int solution(int[][] dots) {

        Map<Double, Double> straightInfoMap = new HashMap<>();

        for (int i = 0; i < dots.length - 1; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                // 두 점을 이은 직선의 기울기
                double slope = Math.abs((double) (dots[j][1] - dots[i][1]) / (double) (dots[j][0] - dots[i][0]));
                // 두 점을 이은 직선의 y 절편
                double y_intercept =  ((double) (dots[j][1]) - slope * dots[j][0]);
                if (straightInfoMap.containsKey(slope) && straightInfoMap.get(slope) != y_intercept)
                    return 1;
                straightInfoMap.put(slope, y_intercept);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Parallel parallel = new Parallel();

        System.out.println(parallel.solution(
                new int[][]{
                        {1, 4}, {9, 2}, {3, 8}, {10, 4}
                }
        ));

        System.out.println(parallel.solution(
                new int[][]{
                        {3, 5}, {4, 1}, {2, 4}, {5, 10}
                }
        ));
    }
}
