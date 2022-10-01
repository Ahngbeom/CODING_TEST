import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class _1 {

    public int solution(int[] array) {
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int value : array) {
            frequency.putIfAbsent(value, 0);
            frequency.put(value, frequency.get(value) + 1);
        }

        List<Integer> frequencyMaxList = new ArrayList<>();

        int frequencyMax = Collections.max(frequency.values());

        frequency.forEach((key, value) -> {
            if (value == frequencyMax)
                frequencyMaxList.add(key);
        });

        if (frequencyMaxList.size() > 1)
            return -1;
        return frequencyMaxList.get(0);
    }

    public static void main(String[] args) {
        _1 _1 = new _1();

        System.out.println(_1.solution(new int[]{1, 2, 3, 3, 3, 4}));
        System.out.println(_1.solution(new int[]{1, 1, 2, 2}));
        System.out.println(_1.solution(new int[]{1}));
    }
}
