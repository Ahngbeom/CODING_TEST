public class _1 {

    public String solution(String line) {
        StringBuilder answer = new StringBuilder();
        char prev = 0;
        for (int i = 0; i < line.length(); i++) {
            if (prev == line.charAt(i)) {
                answer.append("*");
                while (i < line.length() && prev == line.charAt(i)) {
                    i++;
                }
                --i;
            } else {
                answer.append(line.charAt(i));
                prev = line.charAt(i);
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        _1 _1 = new _1();
        System.out.println(_1.solution("aabbccc"));
        System.out.println(_1.solution("helllllo"));
        System.out.println(_1.solution("wonderful"));

    }
}
