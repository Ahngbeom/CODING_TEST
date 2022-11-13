public class PressTheKeypad {

    public void pressingKeypadByHanded(StringBuilder answer, String handed) {
        if (handed.equals("left")) {
            answer.append("L");
        }
        else {
            answer.append("R");
        }
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();

        int[] leftThumbPos = new int[]{1, 4, 7};
        int[] rightThumbPos = new int[]{3, 6, 9};

        int leftThumbCurrentPos = '*';
        int rightThumbCurrentPos = '#';

        for (int press : numbers) {
            if (press == 1 || press == 4 || press == 7) {
                leftThumbCurrentPos = press;
                answer.append("L");
            } else if (press == 3 || press == 6 || press == 9) {
                rightThumbCurrentPos = press;
                answer.append("R");
            } else {

                if (press == 0) {
                    if (leftThumbCurrentPos == '*' && rightThumbCurrentPos == '#') {
                        if (hand.equals("left")) {
                            leftThumbCurrentPos = press;
                            answer.append("L");
                        }
                        else {
                            rightThumbCurrentPos = press;
                            answer.append("R");
                        }
                    } else if (leftThumbCurrentPos == '*') {

                    } else if (rightThumbCurrentPos == '#') {

                    } else {

                    }
                }

                int distanceWithLeftThumb = Math.abs(press - leftThumbCurrentPos);
                int distanceWithRightThumb = Math.abs(press - rightThumbCurrentPos);




                if (distanceWithLeftThumb % 3 == 0) {
                    distanceWithLeftThumb /= 3;
                }
                if (distanceWithRightThumb % 3 == 0) {
                    distanceWithRightThumb /= 3;
                }

                if (distanceWithLeftThumb == distanceWithRightThumb) {
                    if (hand.equals("left")) {
                        leftThumbCurrentPos = press;
                        answer.append("L");
                    }
                    else {
                        rightThumbCurrentPos = press;
                        answer.append("R");
                    }
                } else if (distanceWithLeftThumb < distanceWithRightThumb){
                    leftThumbCurrentPos = press;
                    answer.append("L");
                } else {
                    rightThumbCurrentPos = press;
                    answer.append("R");
                }
            }

            System.out.println("Press " + press + ": " + leftThumbCurrentPos + ", " + rightThumbCurrentPos);

            System.out.println(answer);
        }


        return answer.toString();
    }

    public static void main(String[] args) {
        PressTheKeypad pressTheKeypad = new PressTheKeypad();

//        System.out.println(pressTheKeypad.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(pressTheKeypad.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
//        System.out.println(pressTheKeypad.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

}
