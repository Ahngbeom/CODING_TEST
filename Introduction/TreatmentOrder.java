import java.util.*;

public class TreatmentOrder {

    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        // Key: Emergency
        // Value: Index
        Map<Integer, Integer> emergencyMap = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < emergency.length; i++){
            emergencyMap.put(emergency[i], i);
        }

        System.out.println(emergencyMap);

        return answer;
    }

    public static void main(String[] args) {
        TreatmentOrder treatmentOrder = new TreatmentOrder();

        System.out.println(Arrays.toString(treatmentOrder.solution(
                new int[]{3, 76, 24}
        )));
    }
}
