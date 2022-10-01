public class _3 {

    final int[] digit = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    public long matchstick(int k, int sum) {

        for (int i = 0; i < digit.length; i++) {
            if (sum + digit[i] < k) {
                return matchstick(k, sum + digit[i]);
            }
            if (sum + digit[i] == k)
                return 1;
        }
        return 0;
    }

    public long solution(int k) {
        long answer = 0;

        for (int i = 0; i < digit.length; i++) {
            answer += matchstick(k, digit[0]);
        }

        return answer;
    }

    public static void main(String[] args) {
        _3 _3 = new _3();

        System.out.println(_3.solution(11));
    }
}
