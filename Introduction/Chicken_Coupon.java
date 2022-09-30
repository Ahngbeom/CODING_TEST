public class Chicken_Coupon {

    public int solution(int chicken) {
        int coupon = chicken;
        int service = 0;
        while (coupon >= 10) {
            service += coupon / 10;
            coupon = coupon % 10 + coupon / 10;
//            System.out.println("service: " + service);
//            System.out.println("coupon: " + coupon);
        }

        return service;
    }

    public static void main(String[] args) {
        Chicken_Coupon chicken_coupon = new Chicken_Coupon();

        System.out.println(chicken_coupon.solution(100));
        System.out.println(chicken_coupon.solution(1081));
    }
}
