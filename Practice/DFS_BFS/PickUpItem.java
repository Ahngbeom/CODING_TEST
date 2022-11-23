public class PickUpItem {

    static int answer = 0;
    public void dfs(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        return answer;
    }

    public static void main(String[] args) {
        PickUpItem pickUpItem = new PickUpItem();

        System.out.println(pickUpItem.solution(
                new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}},
                1,
                3,
                7,
                8
        ));
    }
}
