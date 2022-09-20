package GetReportResults;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Solution_2nd_try extends Solution{

    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        LinkedHashMap<String, Set<String>> reportHashMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> reportedInfoHashMap = new LinkedHashMap<>();

        Arrays.stream(id_list).forEach(reporterId -> reportHashMap.put(
                reporterId,
                Arrays.stream(report).filter(reporter -> reporter.startsWith(reporterId)).map(reporter -> reporter.split(" ")[1]).collect(Collectors.toSet())
        ));


        reportHashMap.forEach((reporter, reportedIdSet) -> reportedIdSet.forEach(reportedId -> reportedInfoHashMap.put(reportedId, reportedInfoHashMap.getOrDefault(reportedId, 0) + 1)));


        AtomicInteger index = new AtomicInteger();
        reportHashMap.forEach((reporter, reportedSet) -> {
            if (reportedSet.size() > 0) {
                reportedInfoHashMap.forEach((reportedId, count) -> {
                    if (count >= k && reportedSet.contains(reportedId)) {
                        ++answer[index.get()];
                    }
                });
            }
            index.getAndIncrement();
        });

//        System.out.println("#" + this.getClass().getName());
//        System.out.println(reportHashMap);
//        System.out.println(reportedInfoHashMap);
//        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
        Case testCase = new Case();
        testCase.all(new Solution_2nd_try(), new Solution_guide());
    }
}
