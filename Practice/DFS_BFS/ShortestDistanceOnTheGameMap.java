import java.util.LinkedList;
import java.util.Queue;


// Reference: https://yline.tistory.com/48
public class ShortestDistanceOnTheGameMap {

    public final int[] UP = {0, 1};
    public final int[] RIGHT = {1, 0};
    public final int[] DOWN = {0, -1};
    public final int[] LEFT = {-1, 0};

    public final int[][] SHIFT = {UP, RIGHT, DOWN, LEFT};

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public void printMap(int[][] maps, int[] current) {
        System.out.println("----------------------------------");
        for (int y = 0; y < maps.length; y++) {
            System.out.print("|");
            for (int x = 0; x < maps[y].length; x++) {
                if (x == current[0] && y == current[1])
                    System.out.printf("%c|", 'C');
                else
                    System.out.printf("%d|", maps[y][x]);
            }
            System.out.println();
        }
        System.out.println("----------------------------------");
    }

    public int solution(int[][] maps) {
        int answer;
        Queue<Coordinate> queue = new LinkedList<>();

        queue.offer(new Coordinate(0, 0));

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + SHIFT[i][0];
                int ny = current.y + SHIFT[i][1];
                if (nx >= 0 && nx < maps[0].length
                    && ny >= 0 && ny < maps.length
                    && maps[ny][nx] == 1) {
                    maps[ny][nx] += maps[current.y][current.x];
                    queue.add(new Coordinate(nx, ny));

//                    printMap(maps, new int[]{nx, ny});
                }
            }
        }

        answer = maps[maps.length - 1][maps[0].length - 1];
        if (answer == 1)
            return -1;
        return answer;
    }

    public static void main(String[] args) {
        ShortestDistanceOnTheGameMap gameMap = new ShortestDistanceOnTheGameMap();

        System.out.println(gameMap.solution(
                new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}
        ));
    }
}
