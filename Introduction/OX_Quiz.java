import java.util.Arrays;

public class OX_Quiz {

//    public String[] solution(String[] quiz) {
//        String[] answer = new String[quiz.length];
//
//        for (int i = 0; i < quiz.length; i++) {
//            String[] handSides = quiz[i].split(" = ");
//            String[] operations = handSides[0].split(" ");
//            Integer result;
//
//            if (operations[1].equals("+"))
//                result = Integer.parseInt(operations[0]) + Integer.parseInt(operations[2]);
//            else
//                result = Integer.parseInt(operations[0]) - Integer.parseInt(operations[2]);
//
//            if (result.equals(Integer.valueOf(handSides[1])))
//                answer[i] = "O";
//            else
//                answer[i] = "X";
//        }
//
//        return answer;
//    }

    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] elements = quiz[i].split(" ");
            Integer result = 0;
            for (int j = 0; j < elements.length; j++) {
                if (j == 0) {
                    result += Integer.parseInt(elements[j]);
                } else if (j == 1) {
                    if (elements[j].equals("+"))
                        result += Integer.parseInt(elements[++j]);
                    else
                        result -= Integer.parseInt(elements[++j]);
                } else if (j == 4) {
                    if (result.equals(Integer.parseInt(elements[j])))
                        answer[i] = "O";
                    else
                        answer[i] = "X";
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        OX_Quiz ox_quiz = new OX_Quiz();

        System.out.println(Arrays.toString(ox_quiz.solution(
                new String[]{"3 - 4 = -3", "5 + 6 = 11"}
        )));

        System.out.println(Arrays.toString(ox_quiz.solution(
                new String[]{"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"}
        )));
    }
}
