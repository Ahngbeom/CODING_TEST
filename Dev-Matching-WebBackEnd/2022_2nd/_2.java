import java.util.HashMap;

public class _2 {

    public int solution(String[] maps) {
        int answer = 0;

        HashMap<Character, Integer> country = new HashMap<>();

        for (int i = 0; i < maps.length; i++) {

            int limit;
            if (i == 0) {
                limit = maps[i].indexOf(".");
            } else {
                limit = maps[i - 1].indexOf(".");
            }
            if (limit == -1)
                limit = maps[i].length();

            for (int j = 0; j < limit; j++) {
                country.putIfAbsent(maps[i].charAt(j), 0);
                country.put(maps[i].charAt(j), country.get(maps[i].charAt(j)) + 1);
            }

            System.out.println(country);
            break;
        }

        return answer;
    }

    public static void main(String[] args) {
        _2 _2 = new _2();

        System.out.println(_2.solution(
                new String[]{
                        "AABCA.QA",
                        "AABC..QX",
                        "BBBC.Y..",
                        ".A...T.A",
                        "....EE..",
                        ".M.XXEXQ",
                        "KL.TBBBQ"
                }
        ));
    }
}
