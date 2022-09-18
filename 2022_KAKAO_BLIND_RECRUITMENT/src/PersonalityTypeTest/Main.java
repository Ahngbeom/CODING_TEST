package PersonalityTypeTest;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Indicators {
    private String type;
    private int score;

    public Indicators(String type, int score) {
        this.type = type;
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}

class Solution {
    public String solution(String[] survey, int[] choices) {

        LinkedHashMap<String, Integer> indicators = new LinkedHashMap<>();
//        Set<Indicators> indicators = new HashSet<>();

        AtomicInteger index = new AtomicInteger();
        Arrays.stream(survey).forEach(sv -> {
            if (choices[index.get()] == 4)
                indicators.put(sv, 0);
            else if (choices[index.get()] < 4)
                indicators.put(sv, -choices[index.getAndIncrement()]);
            else
                indicators.put(sv, choices[index.getAndIncrement()]);
        });

        indicators.forEach((s, integer) -> {
            System.out.println(s + ": " + integer);
        });

        String answer = "";
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solutionClass = new Solution();

        solutionClass.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
    }
}
