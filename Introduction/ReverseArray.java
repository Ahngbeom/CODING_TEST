import java.util.Arrays;

public class ReverseArray {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];

        for (int i = num_list.length - 1, j = 0; i >= 0; i--, j++) {
            answer[j] = num_list[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        ReverseArray reverseArray = new ReverseArray();

        System.out.println(Arrays.toString(reverseArray.solution(new int[]{1, 2, 3, 4, 5})));
    }
}
