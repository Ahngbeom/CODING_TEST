public class ShortestDistanceOnTheGameMap {
    public int solution(int[][] maps) {
        int answer = 0;



        return answer;
    }

    public static void main(String[] args) {
        ShortestDistanceOnTheGameMap gameMap = new ShortestDistanceOnTheGameMap();

        System.out.println(gameMap.solution(
                new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}
        ));
    }
}
