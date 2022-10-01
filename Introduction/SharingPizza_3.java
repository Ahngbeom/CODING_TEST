public class SharingPizza_3 {

    public int solution(int slice, int n) {
        if (n % slice == 0)
            return n / slice;
        else
            return n / slice + 1;
    }

    public static void main(String[] args) {
        SharingPizza_3 sharingPizza = new SharingPizza_3();

        System.out.println(sharingPizza.solution(7, 10));
        System.out.println(sharingPizza.solution(4, 12));
    }
}
