
// Reference: https://hyojun.tistory.com/entry/Programmers-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-Java
public class TargetNumber {

    public int dfs(int[] numbers, int target, int depth, int sum) {
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
        return dfs(numbers, target, 0, 0);
    }

    public static void main(String[] args) {
        TargetNumber targetNumber = new TargetNumber();
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