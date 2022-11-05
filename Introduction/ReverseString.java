public class ReverseString {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();

        for (int i = my_string.length() - 1, j = 0; i >= 0; i--, j++) {
            answer.append(my_string.charAt(i));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();

        System.out.println(reverseString.solution("jaron"));
    }
}
