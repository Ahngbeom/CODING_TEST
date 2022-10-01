public class SharingPizza_2 {
    public int GCD(int num1, int num2) {
        if (num1 % num2 == 0)
            return num2;
        return GCD(num2, num1 % num2);
    }

    public int LCM(int num1, int num2) {
        return num1 * num2 / GCD(num1, num2);
    }

    public int solution(int n) {
        return LCM(n, 6) / 6;
    }

    public static void main(String[] args) {
        SharingPizza_2 sharingPizza = new SharingPizza_2();

        System.out.println(sharingPizza.solution(6));
        System.out.println(sharingPizza.solution(10));
        System.out.println(sharingPizza.solution(4));
    }
}
