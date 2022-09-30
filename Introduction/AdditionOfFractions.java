import java.util.Arrays;

public class AdditionOfFractions {

    // Greatest Common Divisor
    public int GCD(int num1, int num2) {
        if (num1 % num2 == 0)
            return num2;
        return GCD(num2, num1 % num2);
    }

    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer;

        denum1 *= num2;
        denum2 *= num1;

        answer = new int[]{denum1 + denum2, num1 * num2};

        int greatest_common_divisor = GCD(answer[0], answer[1]);
        answer[0] /= greatest_common_divisor;
        answer[1] /= greatest_common_divisor;

        return answer;
    }

    public static void main(String[] args) {
        AdditionOfFractions additionOfFractions = new AdditionOfFractions();

        System.out.println(Arrays.toString(additionOfFractions.solution(
                1, 2, 3, 4
        )));
    }
}
