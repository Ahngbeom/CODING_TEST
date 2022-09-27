import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Camouflage {
    public int solution1(String[][] clothes) {
        int answer = 0;

        HashMap<String, AtomicInteger> clothesMap = new HashMap<>();

        for (String[] cloth : clothes) {
            clothesMap.putIfAbsent(cloth[1], new AtomicInteger());
            clothesMap.get(cloth[1]).incrementAndGet();
        }

        AtomicInteger combination = new AtomicInteger();

        clothesMap.forEach((cloth, amount) -> {
            System.out.println(cloth + ": " + amount);
            combination.addAndGet(amount.get());
        });

        answer = clothesMap.size() <= 1 ? combination.get() : clothesMap.size() + combination.get();
        return answer;
    }

    public int solution2(String[][] clothes) {
        int answer = 0;

        HashMap<String, AtomicInteger> clothesMap = new HashMap<>();
        Set<String> type = new HashSet<>();


        for (String[] cloth : clothes) {
            type.add(cloth[1]);
            clothesMap.putIfAbsent(cloth[1], new AtomicInteger());
            clothesMap.get(cloth[1]).incrementAndGet();
        }


        int[] amountArray = new int[clothesMap.size()];
        int index = 0;
        for (String typeName : type) {
            answer += clothesMap.get(typeName).get();
            amountArray[index++] = clothesMap.get(typeName).get();
        }


        for (int i = 0; i < amountArray.length - 1; i++) {
            for (int j = i + 1; j < amountArray.length; j++) {
                answer += amountArray[i] * amountArray[j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Camouflage camouflage = new Camouflage();

        System.out.println(camouflage.solution2(
                new String[][]{
                        {"yellow_hat", "headgear"},
                        {"blue_sunglasses", "eyewear"},
                        {"blue_jeans", "pants"},
                        {"long_coat", "outer"},
                        {"green_turban", "headgear"}
                }
        ));

        System.out.println(camouflage.solution2(
                new String[][]{
                        {"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}
                }
        ));

    }
}
