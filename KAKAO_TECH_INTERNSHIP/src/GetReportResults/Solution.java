package GetReportResults;


import java.util.*;

class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        LinkedHashMap<String, Set<String>> reporterInfoMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> reportedInfoMap = new LinkedHashMap<>();
        LinkedHashSet<String> reportToSet = new LinkedHashSet<>(List.of(report));

        for (String reportStr : reportToSet) {
            String [] splitReport = reportStr.split(" ");

            reporterInfoMap.putIfAbsent(splitReport[0], new HashSet<>());
            reporterInfoMap.get(splitReport[0]).add(splitReport[1]);

            reportedInfoMap.put(splitReport[1], reportedInfoMap.getOrDefault(splitReport[1], 0) + 1);

        }

        for (Map.Entry<String, Integer> reportedEntry : reportedInfoMap.entrySet()) {
            if (reportedEntry.getValue() >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (reporterInfoMap.containsKey(id_list[i]) && reporterInfoMap.get(id_list[i]).contains(reportedEntry.getKey())) {
                        ++answer[i];
                    }
                }
            }
        }


//        System.out.println("#" + this.getClass().getName());
//        System.out.println(reporterInfoMap);
//        System.out.println(reportedInfoMap);
//        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
        Case testCase = new Case();
//        testCase.all(new Solution(), new Solution_guide());
        testCase.selectCase(new Solution(), new Solution_guide(), 1);
    }
}
