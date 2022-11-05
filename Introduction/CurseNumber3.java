public class CurseNumber3 {

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            answer++;
            if (answer % 3 == 0 || String.valueOf(answer).contains("3")) {
                i--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CurseNumber3 curseNumber3 = new CurseNumber3();

        System.out.println(curseNumber3.solution(9));
        System.out.println(curseNumber3.solution(15));
        System.out.println(curseNumber3.solution(40));
    }

}
