public class Sum_of_even {
    public int solution(int n) {
        if (n % 2 != 0)
            --n;
        return ((int) Math.pow(n / 2.0, 2)) + (n / 2);
    }

    public static void main(String[] args) {
        Sum_of_even sum_of_even = new Sum_of_even();
        System.out.println(sum_of_even.solution(10));
        System.out.println(sum_of_even.solution(4));
        System.out.println(sum_of_even.solution(5));
    }
}
