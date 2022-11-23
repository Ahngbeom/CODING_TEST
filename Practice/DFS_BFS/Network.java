import java.util.Arrays;

public class Network {

    public void dfs(int compNum, int[][] computers, boolean[] visited) {

        visited[compNum] = true;
        for (int i = 0; i < computers[compNum].length; i++) {
            if (!visited[i] && computers[compNum][i] == 1) {
                dfs(i, computers, visited);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited =  new boolean[n];

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers, visited);
            }
        }

        System.out.println(Arrays.toString(visited));

        return answer;
    }

    public static void main(String[] args) {

        Network network = new Network();
        System.out.println(network.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(network.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}
