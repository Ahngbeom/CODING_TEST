/* 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
   2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
   3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
   4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
   5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
   6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
   7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다. */

public class Solution {

    final boolean PRINT = true;

    public String solution(String new_id) {
        String answer = "";

        if (PRINT)
            System.out.println("new_id: " + new_id);

        for (int i = 1; i <= 7; i++) {
            if (PRINT) System.out.print("STEP " + i + ": ");
            switch (i) {
                case 1 -> {
                    // Step 1: new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
                    answer = new_id.toLowerCase();
                    if (PRINT) System.out.println(answer);
                }
                case 2 -> {
                    // Step 2: new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
                    answer = answer.replaceAll("[^a-z|0-9|\\-_.]", "");
                    if (PRINT) System.out.println(answer);
                }
                case 3 -> {
                    // Step 3: new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
//                    answer = answer.replaceAll("\\.\\.", ".");
                    answer = answer.replaceAll("\\.+", ".");
                    if (PRINT) System.out.println(answer);
                }
                case 4 -> {
                    // Step 4: new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
                    while (answer.startsWith("."))
                        answer = answer.replaceAll("^\\.", "");
                    while (answer.endsWith("."))
                        answer = answer.replaceAll("\\.$", "");
                    if (PRINT) System.out.println(answer);
                }
                case 5 -> {
                    // Step 5: new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
                    if (answer.isEmpty())
                        answer = "a";
                    if (PRINT) System.out.println(answer);
                }
                case 6 -> {
                    /* Step 6: new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
                    만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다. */
                    if (answer.length() >= 16)
                        answer = answer.substring(0, 15).replaceAll("\\.$", "");
                    if (PRINT) System.out.println(answer);
                }
                case 7 -> {
                    // Step 7: new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
                    if (answer.length() <= 2) {
                        while (answer.length() < 3)
                            answer = answer.concat(String.valueOf(answer.charAt(answer.length() - 1)));
                    }
                    if (PRINT) System.out.println(answer);
                }
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        Solution solutionClass = new Solution();

        System.out.println("..".matches("\\.+"));


//        System.out.println(solutionClass.solution("...!@BaT#*..y.abcdefghijklm"));
//        System.out.println(solutionClass.solution("z-+.^."));
//        System.out.println(solutionClass.solution("=.="));
//        System.out.println(solutionClass.solution("123_.def"));
//        System.out.println(solutionClass.solution("abcdefghijklmn.p"));
//        System.out.println(solutionClass.solution("abcdefghijklm..p"));
//        System.out.println(solutionClass.solution("abcdefghijkl__.p"));


        System.out.println(solutionClass.solution("...AHNG_.--//*&#B123**EO+M.."));
    }
}