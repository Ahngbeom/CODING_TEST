public class Solution {

    public int solution(String s) {
        String[] numericEngWords = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
//            System.out.println("find numeric target: " + s.substring(i));
            if ('0' <= s.charAt(i) && '9' >= s.charAt(i)) {
                answer *= 10;
                answer += s.charAt(i) - '0';
            } else {
                for (int j = 0; j < numericEngWords.length; j++) {
                    if (s.startsWith(numericEngWords[j], i)) {
//                        System.out.println("matched word: " + numericEngWords[j]);
                        answer *= 10;
                        answer += j;
                        i += numericEngWords[j].length() - 1;
                        break;
                    }
                }
            }
//            System.out.println("current answer: " + answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution("one4seveneight"));
        System.out.println(solution.solution("23four5six7"));
        System.out.println(solution.solution("2three45sixseven"));
        System.out.println(solution.solution("123"));
    }
}
