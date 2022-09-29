import java.util.Arrays;

public class Kth_Number {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] subInt = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            System.out.println(Arrays.toString(subInt));
            Arrays.sort(subInt);
            answer[i] = subInt[commands[i][2] - 1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Kth_Number kth_number = new Kth_Number();

        System.out.println(Arrays.toString(kth_number.solution(
                new int[]{1, 5, 2, 6, 3, 7, 4},
                new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}
        )));
    }
}
