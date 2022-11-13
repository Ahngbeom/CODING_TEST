import java.util.Arrays;

public class PressTheKeypad2 {

    public void printKeypad(int[][] keypadMatrix, Position left, Position right) {
        for (int i = 0; i < keypadMatrix.length; i++) {
            for (int j = 0; j < keypadMatrix[i].length; j++) {
                if (i == left.x && j == left.y) {
                    System.out.printf("L%-4d", keypadMatrix[i][j]);
                } else if (i == right.x && j == right.y) {
                    System.out.printf("R%-5d", keypadMatrix[i][j]);
                } else {
                    System.out.printf(" %-4d", keypadMatrix[i][j]);
                }
            }
            System.out.println();
        }

    }

    public class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void set(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distance(int x, int y) {
            if (this.x == x && this.y == y)
                return 0;
            if (this.x == x)
                return Math.abs(this.y - y);
            if (this.y == y)
                return Math.abs(this.x - x);
            return Math.abs(this.x - x) + Math.abs(this.y - y);
        }

    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        Position left = new Position(3, 0);
        Position right = new Position(3, 2);

        int[][] keypadMatrix = new int[4][3];
        for (int i = 0; i < keypadMatrix.length; i++) {
            if (i == 3) {
                keypadMatrix[i][0] = '*';
                keypadMatrix[i][1] = 0;
                keypadMatrix[i][2] = '#';
            } else {
                for (int j = 0; j < keypadMatrix[i].length; j++) {
                    keypadMatrix[i][j] = 3 * i + (j + 1);
                }
            }
        }

        for (int pressNum : numbers) {
//            printKeypad(keypadMatrix, left, right);

            int i;
            int j;

            if (pressNum == 0) {
                i = 3;
                j = 1;
            } else {
                i = pressNum % 3 != 0 ? pressNum / 3 : pressNum / 3 - 1;
                j = pressNum % 3 != 0 ? pressNum % 3 - 1 : 2;
            }

//            System.out.println("Press Number: " + keypadMatrix[i][j]);
//            System.out.println("Left Thumb: " + left.x + ", " + left.y + "[distance:" + left.distance(i, j) + " ]");
//            System.out.println("Right Thumb: " + right.x + ", " + right.y + "[distance:" + right.distance(i, j) + " ]");

            if (pressNum == 1 || pressNum == 4 || pressNum == 7) {
                left.set(i, j);
                answer.append("L");
            } else if (pressNum == 3 || pressNum == 6 || pressNum == 9) {
                right.set(i, j);
                answer.append("R");
            } else {
                if (left.distance(i, j) == right.distance(i, j)) {
                    if (hand.equals("left")) {
                        left.set(i, j);
                        answer.append("L");
                    } else {
                        right.set(i, j);
                        answer.append("R");
                    }
                } else {
                    if (left.distance(i, j) < right.distance(i, j)) {
                        left.set(i, j);
                        answer.append("L");
                    } else {
                        right.set(i, j);
                        answer.append("R");
                    }
                }
            }
//            System.out.println(answer);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        PressTheKeypad2 pressTheKeypad = new PressTheKeypad2();

        System.out.println(pressTheKeypad.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(pressTheKeypad.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(pressTheKeypad.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

}
