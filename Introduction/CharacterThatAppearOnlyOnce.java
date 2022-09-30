import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CharacterThatAppearOnlyOnce {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        HashMap<Character, Integer> searchMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            searchMap.putIfAbsent(s.charAt(i), 0);
            searchMap.put(s.charAt(i), searchMap.get(s.charAt(i)) + 1);
        }

        List<Character> once = new ArrayList<>();
        searchMap.forEach((key, value) -> {
            if (value == 1)
                once.add(key);
        });
        Collections.sort(once);
        for (Character ch : once) {
            answer.append(ch.toString());
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        CharacterThatAppearOnlyOnce characterThatAppearOnlyOnce = new CharacterThatAppearOnlyOnce();

        System.out.println(characterThatAppearOnlyOnce.solution("abcabcadc"));
        System.out.println(characterThatAppearOnlyOnce.solution("abdc"));
        System.out.println(characterThatAppearOnlyOnce.solution("hello"));
    }
}
