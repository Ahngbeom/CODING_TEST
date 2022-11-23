import java.util.*;

public class RogueUser {

    static Set<Set<String>> banUsersCase = new LinkedHashSet<>();
    static List<List<String>> banUsers = new LinkedList<>();

    public void dfs(int depth, Set<String> combinateBanUsers) {


        if (depth == banUsers.size()) {
            System.out.println(combinateBanUsers);
            banUsersCase.add(combinateBanUsers);
            System.out.println(banUsersCase);
            return;
        }

        for (String user : banUsers.get(depth)) {
            if (!combinateBanUsers.contains(user)) {
                combinateBanUsers.add(user);
                dfs(depth + 1, combinateBanUsers);
                combinateBanUsers.remove(user);
            }
        }
    }

    public int solution(String[] user_id, String[] banned_id) {

        for (int i = 0; i < banned_id.length; i++) {
            List<String> matchUsers = new ArrayList<>();
            for (int j = 0; j < user_id.length; j++) {
                if (user_id[j].matches(banned_id[i].replace('*', '.')))
                    matchUsers.add(user_id[j]);
            }
            banUsers.add(matchUsers);
        }

        dfs(0, new LinkedHashSet<>());
        return banUsersCase.size();
    }

    public static void main(String[] args) {
        RogueUser rogueUser = new RogueUser();

//        System.out.println(rogueUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
        System.out.println(rogueUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}));
//        System.out.println(rogueUser.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"}));

//        System.out.println(rogueUser.factorial(5) / (rogueUser.factorial(2) * rogueUser.factorial(3)));
    }
}
