import java.util.HashSet;
import java.util.Set;

public class ShortestDistanceOnTheGameMap {

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

	public int dfs(int[][] maps, int x, int y, int distance, Set<String> log) throws InterruptedException {
		Thread.sleep(1000);

//		System.out.println(x + "/" + maps[0].length + ", " + y + "/" + maps.length
//				+ "(distance: " + distance
//				+ ", log: " + log[0] + ", " + log[1] + ")");

		if (x == maps[0].length && y == maps.length)
			return distance;

		if (x < 0 || y < 0)
			return 0;
		if (x > maps[0].length || y > maps.length)
			return 0;
		if (maps[y][x] == 0)
			return 0;

		String current_log = x + " " + y;
		if (log.contains(current_log))
			return 0;
		else
			log.add(current_log);

		printMap(maps, new int[]{x, y});

		return dfs(maps, x + maps[y][x], y, distance + maps[y][x], new HashSet<>(log))
				+ dfs(maps, x, y + maps[y][x], distance + maps[y][x], log)
				+ dfs(maps, x - maps[y][x], y, distance + maps[y][x], log)
				+ dfs(maps, x, y - maps[y][x], distance + maps[y][x], log);
	}

	public int solution(int[][] maps) throws InterruptedException {

		Set<String> distances = new HashSet<>();

//		return 0;
		return dfs(maps, 0, 0, 0, distances);
	}

	public static void main(String[] args) throws InterruptedException {
		ShortestDistanceOnTheGameMap gameMap = new ShortestDistanceOnTheGameMap();

		System.out.println(gameMap.solution(
				new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}
		));
	}
}
