import java.util.*;

class Solution_2nd_try extends Solution {

    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        LinkedHashMap<String, Set<String>> reporterHashMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> reportedInfoHashMap = new LinkedHashMap<>();


        Arrays.stream(report).distinct().forEach(reportStr -> {
            String[] splitReport = reportStr.split(" ");
            reporterHashMap.putIfAbsent(splitReport[0], new HashSet<>());
            reporterHashMap.get(splitReport[0]).add(splitReport[1]);
            reportedInfoHashMap.put(splitReport[1], reportedInfoHashMap.getOrDefault(splitReport[1], 0) + 1);
        });


        reportedInfoHashMap.forEach((reportedId, count) -> {
            if (count >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (reporterHashMap.containsKey(id_list[i]) && reporterHashMap.get(id_list[i]).contains(reportedId))
                        ++answer[i];
                }
            }
        });

//        System.out.println("#" + this.getClass().getName());
//        System.out.println(reportHashMap);
//        System.out.println(reportedInfoHashMap);
//        System.out.println(Arrays.toString(answer));

        return answer;
    }
}
