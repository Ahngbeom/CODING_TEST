public class LengthOfOverlappingLineSegments {
    public int solution(int[][] lines) {
        int answer = 0;

        for (int i = 0; i < lines.length - 1; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                System.out.println("(" + lines[i][0] + ", " + lines[i][1] + ")" + "(" + lines[j][0] + ", " + lines[j][1] + ")" + ": " + (lines[j][1] - lines[i][0]));
                if (lines[i][0] > lines[j][0] && lines[i][0] < lines[j][1]) {
                    System.out.println("(" + lines[i][0] + ", " + lines[i][1] + ")" + "(" + lines[j][0] + ", " + lines[j][1] + ")" + ": " + (lines[j][1] - lines[i][0]));
                    answer += Math.abs(lines[j][1] - lines[i][0]);
                }
                else if (lines[i][1] > lines[j][0] && lines[i][1] < lines[j][1]) {
                    System.out.println("(" + lines[i][0] + ", " + lines[i][1] + ")" + "(" + lines[j][0] + ", " + lines[j][1] + ")" + ": " + (lines[j][0] - lines[i][1]));
                    answer += Math.abs(lines[j][0] - lines[i][1]);
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        LengthOfOverlappingLineSegments lengthOfOverlappingLineSegments = new LengthOfOverlappingLineSegments();

        System.out.println(lengthOfOverlappingLineSegments.solution(
                new int[][]{
                        {0, 2}, {-3, -1}, {-2, 1}
                }
        ));

        System.out.println(lengthOfOverlappingLineSegments.solution(
                new int[][]{
                        {0, 1}, {2, 5}, {3, 9}
                }
        ));

        System.out.println(lengthOfOverlappingLineSegments.solution(
                new int[][]{
                        {1, -1}, {1, 3}, {9, 3}
                }
        ));

        System.out.println(lengthOfOverlappingLineSegments.solution(
                new int[][]{
                        {0, 5}, {3, 9}, {1, 10}
                }
        ));


    }
}
