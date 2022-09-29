import java.util.Arrays;

// Reference: https://ivory-room.tistory.com/43

public class LargestNumber {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();


        String[] numberToStr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numberToStr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numberToStr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (numberToStr[0].equals("0"))
            answer.append("0");
        else
            for (String str : numberToStr) answer.append(str);

        return answer.toString();
    }

    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();

        System.out.println(largestNumber.solution(
                new int[]{6, 10, 2}
        ));

        System.out.println(largestNumber.solution(
                new int[]{3, 30, 34, 5, 9}
        ));
    }
}
