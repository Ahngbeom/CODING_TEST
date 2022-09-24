public class Solution_try2 extends Solution {
    public boolean fastIsPrimeWithSqrt(String n) {
        if (n.isEmpty())
            return false;

        long parseN = Long.parseLong(n);

        if (parseN < 2L)
            return false;
        for (long i = 2L; i <= Math.sqrt(parseN); i++) {
            if (parseN % i == 0) {
                System.out.println(parseN + " = " + i + " * " + parseN / i);
                return false;
            }
        }
        System.out.println(parseN + " is Prime Number");
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;

        String notationResult = Integer.toString(n, k);
        System.out.println(notationResult);

        // "P" 처럼 소수 양쪽에 아무것도 없는 경우 및 P의 각 자릿수가 0이 포함되지 않을 경우
        if (!notationResult.contains("0") && fastIsPrimeWithSqrt(notationResult))
            ++answer;

        int firstZero = notationResult.indexOf("0");
        int lastZero = notationResult.indexOf("0", firstZero + 1);

        while (firstZero != -1 || lastZero != -1) {
//            System.out.println("Zero Index: " + firstZero + ", " + lastZero);

            // "P@" 처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
            if (firstZero != -1 && fastIsPrimeWithSqrt(notationResult.substring(0, firstZero))) {
                ++answer;
            }

            // "@P" 처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
            if (lastZero == -1 && fastIsPrimeWithSqrt(notationResult.substring(firstZero + 1))) {
                ++answer;
            }
            // "@P@" 처럼 소수 양쪽에 0이 있는 경우
            if (firstZero != -1 && lastZero != -1 && fastIsPrimeWithSqrt(notationResult.substring(firstZero + 1, lastZero))) {
                ++answer;
            }

            if (lastZero != -1) {
                firstZero = lastZero;
                lastZero = notationResult.indexOf("0", firstZero + 1);
            } else
                break;

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_try2 solutionClass = new Solution_try2();

//        System.out.println(solutionClass.solution(437674, 3));
//        System.out.println(solutionClass.solution(110011, 10));
//        System.out.println(solutionClass.solution(999, 9));
//        System.out.println(solutionClass.solution(64, 8));
//        System.out.println(solutionClass.solution(99999, 10));
//        System.out.println(solutionClass.solution(2, 3));

        int n = 999999;

        System.out.println(solutionClass.solution(n, 3));
        System.out.println(solutionClass.solution(n, 4));
        System.out.println(solutionClass.solution(n, 5));
        System.out.println(solutionClass.solution(n, 6));
        System.out.println(solutionClass.solution(n, 7));
        System.out.println(solutionClass.solution(n, 8));
        System.out.println(solutionClass.solution(n, 9));
        System.out.println(solutionClass.solution(n, 10));

    }
}
