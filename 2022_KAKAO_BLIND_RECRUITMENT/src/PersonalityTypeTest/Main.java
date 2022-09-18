package PersonalityTypeTest;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public String solution(String[] survey, int[] choices) {

        String answer;

        HashMap<String, Integer> indicators = new HashMap<>();
        indicators.put("RT", 0);
        indicators.put("CF", 0);
        indicators.put("JM", 0);
        indicators.put("AN", 0);

        indicators.forEach((type, score) -> {

            AtomicInteger index = new AtomicInteger();
            Arrays.stream(survey).forEach(s -> {
                if (survey[index.get()].matches("(.*)[" + type + "]")) {
//                    System.out.println(survey[index.get()]);

                    int personalityScore = 0;
                    if (choices[index.get()] > 4)
                        personalityScore = survey[index.get()].equals(type) ? (choices[index.get()] % 4) : -(choices[index.get()] % 4);
                    else if (choices[index.get()] < 4)
                        personalityScore = survey[index.get()].equals(type) ? -(4 - choices[index.get()]) : (4 - choices[index.get()]);

                    indicators.put(type, indicators.get(type) + personalityScore);

                }
                index.getAndIncrement();
            });
//            System.out.println(indicators.get(type));

        });

//        System.out.println(indicators);

        answer = String.format("%c%c%c%c",
                indicators.get("RT") <= 0 ? 'R' : 'T',
                indicators.get("CF") <= 0 ? 'C' : 'F',
                indicators.get("JM") <= 0 ? 'J' : 'M',
                indicators.get("AN") <= 0 ? 'A' : 'N'
        );

//        System.out.println(answer);

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solutionClass = new Solution();

        solutionClass.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
        solutionClass.solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3});
    }
}
