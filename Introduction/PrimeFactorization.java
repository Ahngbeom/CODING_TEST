import java.util.Arrays;
import java.util.LinkedHashSet;

public class PrimeFactorization {

    public int[] solution(int n) {
        LinkedHashSet<Integer> primeNumbers = new LinkedHashSet<>();

        int i = 2;
        while (n != 0 && i <= n) {
            if (n % i == 0) {
                primeNumbers.add(i);
                n /= i;
            } else {
                i++;
            }
        }

//        System.out.println(primeNumbers);

        return primeNumbers.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        PrimeFactorization primeFactorization = new PrimeFactorization();

        System.out.println(Arrays.toString(primeFactorization.solution(12)));
        System.out.println(Arrays.toString(primeFactorization.solution(17)));
        System.out.println(Arrays.toString(primeFactorization.solution(420)));
    }
}
