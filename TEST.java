import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TEST {

    public int solution(String[] s1, String[] s2) {
        int answer = 0;

        Set<String> set = new HashSet<>(List.of(s1));

        for (String s : s2) {
            if (!set.add(s))
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        TEST test = new TEST();

    }
}
