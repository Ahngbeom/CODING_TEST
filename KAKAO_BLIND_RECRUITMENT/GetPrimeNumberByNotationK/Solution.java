class Solution {

    public boolean isPrime(String n) {
        if (n.isEmpty())
            return false;

        Long parseN = Long.parseLong(n);

        if (parseN < 2)
            return false;
        for (Long i = 2L; i < parseN; i++) {
//            System.out.println(n + " % " + i + " = " + n % i);
            if (parseN % i == 0)
                return false;
        }
//        System.out.println("[" + n + "] is prime number !!!");
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;

        String notationResult = Integer.toString(n, k);
//        System.out.println(notationResult);

        // "P" 처럼 소수 양쪽에 아무것도 없는 경우 및 P의 각 자릿수가 0이 포함되지 않을 경우
        if (notationResult.matches("^0") && isPrime(notationResult))
            ++answer;

        int firstZero = notationResult.indexOf("0");
        int lastZero = notationResult.indexOf("0", firstZero + 1);

        while (firstZero != -1 || lastZero != -1) {
//            System.out.println("Zero Index: " + firstZero + ", " + lastZero);

            // "P@" 처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
            if (firstZero != -1 && isPrime(notationResult.substring(0, firstZero))) {
                ++answer;
            }

            // "@P" 처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
            if (lastZero == -1 && isPrime(notationResult.substring(firstZero + 1))) {
                ++answer;
            }
            // "@P@" 처럼 소수 양쪽에 0이 있는 경우
            if (firstZero != -1 && lastZero != -1 && isPrime(notationResult.substring(firstZero + 1, lastZero))) {
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
        Solution solutionClass = new Solution();

        System.out.println(solutionClass.solution(437674, 3));
        System.out.println(solutionClass.solution(110011, 10));
    }
}