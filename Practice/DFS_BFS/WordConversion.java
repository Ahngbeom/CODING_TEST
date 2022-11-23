import java.util.Arrays;
import java.util.Stack;

public class WordConversion {

    static boolean[] visited;
    static Stack<String> depthStack = new Stack<>();
    static int answer = 0;

    public void dfs(int depth, String begin, String target, String[] words) {

        System.out.println(depthStack);

        if (begin.equals(target) && (answer == 0 || answer > depth)) {
            System.out.println("FINISH!!! [" + depth + "]");
            answer = depth;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (visited[i])
                continue;

            for (int j = 0; j < words[i].length(); j++) {
                if (begin.matches(words[i].substring(0, j) + '.' +words[i].substring(j + 1))) {
                    visited[i] = true;
                    depthStack.push(words[i]);
                    dfs(depth + 1, words[i], target, words);
                    visited[i] = false;
                    depthStack.pop();
                }

            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        depthStack.push(begin);
        dfs(0, begin, target, words);
        return answer;
    }

    public static void main(String[] args) {
        WordConversion wordConversion = new WordConversion();

        System.out.println(wordConversion.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
}
