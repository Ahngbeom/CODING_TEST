public class Babbling {

    public int solution(String[] babbling) {
        int answer = 0;


        for (String babble : babbling) {
            boolean possible = babble.length() > 1;
            for (int i = 0; i < babble.length() - 1 && possible; i++) {
                for (int j = i + 1; j < babble.length() && possible; j++) {
                    String word = babble.substring(i, j);
                    String remain = babble.substring(j);
                    System.out.print(word + ", " + remain);
                    if (word.equals(remain)) {
                        possible = false;
                        System.out.println(" !!!");
                    } else
                        System.out.println();
                }
            }
            if (possible)
                answer++;
//            if (babble.matches("(\\w)+"))
//                System.out.println(babble);
        }

        return answer;
    }

    public static void main(String[] args) {

        Babbling babbling = new Babbling();

        System.out.println(babbling.solution(
                new String[]{"aya", "yee", "u", "maa"}
        ));

        System.out.println(babbling.solution(
                new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}
        ));
    }
}
