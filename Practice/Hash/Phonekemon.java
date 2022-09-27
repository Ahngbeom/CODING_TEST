import java.util.Arrays;

public class Phonekemon {

    public int solution(int[] nums) {
        int max = nums.length / 2;
        int typeCount = (int) Arrays.stream(nums).distinct().count();

        return Math.min(typeCount, max);
    }

    public static void main(String[] args) {
        Phonekemon phonekemon = new Phonekemon();

        System.out.println(phonekemon.solution(
                new int[]{3, 1, 2, 3}
        ));

        System.out.println(phonekemon.solution(
                new int[]{3,3,3,2,2,4}
        ));

        System.out.println(phonekemon.solution(
                new int[]{3,3,3,2,2,2}
        ));
    }
}
