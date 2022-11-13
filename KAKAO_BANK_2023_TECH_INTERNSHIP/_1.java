import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class _1 {

    public int[] solution(String logs) {
        int[] answer = new int[24];

        String[] splitLogs = logs.split("\n");

        System.out.println(Arrays.toString(splitLogs));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        for (String log: splitLogs) {
            LocalDateTime localDateTime = LocalDateTime.parse(log, dateTimeFormatter);
            localDateTime = localDateTime.plusHours(9);
            answer[localDateTime.getHour()]++;
        }
        return answer;
    }

    public static void main(String[] args) {
        _1 _1 = new _1();

        System.out.println(Arrays.toString(_1.solution("")));
    }
}
