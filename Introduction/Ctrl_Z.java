import java.util.LinkedList;

public class Ctrl_Z {

    public int solution(String s) {
        int answer = 0;

        LinkedList<Integer> numbers = new LinkedList<>();

        if (!s.isEmpty()) {
            String[] split_s = s.split(" ");

            for (int i = 0; i < split_s.length; i++) {
                if (split_s[i].equals("Z")) {
                    if (i - 1 >= 0 && numbers.size() > 0)
                        numbers.removeLast();
                }
                else
                    numbers.add(Integer.valueOf(split_s[i]));
            }
        }

        for (Integer number : numbers) {
            answer += number;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ctrl_Z ctrl_z = new Ctrl_Z();

        System.out.println(ctrl_z.solution("1 2 Z 3"));
        System.out.println(ctrl_z.solution("10 20 30 40"));
        System.out.println(ctrl_z.solution("10 Z 20 Z 1"));
        System.out.println(ctrl_z.solution("Z Z 20 Z 1"));
        System.out.println(ctrl_z.solution("20 1 Z Z 20"));
    }
}
