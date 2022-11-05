public class NumberOfOrderedPairs {


    public int solution(int n) {
        int answer = 0;

        int i = 1;
        while (n >= i) {
            if (n % i == 0)
                answer++;
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        NumberOfOrderedPairs numberOfOrderedPairs = new NumberOfOrderedPairs();
        System.out.println(numberOfOrderedPairs.solution(1));
        System.out.println(numberOfOrderedPairs.solution(20));
        System.out.println(numberOfOrderedPairs.solution(100));
    }
}
