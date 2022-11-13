public class _2 {

    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
        if (months > 0) {
            int assumption = money / 100 * 100;

            if(threshold > assumption)
                return money;
            else {
                int ratio = (assumption - threshold) / ranksize + minratio;
                if (ratio > maxratio)
                    ratio = maxratio;
                int result = (int) (money - (assumption * (ratio / 100.0)));
                return solution(result, minratio, maxratio, ranksize, threshold, --months);
            }
        } else {
            return money;
        }
    }

    public static void main(String[] args) {
        _2 _2 = new _2();

        System.out.println(_2.solution(12345678, 10, 20, 250000, 10000000, 4));
        System.out.println(_2.solution(1000000000, 50, 99, 100000, 0, 6));
        System.out.println(_2.solution(123456789, 0, 0, 1, 0, 360));
    }
}
