public class LambSkewers {
    public int solution(int n, int k) {
        return (n * 12000) + ((k - (n / 10)) * 2000);
    }

    public static void main(String[] args) {
        LambSkewers lambSkewers = new LambSkewers();
        System.out.println(lambSkewers.solution(10, 3));
        System.out.println(lambSkewers.solution(64, 6));
    }
}
