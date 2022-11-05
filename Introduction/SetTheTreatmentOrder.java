import java.util.*;
import java.util.stream.Collectors;

public class SetTheTreatmentOrder {
    public int[] solution(int[] emergency) {
        List<Integer> descEmergency = Arrays.stream(emergency).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        for (int i = 0; i < emergency.length; i++) {
            emergency[i] = descEmergency.indexOf(emergency[i]) + 1;
        }
        return emergency;
    }

    public static void main(String[] args) {
        SetTheTreatmentOrder setTheTreatmentOrder = new SetTheTreatmentOrder();
        System.out.println(Arrays.toString(setTheTreatmentOrder.solution(new int[]{3, 76, 24})));
    }
}
