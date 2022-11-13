import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Integer, List<Integer>> tupleMap = new TreeMap<>();

        for (int i = 0; i < s.length();) {
            while (s.charAt(i) == '{' || s.charAt(i) == ',')
                i++;
            int setCloseBraceIndex = s.indexOf('}', i);
            String tupleSet = s.substring(i, setCloseBraceIndex);
            if (tupleSet.isEmpty())
                break;
//            System.out.println("closed set brace: " + setCloseBraceIndex);

            String[] splitSet = tupleSet.split(",");
//            System.out.println("Split Tuple Set (String): " + Arrays.toString(splitSet));

            List<Integer> toIntegerList = new LinkedList<>();
            for (int j = 0; j < splitSet.length; j++) {
                toIntegerList.add(Integer.parseInt(splitSet[j]));
            }

//            System.out.println("Split Tuple Set (int): " + toIntegerList);

            tupleMap.put(toIntegerList.size(), toIntegerList);

            i = setCloseBraceIndex + 1;

        }

        Set<Integer> answer = new LinkedHashSet<>();

//        System.out.print("Tuple Map: ");
        tupleMap.forEach((integer, ints) -> {
            answer.addAll(ints);
//            System.out.println(integer  + "," + ints);
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
    }
}