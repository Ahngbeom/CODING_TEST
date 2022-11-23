import java.util.LinkedHashSet;
import java.util.Set;

public class RogueUser_lightweight {

    static Set<Set<String>> banUsersCase = new LinkedHashSet<>();
    static Set<String> banUsers = new LinkedHashSet<>();
    public void dfs(int depth, String[] user_id, String[] banned_id) {

//        System.out.println("depth: " + depth);
//        System.out.println(banUsers);

        if (depth == banned_id.length) {
            if (banUsers.size() == banned_id.length) {
//                System.out.println("Correct");
                banUsersCase.add(new LinkedHashSet<>(banUsers));
            }
            return;
        }


        for (int i = 0; i < user_id.length; i++) {
            if (!banUsers.contains(user_id[i]) && user_id[i].matches(banned_id[depth])) {
                banUsers.add(user_id[i]);
                dfs(depth + 1, user_id, banned_id);
                banUsers.remove(user_id[i]);
            }
        }
    }

    public int solution(String[] user_id, String[] banned_id) {

        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace('*', '.');
        }

        dfs(0, user_id, banned_id);
//        System.out.println(banUsersCase);
        return banUsersCase.size();
    }

    public static void main(String[] args) {
        RogueUser_lightweight rogueUser = new RogueUser_lightweight();

        System.out.println(rogueUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
//        System.out.println(rogueUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
//        System.out.println(rogueUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));

//        System.out.println(rogueUser.factorial(5) / (rogueUser.factorial(2) * rogueUser.factorial(3)));
    }
}
