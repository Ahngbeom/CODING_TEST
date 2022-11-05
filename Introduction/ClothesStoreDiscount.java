public class ClothesStoreDiscount {

    public int solution(int price) {
        if (price >= 500000)
            return (int) (price * 0.8);
        else if (price >= 300000)
            return (int) (price * 0.9);
        else if (price >= 100000)
            return (int) (price * 0.95);
        else
            return price;
    }

    public static void main(String[] args) {
        ClothesStoreDiscount clothesStoreDiscount = new ClothesStoreDiscount();

        System.out.println(clothesStoreDiscount.solution(100000));
    }
}