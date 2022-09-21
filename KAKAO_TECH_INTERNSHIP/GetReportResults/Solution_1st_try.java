import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

class Solution_1st_try extends Solution {

    public LinkedHashMap<String, String[]> reportersToHashMap(String[] id_list, String[] report) {
        LinkedHashMap<String, String[]> reporterHashMap = new LinkedHashMap<>();

        Arrays.stream(id_list).forEach(id -> {

            Stream<String> filteringResult = Arrays.stream(report)
                    .filter(r -> r.endsWith(id) && !r.startsWith(id));
            LinkedHashSet<String> reporterList = new LinkedHashSet<>();
            filteringResult.forEach(s -> reporterList.add(s.substring(0, s.indexOf(" "))));
            reporterHashMap.put(id, reporterList.toArray(new String[0]));
        });

        reporterHashMap.forEach((s, strings) -> {
            System.out.println(s);
            Arrays.stream(strings).forEach(s1 -> System.out.println("\t" + s1));
        });
        return reporterHashMap;
    }

    public void receiveMail(int[] answer, String[] id_list, int k, LinkedHashMap<String, String[]> reporterHashMap) {
        reporterHashMap.forEach((s, strings) -> {
            if (strings.length >= k) {
                Arrays.stream(strings).forEach(reporter -> {
                    AtomicInteger index = new AtomicInteger();
                    Arrays.stream(id_list).forEach(id -> {
                        if (reporter.equals(id))
                            ++answer[index.get()];
                        index.getAndIncrement();
                    });
                });
            }
        });
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        System.out.println(Arrays.toString(id_list));
        System.out.println(Arrays.toString(report));
        System.out.println(k);
        System.out.println("-----------------------------------------------");

        int[] answer = new int[id_list.length];

        LinkedHashMap<String, String[]> reporterHashMap = reportersToHashMap(id_list, report);

        receiveMail(answer, id_list, k, reporterHashMap);


        System.out.println(Arrays.toString(answer));
        System.out.println("===============================================");

        return answer;
    }
}

